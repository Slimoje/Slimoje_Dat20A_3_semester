package kea.martin.trash_api.controllers;

import kea.martin.trash_api.models.SuperMarioCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class CharacterController {
    Random randoe = new Random();

    SuperMarioCharacter mario = new SuperMarioCharacter("Mario");

    List<String> chars = Arrays.asList("Mario", "Luigi", "The princess", "Toad", "Bowser");

        @GetMapping("/supermario/character")
    public String getCharacter(){
        return "Mario";
    }

    @GetMapping("/supermario/characterclass")
    public SuperMarioCharacter getCharacterClass(){
        return mario;
    }



}
