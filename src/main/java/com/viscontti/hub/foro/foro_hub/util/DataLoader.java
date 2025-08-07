package com.viscontti.hub.foro.foro_hub.util;

import com.viscontti.hub.foro.foro_hub.data.repository.CourseRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.TopicRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.AuthorRepository;
import com.viscontti.hub.foro.foro_hub.model.Course;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.model.Author;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(TopicRepository topicRepo,
                               AuthorRepository userRepo,
                               CourseRepository courseRepo) {
        return args -> {
            // Create a test user
            Author author = new Author();
            author.setName("Jane Doe");
            author.setPassword("test123");
            userRepo.save(author);

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
                topic.setAuthor(author);
                topic.setCourse(course);
                topic.setAnswersList(new ArrayList<>());
                topicRepo.save(topic);
            }

            System.out.println("✅ Sample data loaded.");
        };
    }
}
