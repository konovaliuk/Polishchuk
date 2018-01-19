package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class ParcelPrice implements Serializable {
    private Long parcelpriceID;
    private int weight;
    private int price;
}
