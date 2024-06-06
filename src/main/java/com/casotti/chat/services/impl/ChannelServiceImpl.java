package com.casotti.chat.services.impl;

import com.casotti.chat.entities.Channel;
import com.casotti.chat.entities.Guild;
import com.casotti.chat.repositories.ChannelRepository;
import com.casotti.chat.repositories.GuildRepository;
import com.casotti.chat.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;
    private final GuildRepository guildRepository;


    @Autowired
    public ChannelServiceImpl(ChannelRepository channelRepository, GuildRepository guildRepository){
        this.channelRepository = channelRepository;
        this.guildRepository = guildRepository;
    }

    @Override
    public Channel createChannel(Long guildId, String name){
        Guild guild = guildRepository.findById(guildId)
                .orElseThrow(() -> new RuntimeException("Guild not found"));
        Channel channel = new Channel();
        channel.setName(name);
        channel.setGuild(guild);
        return channelRepository.save(channel);
    }

    @Override
    public List<Channel> getChannelsById(Long guildId){
        Guild guild = guildRepository.findById(guildId).orElseThrow(() -> new RuntimeException("Guild Not foud"));
        return channelRepository.findByGuild(guild);
    }


}
