package DesignPattern.StrategyPattern;


import org.springframework.stereotype.Service;

@Service
public class Cat extends AbstractAnmal{


    @Override
    void say() {
        testsss.setTest(1);
        System.out.println("miao"+ testsss.getTest());
    }

    @Override
    Integer getType() {
        return 1;
    }
}
