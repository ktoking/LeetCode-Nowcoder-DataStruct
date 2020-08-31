package DesignPattern.SingletonDemo;

import JUC.Singleton;

/**
 * 单例模式 DCL双端校验锁
 */
public class SingleTon {
    private volatile static SingleTon singleTon;
    private SingleTon(){};

    public static SingleTon getInstance(){
        if(singleTon==null){
            synchronized (SingleTon.class){
                if(singleTon==null){
                    singleTon=new SingleTon();
                }
            }
        }
        return singleTon;
    }
}

