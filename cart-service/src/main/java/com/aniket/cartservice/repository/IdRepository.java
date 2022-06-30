package com.aniket.cartservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aniket.cartservice.model.IdGenerator;

@Repository
public interface IdRepository extends MongoRepository<IdGenerator, String>{

}
