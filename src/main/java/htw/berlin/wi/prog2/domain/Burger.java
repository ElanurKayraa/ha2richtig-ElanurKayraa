package htw.berlin.wi.prog2.domain;
//import htw.berlin.wi.prog2.service.IllegalBurgerException;

import java.util.List;

public interface Burger {
    double calculatePrice();
    int calculateCalories();
    List<String> getIngredientNames();
}
