package com.zidi.pre_crm_project_2025.Dynamic_Proxy.Dynamic_Proxy.service;
import com.zidi.pre_crm_project_2025.Dynamic_Proxy.Dynamic_Proxy.service.impl.HelloImpl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestHello {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SayHello sayHello = new HelloImpl();

        sayHello.sayHello("zidi");

        // 使用反射机制去执行 sayHello 方法
        SayHello target = new HelloImpl();
        // 核心是 Method 类
        Method method = HelloImpl.class.getMethod("sayHello", String.class);
        // 通过method 可以执行
        // 参数 : 1. Object 标识 对象
        // 2. 方法执行时候的参数值
        // method invoke 表达的意思是: 我们要自信 target 对象的 sayHello 的方法, 参数是 lisi
        // method 表达的就是 sayHello 的方法
        // 然后我们要把 method 关联到 target 这个对象
        Object ret = method.invoke(target,"lisi");


    }
}
