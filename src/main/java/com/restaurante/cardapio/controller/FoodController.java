package com.restaurante.cardapio.controller;

import com.restaurante.cardapio.dto.FoodRequestDTO;
import com.restaurante.cardapio.dto.FoodResponseDTO;
import com.restaurante.cardapio.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        foodService.save(data);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        return foodService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteFood (@PathVariable(value = "id") Integer id){
        foodService.deleteFood(id);
    }
}
