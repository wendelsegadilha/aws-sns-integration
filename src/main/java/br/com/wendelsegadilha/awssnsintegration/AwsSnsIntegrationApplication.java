package br.com.wendelsegadilha.awssnsintegration;

import br.com.wendelsegadilha.awssnsintegration.model.User;
import io.awspring.cloud.sns.core.SnsTemplate;
import io.awspring.cloud.sns.core.TopicArnResolver;
import io.awspring.cloud.sns.core.TopicsListingTopicArnResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import software.amazon.awssdk.services.sns.SnsClient;

@SpringBootApplication
public class AwsSnsIntegrationApplication implements CommandLineRunner {
    // https://docs.awspring.io/spring-cloud-aws/docs/3.0.0/reference/html/index.html#spring-cloud-aws-sns
    @Autowired
    private SnsTemplate snsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AwsSnsIntegrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String topic = "springbootsns";

        User user = new User(1, "Wendel");
        //snsTemplate.sendNotification(topic, "Teste", null);
        snsTemplate.convertAndSend(topic, user);
    }
}
