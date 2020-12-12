package tech.itpark.jdbc.model;

import lombok.Value;

@Value
public class Car {
    long id;
    String model;
    int price;
    String city;
}
