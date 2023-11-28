package com.flavourquest.flavourQuest.repository;

import com.flavourquest.flavourQuest.models.FoodItem;

public interface SearchRepository {
    FoodItem findByName(String name);

}
