package DesignPattern.BuliderPattern;

public abstract class Builder {

    abstract void buildChip();

    abstract void buildScreen();

    abstract void buildOS();

    abstract Phone createPhone();

    public Phone construct(){
        this.buildChip();
        this.buildScreen();
        this.buildOS();
        return createPhone();
    }
}
