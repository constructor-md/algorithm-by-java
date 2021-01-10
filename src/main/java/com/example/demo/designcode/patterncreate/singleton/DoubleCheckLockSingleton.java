package com.example.demo.designcode.patterncreate.singleton;

/**
 * 双检锁式单例模式，线程安全
 */
public class DoubleCheckLockSingleton {

    private static volatile DoubleCheckLockSingleton instance;

    private DoubleCheckLockSingleton(){}

    public static DoubleCheckLockSingleton getInstance(){
        if (instance == null){
            synchronized (DoubleCheckLockSingleton.class){
                if (instance == null){
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }

    /*
     * 继承了懒汉式的lazy loading方式，只在需要用到时才创建对象
     * 为了实现方法被调用时才创建对象的特点，该方法可能被多个线程调用
     * 可能有两个线程进入第一个if，一个得到了锁，创建对象，释放锁
     * 然后第二个得到锁，进入方法体，如果此时不校验，则会产生两个对象，这就是校验两次的原因 双检锁
     *
     * volatile的解释，主要禁止了指令重排序，但是此处可能产生JVM优化导致的代码顺序变化，如同步块外面的代码被移动到里面执行，具体见链接
     * 另外，不是所有的JVM都正确实现了volatile 结论就是 无论何种情况下，都尽量不要使用双检索形式，因为可能导致偶发的难以检测的异常
     * https://blog.csdn.net/chenchaofuck1/article/details/51702129?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.control
     *
     * 具体的理解需要深入指令重排序、内存模型、volatile的实现效果
     */


}
