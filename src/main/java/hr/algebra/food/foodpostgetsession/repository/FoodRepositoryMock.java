package hr.algebra.food.foodpostgetsession.repository;

import hr.algebra.food.foodpostgetsession.domain.Food;
import hr.algebra.food.foodpostgetsession.domain.FoodType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepositoryMock implements FoodRepository {

    private List<Food> foodList;

    public FoodRepositoryMock() {
        foodList = new ArrayList<>();
        foodList.add(new Food(1, "Ćevapi", 1000, FoodType.MEAT));
        foodList.add(new Food(2, "Pasta Carbonara", 676, FoodType.MEAT));
        foodList.add(new Food(3, "Bakalar na bijelo", 543, FoodType.FISH));
    }

    @Override
    public List<Food> getAllFood() {
        return foodList;
    }

    @Override
    public Food saveNewFood(Food newFood) {
        foodList.add(newFood);
        return newFood;
    }
}
