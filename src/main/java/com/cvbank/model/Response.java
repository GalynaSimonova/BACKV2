package com.cvbank.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Response {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private boolean isResponseSuccessful;
}



