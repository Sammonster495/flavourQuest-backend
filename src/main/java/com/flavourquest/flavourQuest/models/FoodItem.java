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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getDesc(){
        return this.desc;
    }

    public String getImage(){
        return this.image;
    }
}
