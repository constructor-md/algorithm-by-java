package com.example.demo.designcode.patternbahavioral.interpreter;


/**
 * 解释器模式
 *    行为型模式
 *
 *  可拓展性好，增加了新的解释表达式的方式，容易实现简单文法
 *
 *  复杂文法难以维护，且拓展特别容易因为文法和规则的增加导致类膨胀
 *
 *  解释器模式采用递归调用方法层层解释，最终每一个规则的结果返回汇集成文法解释结果的递归
 *  每个解释器只有一个递归方法，继承于解释器接口，易拓展
 *
 *  阿里有规则引擎Express  java有expression4J代替直接实现
 *
 *  场景： 编译器和运算表达式的解析
 *
 *
 */
public class InterpreterPatternDemo {

    //规则： robert 和 john是男性
    public static Expression getMaleExpression(){
        Expression robert = new TerminalExpression("robert");
        Expression john = new TerminalExpression("john");

        return new OrExpression(robert, john);
    }

    //规则：Julie 是一个已婚的女性
    public static Expression getMarriedWomanExpression(){
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));
    }

}
