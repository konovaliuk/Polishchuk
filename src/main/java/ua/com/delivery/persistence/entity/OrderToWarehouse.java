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
    private String phone;
    private int weight;
    private int numberOfOrder;
    private String email;
    private String typeOfParcel;
    private int totalPrice;
    private Long userId;
    private Long directionId;
    private Long parcelPriceId;

}
