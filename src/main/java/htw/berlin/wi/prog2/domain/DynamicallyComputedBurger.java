package htw.berlin.wi.prog2.domain;

import htw.berlin.wi.prog2.service.IllegalBurgerException;

import java.util.List;
import java.util.stream.Collectors;

public class DynamicallyComputedBurger implements Burger {

    private final List<Ingredient> ingredients;

    public DynamicallyComputedBurger(List<Ingredient> ingredients) {
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalBurgerException("Ein Burger muss mindestens eine Zutat enthalten!");
        }

        this.ingredients = List.copyOf(ingredients);
    }
    @Override
    public List<String> getIngredientNames() {
        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public double calculatePrice() {
        return ingredients.stream().mapToDouble(Ingredient::getPrice).sum();
    }

    @Override
    public int calculateCalories() {
        return ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }
}
