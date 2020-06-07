package com.core.mybestpalapi.persistence;

import com.core.mybestpalapi.persistence.model.UserToQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserToQuestionRepository extends MongoRepository<UserToQuestion, String> {
}
