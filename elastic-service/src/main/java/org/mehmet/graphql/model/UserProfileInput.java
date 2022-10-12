package org.mehmet.graphql.model;

import lombok.Data;

@Data
public class UserProfileInput {

    Long authid;
    String username;
    String name;
    String surname;
    String email;
}
