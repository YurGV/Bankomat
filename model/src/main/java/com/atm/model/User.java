package com.atm.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String fName;
    private String lName;
    private String city;
    private String street;
    private Integer house;
    private Integer room;
    private Card card;

    @Override
    public String toString() {
        return "User { " +
                ", user id=" + id +
                ", user first name =" + fName +
                ", user last name =" + lName +
                ", city = " + city +
                ", street = " + street +
                ", house = " + house +
                ", room = " + room +
                '}';
    }
}
