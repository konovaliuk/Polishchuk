package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private Long userID;
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String email;
    private String address;
    private String city;
    private Long phone;

}

