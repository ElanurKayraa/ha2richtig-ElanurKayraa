package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;

import java.util.ArrayList;
import java.util.List;

//Aufgabe 3: Implentierung der 3 Methoden, anstelle Dummy. Sodass der Burger niutzbar ist


public class BurgerBuilder {

    private final List<Ingredient> ingredients = new ArrayList<>();

    public BurgerBuilder add(Ingredient ingredient) {
        // TODO hier die Annahme von Zutaten implementieren
        ingredients.add(ingredient);
        return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im BurgerBuilderTest)
    }

    public Burger buildPrecomputed() {
        Burger burger = new PrecomputedBurger(new ArrayList<>(ingredients));
        ingredients.clear();
        return burger;
    }

    public Burger buildDynamicallyComputed() {
        Burger burger = new DynamicallyComputedBurger(new ArrayList<>(ingredients));
        ingredients.clear();
        return burger;
    }

}

