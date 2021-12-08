package DesignPattern.StrategyPattern;

import org.springframework.stereotype.Service;

@Service
public class Dog extends AbstractAnmal{
    @Override
    void say() {
        testsss.setTest(2);
        System.out.println("wang"+ testsss.getTest());
    }

    @Override
    Integer getType() {
        return 2;
    }
}
