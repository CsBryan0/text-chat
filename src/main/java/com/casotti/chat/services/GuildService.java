package com.casotti.chat.services;

import com.casotti.chat.entities.Guild;

import java.util.List;

public interface GuildService {

    Guild createGuild(String name);
    List<Guild> getAllGuilds();
    void deleteGuild(Long guildId);

}
