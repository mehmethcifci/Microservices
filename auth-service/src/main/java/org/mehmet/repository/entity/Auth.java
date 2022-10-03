package org.mehmet.repository.entity;

import org.mehmet.repository.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "auths")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    Long id;
    String username;
    String password;
    String email;
    @Enumerated(EnumType.STRING)
    Role role;

}
