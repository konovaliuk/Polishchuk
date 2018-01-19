package ua.com.delivery.service;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class DateService {
    private String date;

    public DateService() {
        this.date = now();
    }

    private String now() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }


}
