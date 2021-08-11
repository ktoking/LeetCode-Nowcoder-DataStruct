package DesignPattern.StrategyPattern;

import org.springframework.stereotype.Service;

@Service
public class TwoType implements TypeStrategy{

    @Override
    public String doSomething(Integer type) {
        return "two string return";
    }

    @Override
    public Integer getType() {
        return 2;
    }

}
