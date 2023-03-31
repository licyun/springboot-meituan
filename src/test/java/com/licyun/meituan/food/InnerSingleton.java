package com.licyun.meituan.food;

public class InnerSingleton {

    private InnerSingleton () {}

    public static InnerSingleton getInstance(){
        return Inner.instance;
    }

    private static class Inner{
        private static final InnerSingleton instance = new InnerSingleton();
    }

}
