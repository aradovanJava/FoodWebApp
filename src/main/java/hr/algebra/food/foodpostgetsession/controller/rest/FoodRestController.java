package hr.algebra.food.foodpostgetsession.controller.rest;

import hr.algebra.food.foodpostgetsession.domain.Food;
import hr.algebra.food.foodpostgetsession.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/food")
@AllArgsConstructor
public class FoodRestController {

    private FoodRepository foodRepository;

    @GetMapping("/all")
    public List<Food> getAllFood() {
        return foodRepository.getAllFood();
    }

    @PostMapping("/new")
    public Food addNewFood(@RequestBody Food newFood) {
        return foodRepository.saveNewFood(newFood);
    }
}
