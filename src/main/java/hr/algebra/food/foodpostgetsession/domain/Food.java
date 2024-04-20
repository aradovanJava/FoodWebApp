package hr.algebra.food.foodpostgetsession.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    private Integer id;

    private String name;

    private Integer kcal;

    private FoodType foodType;

}
