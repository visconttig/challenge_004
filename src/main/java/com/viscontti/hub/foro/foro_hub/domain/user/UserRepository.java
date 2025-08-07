package com.viscontti.hub.foro.foro_hub.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

UserDetails findByUsername(String login);
}
