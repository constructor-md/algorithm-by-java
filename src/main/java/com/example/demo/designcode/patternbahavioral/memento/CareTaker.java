package com.example.demo.designcode.patternbahavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 备忘录管理类
 *
 * 维护所有的状态信息，支持设置和取出
 *
 * 负责人负责保存备忘录，但是不能对备忘录的内容进行操作或检查。它只负责存储对象，而不能修改对象，也无须知道对象的实现细节
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }


}
