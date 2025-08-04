package com.viscontti.hub.foro.foro_hub.data.dto;

import com.viscontti.hub.foro.foro_hub.model.User;

public class UserDTO {
    private Long id;
    private String name;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

}
