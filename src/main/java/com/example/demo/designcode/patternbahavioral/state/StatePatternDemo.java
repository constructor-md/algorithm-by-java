package com.example.demo.designcode.patternbahavioral.state;

/**
 * 状态模式
 *
 * 允许对象在内部状态发生变化时，改变对象的行为，就好像改变了类一样
 * 可以解决消除大量if else的问题
 * 适用于行为随状态改变的方法，条件、分支语句的替代者
 *
 * 优点：封装了转换规则，美剧可能的状态。可以将所有与某个状态相关的行为都放到一个类中，可以方便的增加新的状态
 * 在改变对象状态时，就可以改变对象的行为
 * 状态转换逻辑和状态对象合为一体，而不是一个巨大的条件语句块
 * 多个环境可以共享一个状态对象，减少对象个数
 *
 * 缺点：由于让多个环境共享状态对象，会增加状态类的个数。实现复杂，实现不佳导致代码混乱
 * 不符合开闭模式，如果需要增加状态，需要修改状态转换类的源代码，都则不能切换到新状态，修改状态行为也需要修改对应源代码
 *
 * 行为受到状态约束时使用，且状态最好不要超过五个
 *
 * 应用：
 *
 * todo 扩展状态机的实现 Spring State Machine与状态模式
 * Spring状态机实际上封装了状态转换的内容，允许定义各种状态，并定义其触发事件，以及转换的下一个状态等
 * 状态转换流程封装后，状态行为可以对应定义，并通过上下文执行（todo 没看源码要写demo学习）
 *
 *
 *
 */
public class StatePatternDemo {


    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        //传入Context，修改了Context类的状态为StartState，进而执行方法时不同了，因为调用的是不同状态类的方法
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

}
