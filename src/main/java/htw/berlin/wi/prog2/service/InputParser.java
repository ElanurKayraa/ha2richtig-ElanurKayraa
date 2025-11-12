package htw.berlin.wi.prog2.service;
//importiert in CommandLineUI, BurgerBotApp

import htw.berlin.wi.prog2.domain.Ingredient;

import java.util.List;

public interface InputParser {
    List<Ingredient> ingredientsFromInput(String inputLine);
}

