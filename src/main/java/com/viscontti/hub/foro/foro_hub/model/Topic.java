package com.viscontti.hub.foro.foro_hub.model;

import com.viscontti.hub.foro.foro_hub.data.dto.TopicDTO;
import com.viscontti.hub.foro.foro_hub.data.dto.TopicRegisterData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "topics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private Date createdDate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "topic")
    private List<Answer> answersList;

    public Topic(TopicDTO topicDTO) {
        if(topicDTO.title() != null){
            this.title = topicDTO.title();
        }
       if(topicDTO.message() != null){
           this.message = topicDTO.message();
       }
       if(topicDTO.author() != null){
           this.author = topicDTO.author();
       }
       if(topicDTO.course() !=  null){
           this.course = topicDTO.course();
       }

    }
}
