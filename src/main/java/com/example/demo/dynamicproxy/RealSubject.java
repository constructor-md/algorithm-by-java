package com.example.demo.dynamicproxy;

public class RealSubject implements Subject{


    @Override
    public String sayHello(String content) {
        return "hello~ xxx , "+content;
    }

    @Override
    public String sayBye(String content) {
        return "Bye~ xxx , "+content;
    }
}
