package com.example.demo.designcode.patternstructure.proxy;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("RealImage");
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }


}
