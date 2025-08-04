package com.viscontti.hub.foro.foro_hub.model;

import com.viscontti.hub.foro.foro_hub.data.dto.UserData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public void updateAuthor(UserData data) {
        if(data.name() != null){
            this.name = data.name();
        }
    }
}
