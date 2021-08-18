package DesignPattern.TemplatePattern;

public class HotPot extends AbstractMeal{

    @Override
    protected void eat() {
        System.out.println("吃了火锅");
    }

    @Override
    protected void payTheBill() {
    }
}
