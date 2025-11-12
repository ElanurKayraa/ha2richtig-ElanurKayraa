//Zutaten, Kalorien und Gesamtpreis direkt gesetzt
package htw.berlin.wi.prog2.domain;
import htw.berlin.wi.prog2.service.IllegalBurgerException;

import java.util.List; //Zutaten gespeichert
import java.util.stream.Collectors;

//muss die Methoden implementieren
public class PrecomputedBurger implements Burger {

    private final List<Ingredient> ingredients;
    private final double totalPrice;
    private final int totalCalories;

    public PrecomputedBurger(List<Ingredient> ingredients) {
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalBurgerException("Ein Burger muss mindestens eine Zutat enthalten!");
        }

        this.ingredients = List.copyOf(ingredients);
        //nach Erstellung wird eine Kopie erstellt, im nachhinein unverändert

        this.totalPrice = ingredients.stream().mapToDouble(Ingredient::getPrice).sum();
        //die Preise der einzelnen Zutaten werden summiert
        //Ingerdients= Liste von Zutatenobjekten, jede Zutat hat Methode getPrice()
        //Zuataten werden in ein Stream umgewandelt (Datenfluss für Listen)
        //Stream wird dann in ein double umgewandelt wegen des Preisen, nur noch Preise in der Liste
        this.totalCalories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }

    //gibt Namen aller Zutaten zurück z.B.: ["Käse", "Salat", "Tomate"]
    @Override
    public List<String> getIngredientNames() {
        return ingredients.stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    //gibt den Gesamtpreis zurück, wurde vorher berechnet
    @Override
    public double calculatePrice() {
        return totalPrice;
    }

    @Override
    public int calculateCalories() {
        return totalCalories;
    }
}
//Stream ist Kurzform für:
// double sum = 0;
//for (Ingredient ingredient : ingredients) {
//    sum += ingredient.getPrice();
//}
//this.totalPrice = sum;