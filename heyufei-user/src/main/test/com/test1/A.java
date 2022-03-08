package com.test1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class A {

    protected transient int tree=20;

    public int getTree() {
        return tree;
    }

    public void setTree(int tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {

        SmsService smsService = (SmsService) MyInvocationHandler.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }


}


/**
 * 自动生成代理类
 */
class MyInvocationHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 处理代理实例,返回结果
     * @param method 反射执行的方法，可以用method.getName()得到方法名
     * @return 实体类
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());

        Object result = method.invoke(target, args);

        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new MyInvocationHandler(target)// 代理对象对应的自定义 InvocationHandler
        );
    }

}
interface SmsService {
    String send(String message);
}

class SmsServiceImpl implements SmsService {

    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}


