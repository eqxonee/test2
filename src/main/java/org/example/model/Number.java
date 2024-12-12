package org.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
public class Number {

    @Id
    private String id;
    private String number;
    private LocalDateTime orderDate;
}
