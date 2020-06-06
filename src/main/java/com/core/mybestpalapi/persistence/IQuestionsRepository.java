package com.core.mybestpalapi.persistence;

import com.core.mybestpalapi.persistence.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IQuestionsRepository extends MongoRepository<Question, String> {
}
