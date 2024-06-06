package com.casotti.chat.repositories;

import com.casotti.chat.entities.Guild;
import com.casotti.chat.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {
    List<Guild> findByOwner(User owner);
}
