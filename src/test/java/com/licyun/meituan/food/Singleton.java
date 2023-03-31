package com.licyun.meituan.food;

public class Singleton {

    private volatile static Singleton singleton;

    private Singleton () {}

    private static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class) {
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
