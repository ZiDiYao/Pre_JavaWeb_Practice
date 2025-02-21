package com.zidi.pre_crm_project_2025.Dynamic_Proxy.Dynamic_Proxy.service.impl;

import com.zidi.pre_crm_project_2025.Dynamic_Proxy.Dynamic_Proxy.service.SayHello;

public class HelloImpl implements SayHello {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + " " + name);

    }
}
