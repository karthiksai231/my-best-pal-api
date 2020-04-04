package com.core.mybestpalapi.persistence.model;

import lombok.*;

@Builder
@Getter
@Setter
public class User {
    public String firstName;
    public String lastName;
    public String userName;

    public static UserBuilder builder() {return new UserBuilder();}
}
