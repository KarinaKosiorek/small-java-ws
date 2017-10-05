package com.example.smalljavaws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smalljavaws.model.Message;
import com.example.smalljavaws.repository.MessageRepository;

@Service
public class MessageServiceImpl implements IMessageService {

  @Autowired
  private MessageRepository messageRepository;

  public MessageServiceImpl() {
  }

  @Override
  public List<Message> listAll() {
    List<Message> messages = new ArrayList<>();
    messageRepository.findAll().forEach(messages::add);
    return messages;
  }

  @Override
  public Message getById(Long id) {
    return messageRepository.findOne(id);
  }

  @Override
  public Message saveOrUpdate(Message message) {
    messageRepository.save(message);
    return message;
  }

  @Override
  public void delete(Long id) {
    messageRepository.delete(id);
  }
}
