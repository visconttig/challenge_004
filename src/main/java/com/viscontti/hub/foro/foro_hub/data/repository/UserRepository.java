package com.viscontti.hub.foro.foro_hub.data.repository;

import com.viscontti.hub.foro.foro_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
