package htw.berlin.wi.prog2.domain;
import htw.berlin.wi.prog2.service.IllegalBurgerException;

import java.util.stream.Collectors;

public class PrecomputedBurger implements Burger {

    private final List<Ingredient> ingredients;
    private final double totalPrice;
    private final int totalCalories;

    public PrecomputedBurger(List<Ingredient> ingredients) {
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalBurgerException("Ein Burger muss mindestens eine Zutat enthalten!");
        }

        this.ingredients = List.copyOf(ingredients);
        this.totalPrice = ingredients.stream().mapToDouble(Ingredient::getPrice).sum();
        this.totalCalories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }
    @Override
    public List<String> getIngredientNames() {
        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public double calculatePrice() {
        return totalPrice;
    }

    @Override
    public int calculateCalories() {
        return totalCalories;
    }
}