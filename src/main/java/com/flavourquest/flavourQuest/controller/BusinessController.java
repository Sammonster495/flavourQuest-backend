package com.flavourquest.flavourQuest.controller;

import com.flavourquest.flavourQuest.models.FoodItem;
import com.flavourquest.flavourQuest.repository.FoodRepository;
import com.flavourquest.flavourQuest.repository.SearchRepositoryImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/menu")
public class BusinessController {
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private SearchRepositoryImplement searchRepositoryImplement;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(foodRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity addItem(@RequestBody FoodItem foodItem){
        this.foodRepository.save(foodItem);
        System.out.println("Saved : " + foodItem);
        return ResponseEntity.ok(foodItem);
    }

    @PostMapping("/addUnique")
    public ResponseEntity addOne(@RequestBody FoodItem foodItem){
        String name = foodItem.getName();
        FoodItem item = searchRepositoryImplement.findByName(name);
        System.out.println("Item : " + item);
        if(item == null){
            this.foodRepository.save(foodItem);
            System.out.println("not available . Saved : " + foodItem);
        }
        return ResponseEntity.ok(foodItem);
    }
}
