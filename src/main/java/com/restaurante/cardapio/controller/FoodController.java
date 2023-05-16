package com.restaurante.cardapio.controller;

import com.restaurante.cardapio.entities.Food;
import com.restaurante.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<Food>getAll(){
        List<Food> foodList = foodRepository.findAll();
        return foodList;
    }
}
