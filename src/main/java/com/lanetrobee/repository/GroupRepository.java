package com.lanetrobee.repository;

import com.lanetrobee.entity.GroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<GroupEntity, Integer> {
}
