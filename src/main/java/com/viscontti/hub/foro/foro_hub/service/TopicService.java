package com.viscontti.hub.foro.foro_hub.service;

import com.viscontti.hub.foro.foro_hub.data.repository.TopicRepository;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public List<Topic> findAll(){
       return topicRepository.findAll();
    }
}
