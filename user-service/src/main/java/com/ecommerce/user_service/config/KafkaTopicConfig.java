package com.ecommerce.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public static final String USER_TOPIC = "user-created-events";

    @Bean
    public NewTopic userEventsTopic() {
        return TopicBuilder.name((USER_TOPIC))
                .partitions(3)
                .replicas(1)
                .build();
    }
}
