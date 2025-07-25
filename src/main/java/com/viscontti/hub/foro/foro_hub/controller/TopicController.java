package com.viscontti.hub.foro.foro_hub.controller;

import com.viscontti.hub.foro.foro_hub.data.dto.TopicDTO;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
