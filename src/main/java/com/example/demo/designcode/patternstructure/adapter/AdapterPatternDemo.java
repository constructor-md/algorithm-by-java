package com.example.demo.designcode.patternstructure.adapter;


/**
 * 适配器模式
 *
 * 如解决正在服役的项目的兼容问题，或为一些可能在将来加入使用的不同内容做统一处理等
 *
 * 将不能对接的两个接口对接工作
 * 如读卡器之余内存卡和电脑
 *
 * 关键代码： 适配器继承/依赖（关联）了已有的类（关联-类似维护一个对象在适配器类中作为属性供调用
 * （依赖的方式，可以方便并行扩展适配的广度）
 * 适配器实现了想要的目标接口，用户将通过目标接口调用合适的方法
 *
 * 类适配器：通过继承完成  对象适配器：通过关联完成
 * 类适配器可以替换原方法，有些灵活性，但是Java单继承，只能做一个适配器
 * 对象适配器则可以把多个适配者适配成同一个目标
 *
 * 优点：让无关的两个类组合运行，增加了类的复用和透明度，灵活性好
 * 缺点：适配器过多使用会使系统凌乱，不好整体把握，如明明是调用A接口，内部给适配实现成了B接口的调用
 *
 * 应用：SpringAop中的适配器
 *
 * Spring的Aop中，使用的 Advice（通知） 来增强被代理类的功能。
 * Advice的类型有：MethodBeforeAdvice、AfterReturningAdvice、ThrowsAdvice
 *
 * 每个都有自己的拦截器，Spring需要把每个Advice都找到拦截器类型，返回给容器
 * 如何用一个方法创建多种Advice的拦截器？
 *
 * AdvisorAdapter 接口中的两个方法
 * 1.判断Advice类习惯是否匹配
 * boolean supportsAdvice(Advice var1);
 * 2. 创建对应拦截器
 * MethodInterceptor getInterceptor(Advisor var1);
 *
 * 为每种Advice都对该接口写一个实现类
 * 实现类中分别判断本类型的Advice和拦截器
 *  （理解时注意 Advisor中包含了Advice对象，实际传入的时Advisor，能获取到Advice即可）
 * 在DefaultAdvisorAdapterRegistry中，类创建时将三种适配器都加入维护的List<AdvisorAdapter>列表中
 * 当调用该类的获取拦截器方法时，根据传入的Advisor获取Advice，即可循环调用List中AdvisorAdapter的方法判断类型，最终调用创建对应类型的拦截器
 *
 * 可以说DefaultAdvisorAdapterRegistry既是使用了对象适配器，以抽象接口的方式维护了各个Advice对象
 * 然后在调用方和各个Advice之间提供的适配方法就是这个获取拦截器方法，使得可以根据传入参数的类型创建对应的拦截器返回容器
 *
 *
 *
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        //内部使用一个适配器支持各种不同格式的播放，通往不同的调用方法
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

}
