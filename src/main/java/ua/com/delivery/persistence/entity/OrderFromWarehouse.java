package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class OrderFromWarehouse implements Serializable {
    private Long orderFromWarehouseID;
    private int numberOfOrder;
    private Date dateToDelivery;
    private Long directionID;
    private Long userID;
    private int phone;
    private String addressToDelivery;
    private int totalPrice;

}
