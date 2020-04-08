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
import java.util.UUID;

@Document(collation = "users")
@Builder
@Getter
@Setter
public class User implements Serializable {
    @Id
    @Field(name = "User_ID")
    public UUID id;
    @Field(name = "First_Name")
    public String firstName;
    @Field(name = "Last_Name")
    public String lastName;
    @Field(name = "User_Name")
    public String userName;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Field(name = "Created_Date")
    public Date created_Date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Field(name = "Updated_Date")
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
