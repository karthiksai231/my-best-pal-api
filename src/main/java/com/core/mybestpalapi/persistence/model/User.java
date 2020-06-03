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

@Document(collection = "users")
@Builder
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Field(name = "user_id")
    public String id;
    @Field(name = "first_name")
    public String firstName;
    @Field(name = "last_name")
    public String lastName;
    @Field(name = "user_name")
    public String userName;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Field(name = "created_date")
    public Date created_Date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Field(name = "updated_date")
    public Date updated_Date;

    @PrePersist
    protected void onCreate() {
        this.created_Date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_Date = new Date();
    }

    public static UserBuilder builder() {return new UserBuilder();}
}
