package com.zidi.pre_crm_project_2025.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;
    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session  = null;
        Object obj = null;

        try{
//            session = SqlSessionUtil.getSession();
//            SqlSessionUtil util = new SqlSessionUtil();
            session = SqlSessionUtil.getSession();

        }catch(Exception e){
            e.printStackTrace();
        } finally {
            SqlSessionUtil.closeSession();
        }
        return obj;
    }
}
