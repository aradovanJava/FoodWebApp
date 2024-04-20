package hr.algebra.food.foodpostgetsession.controller.mvc;

import hr.algebra.food.foodpostgetsession.domain.Food;
import hr.algebra.food.foodpostgetsession.publisher.CustomSpringEventPublisher;
import hr.algebra.food.foodpostgetsession.repository.FoodRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("food")
@AllArgsConstructor
@SessionAttributes({"allFoodList", "newFood"})
public class FoodController {

    private FoodRepository foodRepository;

    private CustomSpringEventPublisher customSpringEventPublisher;

    @ModelAttribute("allFoodList")
    public List<Food> storeAllFood() {
        return foodRepository.getAllFood();
    }

    @ModelAttribute("newFood")
    public Food storeEmptyObject() {
        return new Food();
    }
    @GetMapping("getAllFood.html")
    public String getAllFood(Model model, HttpSession session) {
        System.out.println("Fetching all food!");
        List<Food> foodList = foodRepository.getAllFood();
        model.addAttribute("allFoodList", foodList);
        customSpringEventPublisher.publishCustomEvent("Event published!");
        return "allFood";
    }

    @PostMapping("saveNewFood.html")
    public String saveNewFood(Food newFood, Model model, HttpSession session) {
        foodRepository.saveNewFood(newFood);
        return "redirect:/food/getAllFood.html";
    }

    @GetMapping("cleanSession.html")
    public String cleanSession(SessionStatus sessionStatus, HttpSession session) {
        sessionStatus.setComplete();
        session.invalidate();
        return "redirect:/food/getAllFood.html";
    }

}
