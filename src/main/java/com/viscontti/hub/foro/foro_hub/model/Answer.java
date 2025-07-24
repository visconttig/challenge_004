package com.viscontti.hub.foro.foro_hub.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "answers")
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String solution;

}
