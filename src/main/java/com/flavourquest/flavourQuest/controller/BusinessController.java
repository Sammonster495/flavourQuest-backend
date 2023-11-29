package com.flavourquest.flavourQuest.controller;

import com.flavourquest.flavourQuest.models.FoodItem;
import com.flavourquest.flavourQuest.repository.FoodRepository;
import com.flavourquest.flavourQuest.repository.SearchRepositoryImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @PutMapping("/update/{id}")
    public ResponseEntity updateYourEntity(@PathVariable String id, @RequestBody FoodItem newEntityData) {
        Optional<FoodItem> optionalEntity = foodRepository.findById(id);

        if(optionalEntity.isPresent()) {
            FoodItem oldEntityData = optionalEntity.get();

            // Here you can set the new values for the fields you want to update
            oldEntityData.setName(newEntityData.getName());
            oldEntityData.setPrice(newEntityData.getPrice());
            oldEntityData.setDesc(newEntityData.getDesc());
            oldEntityData.setImage(newEntityData.getImage());

            return ResponseEntity.ok(foodRepository.save(oldEntityData));
        } else {
            throw new RuntimeException("Entity not found for id "+id);
        }
    }
}
