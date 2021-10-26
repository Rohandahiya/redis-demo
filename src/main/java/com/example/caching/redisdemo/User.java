package com.example.caching.redisdemo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private int id;
    private int age;
    private String name;
    private String country;
    private Address address;
}
