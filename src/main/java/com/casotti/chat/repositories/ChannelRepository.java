package com.casotti.chat.repositories;

import com.casotti.chat.entities.Channel;
import com.casotti.chat.entities.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    List<Channel> findByGuild(Guild guild);
}
