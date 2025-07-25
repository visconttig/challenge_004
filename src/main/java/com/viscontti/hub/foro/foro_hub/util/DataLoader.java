package com.viscontti.hub.foro.foro_hub.util;

import com.viscontti.hub.foro.foro_hub.data.repository.CourseRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.TopicRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.UserRepository;
import com.viscontti.hub.foro.foro_hub.model.Course;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(TopicRepository topicRepo,
                               UserRepository userRepo,
                               CourseRepository courseRepo) {
        return args -> {
            // Create a test user
            User user = new User();
            user.setName("Jane Doe");
            user.setPassword("test123");
            userRepo.save(user);

            // Create a test course
            Course course = new Course();
            course.setName("Spring Boot");
            course.setCategory("Programming");
            courseRepo.save(course);

            // Create test topics
            for (int i = 1; i <= 5; i++) {
                Topic topic = new Topic();
                topic.setTitle("Sample Topic " + i);
                topic.setMessage("This is the content of topic " + i);
                topic.setCreatedDate(new Date());
                topic.setStatus("OPEN");
                topic.setAuthor(user);
                topic.setCourse(course);
                topic.setAnswersList(new ArrayList<>());
                topicRepo.save(topic);
            }

            System.out.println("✅ Sample data loaded.");
        };
    }
}
