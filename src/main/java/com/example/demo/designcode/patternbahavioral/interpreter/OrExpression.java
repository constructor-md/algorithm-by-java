package com.example.demo.designcode.patternbahavioral.interpreter;

/**
 * 具体规则
 * 定义了传入的规则相互某关系的结果，该关系的规则本类定义
 */
public class OrExpression implements Expression  {

    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2){
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
