package com.example.demo.designcode.patterncreate.prototype;


/**
 * 抽象类
 * 实现{@link Cloneable}接口
 *
 */
public abstract class AbstractShape implements Cloneable{

    private String id;
    protected  String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void draw();

    @Override
    protected Object clone() {

        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException c){
            c.printStackTrace();
        }
        return clone;
    }
}
