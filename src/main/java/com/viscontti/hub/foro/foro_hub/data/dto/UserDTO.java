package com.viscontti.hub.foro.foro_hub.data.dto;

import com.viscontti.hub.foro.foro_hub.model.Author;

public class UserDTO {
    private Long id;
    private String name;

    public UserDTO(Author author){
        this.id = author.getId();
        this.name = author.getName();
    }

}
