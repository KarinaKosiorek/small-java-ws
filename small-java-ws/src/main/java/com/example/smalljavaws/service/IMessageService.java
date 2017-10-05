package com.example.smalljavaws.service;

import java.util.List;

import com.example.smalljavaws.model.Message;

public interface IMessageService {

  List<Message> listAll();

  Message getById(Long id);

  Message saveOrUpdate(Message product);

  void delete(Long id);

}
