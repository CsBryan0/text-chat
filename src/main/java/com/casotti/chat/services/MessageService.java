package com.casotti.chat.services;

import com.casotti.chat.entities.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Long channelId, String content);
    List<Message>  getMessagesByChannel(Long channelId);
    void deleteMessage(Long messageId);
}
