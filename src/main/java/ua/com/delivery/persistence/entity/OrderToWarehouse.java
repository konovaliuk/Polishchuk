package ua.com.delivery.persistence.entity;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class OrderToWarehouse implements Serializable {
    private Long orderToWarehouseID;
    private Date dateOfDeparture;
    private String departureAddress;
    private String cityOfReceipt;
    private String userName;
    private int phone;
    private int weight;
    private int numberOfOrder;
    private String email;
    private int totalPrice;

}
