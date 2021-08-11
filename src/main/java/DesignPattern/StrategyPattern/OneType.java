package DesignPattern.StrategyPattern;

import org.springframework.stereotype.Service;

@Service
public class OneType implements TypeStrategy{

    @Override
    public String doSomething(Integer type) {
        return "one string return";
    }

    @Override
    public Integer getType() {
        return 1;
    }
}
