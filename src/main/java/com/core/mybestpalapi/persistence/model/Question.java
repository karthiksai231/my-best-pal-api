package com.core.mybestpalapi.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "questions")
@Builder
@Getter
@Setter
public class Question implements Serializable {
  @Id
  @Field(name = "question_id")
  public String id;
  @Field(name = "question")
  public String question;
  @Field(name = "user_id")
  public String userId;
  @JsonFormat(pattern = "yyyy-mm-dd")
  @Field(name = "created_date")
  public Date createdDate;
  @JsonFormat(pattern = "yyyy-mm-dd")
  @Field(name = "updated_date")
  public Date updatedDate;

  @PrePersist
  protected void onCreate() {
    this.createdDate = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedDate = new Date();
  }

  public static Question.QuestionBuilder builder() {return new Question.QuestionBuilder();}
}
