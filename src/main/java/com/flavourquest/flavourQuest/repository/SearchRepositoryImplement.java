package com.flavourquest.flavourQuest.repository;

import com.flavourquest.flavourQuest.models.FoodItem;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImplement implements SearchRepository{
    @Autowired
     private MongoClient mongoClient;

    final String DATA_BASE = "foodItems"; // TO BE CONFIGURED

    private FoodItem mapDocumentToFoodItem(Document document) {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(document.getObjectId("_id").toString()); // Assuming _id is the ObjectId field in MongoDB
        foodItem.setName(document.getString("name"));
        foodItem.setDesc(document.getString("desc"));
        foodItem.setPrice(document.getDouble("price"));
        foodItem.setImage(document.getString("image"));

        return foodItem;
    }

    @Override
    public FoodItem findByName(String name){
        final List<FoodItem> ans = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase(DATA_BASE);
        MongoCollection<Document> collection = database.getCollection("FoodItem");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", new Document("name", name))));

        result.forEach(document -> {
            FoodItem item = mapDocumentToFoodItem(document);
            ans.add(item);
        });

        if(ans.isEmpty()){
            return null;
        }
        return ans.get(0);

    }
}
