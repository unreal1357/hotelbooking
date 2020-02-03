package com.api.hotelbooking.booking;

import java.time.LocalDate;

//try lombok with this one
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Booking {

    private long id;
    private LocalDate beginDate;
    private LocalDate endDate;
}
