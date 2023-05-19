package com.restaurante.cardapio.service;

import com.restaurante.cardapio.dto.FoodRequestDTO;
import com.restaurante.cardapio.dto.FoodResponseDTO;
import com.restaurante.cardapio.entities.Food;
import com.restaurante.cardapio.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Transactional
    public Food save (FoodRequestDTO data){
        Food foodData = new Food(data);
        return foodRepository.save(foodData);
    }

    @Transactional(readOnly = true)
    public List<FoodResponseDTO> getAll (){
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    public void deleteFood(Integer id) {
        foodRepository.deleteById(Long.valueOf(id));
    }
}
