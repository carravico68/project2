package com.virtualcodemonkeys.project2.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class SuperCharacter {
    private String id;
    private String name;
    private Integer age;
    private SuperGroup group;
}
