package com.example.trainschedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Train {
    @Id
    private Long id;
    private String line;
    private int departure;
    private int arrival;

}
