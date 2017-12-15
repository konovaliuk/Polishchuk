package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class OrderToWarehouse implements Serializable {
    private Long orderToWarehouseID;
    private Date dateToReceipt;
    private Long directionID;
    private Long userID;
    private Long cargoID;
    private Long parcelID;
    private int weight;
    private int volume;
    private int numberOfOrder;
    private int totalPrice;

}
