package com.aniket.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aniket.userservice.model.IdGenerator;

@Repository
public interface IdRepository extends MongoRepository<IdGenerator, String> {

}
