package com.core.mybestpalapi.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "user_to_question")
@Builder
@Getter
@Setter
public class UserToQuestion implements Serializable {
  @Id
  private String id;
  @Field(name = "question_id")
  private String questionId;
  @Column(unique = true)
  @Field(name = "user_to_question_id")
  private String userToQuestionId;
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

  public static UserToQuestion.UserToQuestionBuilder builder() {
    return new UserToQuestion.UserToQuestionBuilder();
  }
}
