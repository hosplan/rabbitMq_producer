package com.example.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


//Queue 로 메세지를 발행할 때에는 RabbitTemplate 의 ConvertAndSend 메소드사용
//Queue 에서 메세지를 구독할때는 @RabbitListener를 사용
@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitMqService {
    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    //Queue로 메세지를 발행
    //Producer 역할 -> Direct Exchange 전략
    public void sendMessage(RabbitMessage rabbitMessage){
        log.info("message send : {}", rabbitMessage.toString());
        System.out.println("routingKey = " + routingKey);
        System.out.println("exchangeName = " + exchangeName);
        this.rabbitTemplate.convertAndSend(exchangeName, routingKey, rabbitMessage);
    }

    //Queue에서 메세지 구독
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessage(RabbitMessage rabbitMessage){
        log.info("Received Message : {}", rabbitMessage.toString());
    }
}
