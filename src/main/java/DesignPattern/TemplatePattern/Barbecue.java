package DesignPattern.TemplatePattern;

public class Barbecue extends AbstractMeal{


    @Override
    protected void eat() {
        System.out.println("吃了烧烤");
    }

    @Override
    protected void payTheBill() {
        System.out.println("付了烧烤钱");
    }
}
