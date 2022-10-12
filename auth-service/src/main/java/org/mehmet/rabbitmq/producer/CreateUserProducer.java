package org.mehmet.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import org.mehmet.rabbitmq.model.CreateUser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {
    /**
     * Mesaj iletmek için rabbit template kullanıyoruz
     */
    private final RabbitTemplate rabbitTemplate;

    public void sendCreateUserMessage(CreateUser user){

        rabbitTemplate.convertAndSend("exchange-auth","key-auth",user);

    }



}
