package com.core.mybestpalapi.persistence.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
public class User {
    @Id
    @Column(name = "User_ID")
    public UUID id;
    @Column(name = "First_Name")
    public String firstName;
    @Column(name = "Last_Name")
    public String lastName;
    @Column(name = "User_Name")
    public String userName;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "Created_Date")
    public Date created_Date;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(name = "Updated_Date")
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
