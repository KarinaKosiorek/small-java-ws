package com.example.smalljavaws.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.smalljavaws.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
