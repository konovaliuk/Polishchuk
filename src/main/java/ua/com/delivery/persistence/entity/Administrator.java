package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Administrator implements Serializable{
    private Long adminID;
    private String name;
    private String username;
    private String password;
    private String email;
    private Long phone;
}
