package DesignPattern.BuliderPattern;

public class IphoneBuilder extends Builder{

    Phone phone=new Phone();

    @Override
    void buildChip() {
        phone.setChip("A15");
    }

    @Override
    void buildScreen() {
        phone.setScreen("LTPO");
    }

    @Override
    void buildOS() {
        phone.setOs("IOS");
    }

    @Override
    Phone createPhone() {
        return phone;
    }
}
