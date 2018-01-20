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
    private String userName;
    private String cityDeparture;
    private int phone;
    private int weight;
    private String addressToDelivery;
    private String email;
    private String typeOfParcel;
    private int totalPrice;


}
