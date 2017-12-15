package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class CargoPrice implements Serializable {
    private Long cargopriceID;
    private int weight;
    private int price;
}
