package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;
import java.util.ArrayList;
import java.util.List;

public class BurgerBuilder {

    private final List<Ingredient> ingredients = new ArrayList<>();

    public BurgerBuilder add(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    public Burger buildPrecomputed() {
        if (ingredients.size() < 2) {
            ingredients.clear();
            throw new IllegalBurgerException("Ein Burger muss mindestens zwei Zutaten enthalten!");
        }

        Burger burger = new PrecomputedBurger(new ArrayList<>(ingredients));
        ingredients.clear();
        return burger;
    }

    public Burger buildDynamicallyComputed() {
        if (ingredients.size() < 2) {
            ingredients.clear();
            throw new IllegalBurgerException("Ein Burger muss mindestens zwei Zutaten enthalten!");
        }

        Burger burger = new DynamicallyComputedBurger(new ArrayList<>(ingredients));
        ingredients.clear();
        return burger;
    }
}


