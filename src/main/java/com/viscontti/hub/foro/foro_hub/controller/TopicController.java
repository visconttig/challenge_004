package com.viscontti.hub.foro.foro_hub.controller;

import com.viscontti.hub.foro.foro_hub.data.dto.TopicDTO;
import com.viscontti.hub.foro.foro_hub.data.dto.TopicRegisterData;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicDTO>> topics(){
        var topics = topicService.findAll().stream().map((t) -> {
          return   new TopicDTO(t);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid TopicRegisterData topicData){
        var topic = topicService.createTopic(topicData);
        var savedTopic = topicService.save(topic);
        return ResponseEntity.ok(new TopicDTO(savedTopic));
    }

    @GetMapping("/{id}")
    public ResponseEntity getTopicById(@PathVariable Long id){
        Topic topic = topicService.findById(id).orElseThrow(() -> new RuntimeException("Topic not found."));
        return ResponseEntity.ok(new TopicDTO(topic));
    }


}
