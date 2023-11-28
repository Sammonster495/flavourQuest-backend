package com.flavourquest.flavourQuest.models;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FoodItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;

    @JsonProperty("image")
    private String image;
    @JsonProperty("price")
    private double price;
}
