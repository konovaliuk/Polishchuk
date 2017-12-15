package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString

public class Direction implements Serializable {
    private Long directionID;
    private String fromCity;
    private String toCity;
    private int priceDirection;
}
