package com.core.mybestpalapi.persistence;

import com.core.mybestpalapi.persistence.model.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOptionsRepository extends MongoRepository<Option, String> {
}
