package com.core.mybestpalapi.persistence;

import com.core.mybestpalapi.persistence.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends MongoRepository<Question, String> {
}
