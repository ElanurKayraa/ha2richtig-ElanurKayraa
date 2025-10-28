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
        // TODO hier stattdessen die neue Klasse PrecomputedBurger verwenden
        Burger burger = new PrecomputedBurger(ingredients);
        ingredients.clear(); // wichtig, sonst mischen sich die Zutaten
        return burger;
    }


    public Burger buildDynamicallyComputed() {
        // TODO hier stattdessen die neue Klasse DynamicallyComputedBurger verwenden
        Burger burger = new DynamicallyComputedBurger(ingredients);
        ingredients.clear();
        return burger;
    }
}

