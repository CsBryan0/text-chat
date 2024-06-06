package com.casotti.chat.services.impl;

import com.casotti.chat.entities.Channel;
import com.casotti.chat.entities.Message;
import com.casotti.chat.entities.User;
import com.casotti.chat.repositories.ChannelRepository;
import com.casotti.chat.repositories.MessageRepository;
import com.casotti.chat.repositories.UserRepository;
import com.casotti.chat.services.MessageService;
import com.casotti.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ChannelRepository channelRepository;
    private final UserService userService;


    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, ChannelRepository channelRepository, UserService userService){
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
        this.userService = userService;
    }


    @Override
    public Message sendMessage(Long channelId, String content){
        Channel channel = channelRepository.findById(channelId).orElseThrow(() -> new RuntimeException("Channel  not found"));
        User author = userService.getCurrentUser();

        Message message = new Message();
        message.setContent(content);
        message.setChannel(channel);
        message.setAuthor(author);
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByChannel(Long channelId){
        Channel channel = channelRepository.findById(channelId).orElseThrow(() -> new RuntimeException("Channel not Found"));

        return messageRepository.findByChannel(channel);
    }

    @Override
    public void deleteMessage(Long messageId){
        messageRepository.deleteById(messageId);
    }
}
