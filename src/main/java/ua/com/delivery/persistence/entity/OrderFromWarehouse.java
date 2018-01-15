package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class OrderFromWarehouse implements Serializable {
    private Long orderFromWarehouseID;
    private int numberOfOrder;
    private Date dateToDelivery;
    private String cityDeparture;
    private String userName;
    private int phone;
    private String addressToDelivery;
    private int weight;
    private String email;
    private int totalPrice;

}
