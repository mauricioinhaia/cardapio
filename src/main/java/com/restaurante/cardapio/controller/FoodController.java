package com.restaurante.cardapio.controller;

import com.restaurante.cardapio.dto.FoodRequestDTO;
import com.restaurante.cardapio.dto.FoodResponseDTO;
import com.restaurante.cardapio.entities.Food;
import com.restaurante.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        foodRepository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public Stream<Object> getAll(){
        Stream<Object> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new);
        return foodList;
    }
}
