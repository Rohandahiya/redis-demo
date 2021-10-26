package com.example.caching.redisdemo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address implements Serializable {
    private String city;
    private String pincode;
}
