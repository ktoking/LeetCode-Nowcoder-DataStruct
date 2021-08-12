package DesignPattern.MediatorPattern;

import org.springframework.stereotype.Component;

@Component
public class TrainTwo implements Train{

    @Override
    public void sendMessage() {
        System.out.println("二号火车收到消息!");
    }
}
