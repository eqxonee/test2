package org.example.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class Number {

    @Id
    private Long id;
    private String number;
    private OffsetDateTime orderDate;
}
