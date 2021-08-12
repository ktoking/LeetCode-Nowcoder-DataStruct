package DesignPattern.MediatorPattern;

import org.springframework.stereotype.Component;

@Component
public class TrainOne implements Train{

    @Override
    public void sendMessage() {
        System.out.println("一号火车收到消息！");
    }
}
