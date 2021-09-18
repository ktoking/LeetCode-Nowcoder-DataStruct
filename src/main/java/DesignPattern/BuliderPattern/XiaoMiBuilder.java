package DesignPattern.BuliderPattern;

public class XiaoMiBuilder extends Builder{

    Phone phone=new Phone();

    @Override
    void buildChip() {
        phone.setChip("骁龙888");
    }

    @Override
    void buildScreen() {
        phone.setScreen("康宁大猩猩");
    }

    @Override
    void buildOS() {
        phone.setOs("安卓");
    }

    @Override
    Phone createPhone() {
        return phone;
    }
}
