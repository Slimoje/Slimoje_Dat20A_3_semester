package kea.martin.trash_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonController {

    List<String> pokemon = Arrays.asList("Bulbasaur", "Pikachu", "Monkey", "Crab", "Charizard");

    List<String> pokemonInLine = new ArrayList<>(){{
        add("Venosaur");
        add("Raichu");
        add("Mankey");
        add("Brac");
        add("Charizard");
    }};

    @GetMapping("/test") //endpoint
    public String test(){
        return "test";
    }

    @GetMapping("/pokemon/go") //endpoint
    public boolean pokemon(){
        return false;
    }
    //TODO create an ArrayList that contains pokemon and
    //TODO create a route (on /pokemon) that serves them.



    @GetMapping("/pokemon") //endpoint
    public List<String> listOfPokemon(){
        return pokemonInLine;
    }





}
