package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.data.Menu;
import htw.berlin.wi.prog2.domain.Ingredient;
import java.util.ArrayList;
import java.util.List;

//kann Texte in Progsprache umwandeln. Wenn jmd bestellt, wird eine Zutatenliste aus den im Satz vorkommenden Zuaten erstellt
public class SimpleInputParser implements InputParser {
    @Override

    public List<Ingredient> ingredientsFromInput(String inputLine) { //leere Liste erzeugt, später werden hier die Zuaten gespeichert
        List<Ingredient> result = new ArrayList<>();
        for (Ingredient ing : Menu.getAllArticles().values()) { //alle Zutaten
            if (inputLine.contains(ing.getName())) result.add(ing); //selektiert
        }
        return result;
    }
}
