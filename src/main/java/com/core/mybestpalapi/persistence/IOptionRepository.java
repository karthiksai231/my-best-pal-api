package com.core.mybestpalapi.persistence;

import com.core.mybestpalapi.persistence.model.Option;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOptionRepository extends MongoRepository<Option, String> {
}
