package hr.algebra.food.foodpostgetsession.repository;

import hr.algebra.food.foodpostgetsession.domain.Food;
import hr.algebra.food.foodpostgetsession.domain.FoodType;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Repository
public class FoodRepositoryJdbc implements FoodRepository {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert inserter;

    public FoodRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.inserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("FOOD")
                .usingGeneratedKeyColumns("ID");
    }

    @Override
    public List<Food> getAllFood() {
        List<Food> foodList = jdbcTemplate.query("select id, name,kcal,food_Type from food",
                (result,rowNum)->new Food(result.getInt("id"),
                result.getString("name"),result.getInt("kcal"),
                        FoodType.valueOf(result.getString("food_Type"))));
        return foodList;
    }

    @Override
    public Food saveNewFood(Food newFood) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", newFood.getName());
        params.put("kcal", newFood.getKcal());
        params.put("food_type", newFood.getFoodType());
        if(inserter.executeAndReturnKey(params) instanceof Integer integerKey) {
            newFood.setId(integerKey);
            return newFood;
        }
        else {
            throw new RuntimeException("Invalid key returned after insert!");
        }

    }
}
