package tech.itpark.jdbc.model;

import lombok.Value;

@Value
public class Car {
    long id;
    long ownerId;
    String name;
    int price;
    String city;
}
