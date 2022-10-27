package org.mehmet.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mehmet.rabbitmq.model.CreateUser;
import org.mehmet.repository.entity.UserProfile;
import org.mehmet.service.UserProfileService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUserConsumer {

    private final UserProfileService userProfileService;

    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserMessageConsumer(CreateUser user){
        log.info("User received: {}", user.toString());
        userProfileService.save(UserProfile.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .username(user.getUsername())
                        .authid(user.getAuthid())
                        .build());

    }



}
