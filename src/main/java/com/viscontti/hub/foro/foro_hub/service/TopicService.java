package com.viscontti.hub.foro.foro_hub.service;

import com.viscontti.hub.foro.foro_hub.data.dto.TopicRegisterData;
import com.viscontti.hub.foro.foro_hub.data.repository.CourseRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.TopicRepository;
import com.viscontti.hub.foro.foro_hub.data.repository.AuthorRepository;
import com.viscontti.hub.foro.foro_hub.model.Course;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {


    @Autowired
    TopicRepository topicRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CourseRepository courseRepository;

    public List<Topic> findAll(){
       return topicRepository.findAll();
    }

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Topic createTopic(TopicRegisterData data){
        Author author = authorRepository.findById(Long.valueOf(data.authorId())).orElseThrow(() -> new RuntimeException("User not found."));

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

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public void deleteById(Long id){
        Topic topic = findById(id).orElseThrow(() -> new RuntimeException("Topic not found."));
        if(topic != null){
            topicRepository.deleteById(id);
        }
    }

    public void updateById(Long id){
    }

    public Topic getReferenceById(Long id) {
        return topicRepository.getReferenceById(id);
    }
}
