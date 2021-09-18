package DesignPattern.BuliderPattern;

import org.springframework.stereotype.Component;

public class Director {

    private Builder phoneBuilder;

    public Director(Builder builder) {
        this.phoneBuilder = builder;
    }

    public Phone contruct(){
        phoneBuilder.buildOS();
        phoneBuilder.buildScreen();
        phoneBuilder.buildChip();
        return phoneBuilder.createPhone();
    }

    public static void main(String[] args) {
        showPhone(new IphoneBuilder());
        showPhone(new XiaoMiBuilder());
    }

    private static void showPhone(Builder builder){
        Director director=new Director(builder);
        Phone contruct = director.contruct();
        System.out.println(contruct);
    }
}
