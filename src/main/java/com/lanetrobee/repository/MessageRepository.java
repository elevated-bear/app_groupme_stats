package com.lanetrobee.repository;

import com.lanetrobee.entity.message.MessageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<MessageEntity, Integer> {

}
