package com.example.demo.designcode.patterncreate.builder;

/**
 * 使用静态内部类建造类的方式，隐藏了类的setter方法，是lombok的@Builder实现
 * 扩展：@Builder 中使用 @Singular 注释集合
 * 扩展：需要了解静态内部类方位特性
 * 扩展：@Builder.Default 当我在使用这个实体对象时，我就不需要在为这两个字段进行初始化值
 */
public class User {

    private String name;
    private int age;
    private String nickname;

    //写一个全参构造器供建造者类调用，最终形成对象
    User(String name, int age, String nickname){
        this.age = age;
        this.name = name;
        this.nickname = nickname;
    }

    //值的设置都放在建造者类中，防止了对象内容被修改
    public static class UserBuilder{
        //建造者静态类和目标了具备一样的属性
        private String name;
        private int age;
        private String nickname;

        UserBuilder(){}

        //以属性名做方法名，并每次都返回建造者类本身
        public User.UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public User.UserBuilder age(int age){
            this.age = age;
            return this;
        }

        public User.UserBuilder nickname(String nickname){
            this.nickname = nickname;
            return this;
        }

        public User builder(){
            return new User(this.name, this.age, this.nickname);
        }

    }


}
