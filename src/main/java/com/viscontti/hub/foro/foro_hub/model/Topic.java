package com.viscontti.hub.foro.foro_hub.model;

import com.viscontti.hub.foro.foro_hub.data.dto.TopicDTO;
import com.viscontti.hub.foro.foro_hub.data.dto.UpdateTopicData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    public void updateInfo(@Valid UpdateTopicData data){
        if(data.title() != null){
            this.title = data.title();
        }

        if(data.message() != null){
            this.message = data.message();
        }

        if(data.author() != null){
            this.author.updateAuthor(data.author());
        }
    }
}
