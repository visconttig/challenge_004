package com.viscontti.hub.foro.foro_hub.data.repository;

import com.viscontti.hub.foro.foro_hub.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
