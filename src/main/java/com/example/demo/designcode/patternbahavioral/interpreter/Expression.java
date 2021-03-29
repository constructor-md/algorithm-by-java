package com.example.demo.designcode.patternbahavioral.interpreter;

/**
 * 抽象规则
 */
public interface Expression {

    boolean interpret(String context);

}
