package com.flavourquest.flavourQuest.repository;

import com.flavourquest.flavourQuest.models.FoodItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<FoodItem, String> {
}
