package com.casotti.chat.services.impl;

import com.casotti.chat.entities.Guild;
import com.casotti.chat.entities.User;
import com.casotti.chat.repositories.GuildRepository;
import com.casotti.chat.repositories.UserRepository;
import com.casotti.chat.services.GuildService;
import com.casotti.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuildServiceImpl implements GuildService {

    private final GuildRepository guildRepository;
    private final UserService userService;

    @Autowired
    public GuildServiceImpl(GuildRepository guildRepository, UserService userService){
        this.guildRepository = guildRepository;
        this.userService = userService;
    }

    @Override
    public Guild createGuild(String name){
        User owner = userService.getCurrentUser();
        Guild guild = new Guild();
        guild.setName(name);
        guild.setOwner(owner);

        return guildRepository.save(guild);
    }

    @Override
    public List<Guild> getAllGuilds(){
        return guildRepository.findAll();
    }

    @Override
    public void deleteGuild(Long guildId){
        guildRepository.deleteById(guildId);
    }
}
