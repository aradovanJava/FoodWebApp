package hr.algebra.food.foodpostgetsession.repository;

import hr.algebra.food.foodpostgetsession.domain.Food;

import java.util.List;

public interface FoodRepository {
    List<Food> getAllFood();

    Food saveNewFood(Food newFood);
}
