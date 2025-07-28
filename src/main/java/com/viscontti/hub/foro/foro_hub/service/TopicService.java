package com.viscontti.hub.foro.foro_hub.service;

import com.viscontti.hub.foro.foro_hub.data.dto.TopicRegisterData;
import com.viscontti.hub.foro.foro_hub.data.repository.CourseRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.TopicRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.UserRepository;
import com.viscontti.hub.foro.foro_hub.model.Course;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TopicService {


    @Autowired
    TopicRepository topicRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Topic> findAll(){
       return topicRepository.findAll();
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic createTopic(TopicRegisterData data){
        User author = userRepository.findById(Long.valueOf(data.authorId())).orElseThrow(() -> new RuntimeException("User not found."));

        Course course = courseRepository.findById(Long.valueOf(data.courseId())).orElseThrow(() -> new RuntimeException("Course not found."));

        Topic topic = new Topic();
        topic.setTitle(data.title());
        topic.setMessage(data.message());
        topic.setCreatedDate(new Date());
        topic.setStatus("OPEN");
        topic.setAuthor(author);
        topic.setCourse(course);

        return topicRepository.save(topic);
    }
}
