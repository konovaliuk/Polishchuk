package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Calculator implements Serializable {
    private Long calculatorID;
    private Long directionID;
    private Long cargoID;
    private Long parcelID;
    private Date dateToDelivery;
    private int declaredPrice;
    private int weight;
    private int volume;

}
