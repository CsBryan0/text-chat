package com.casotti.chat.services;

import com.casotti.chat.entities.Channel;

import java.util.List;

public interface ChannelService {
    Channel createChannel(Long guildId, String name);
    List<Channel> getChannelsById(Long guildId);
}
