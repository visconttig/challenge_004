package com.viscontti.hub.foro.foro_hub.data.dto;

import com.viscontti.hub.foro.foro_hub.model.Answer;
import com.viscontti.hub.foro.foro_hub.model.Course;
import com.viscontti.hub.foro.foro_hub.model.Topic;
import com.viscontti.hub.foro.foro_hub.model.User;

import java.util.Date;
import java.util.List;

public record TopicDTO(
        Long id,
        String title,
        String message,
        Date createdDate,
        String status,
        User author,
        Course course,
        List<Answer> answersList
) {

    public TopicDTO(Topic t) {
        this(
                t.getId(),
        t.getTitle(),
        t.getMessage(),
        t.getCreatedDate(),
        t.getStatus(),
        t.getAuthor(),
        t.getCourse(),
        t.getAnswersList()
);
    }
}
