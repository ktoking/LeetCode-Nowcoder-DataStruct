package DesignPattern.MediatorPattern;

import org.springframework.stereotype.Component;

@Component
public class TrainThree implements Train{

    @Override
    public void sendMessage() {
        System.out.println("三号火车收到消息!");
    }
}
