package kea.martin.trash_api.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;

//requestMapping kan bruges til at definere en root for en controller klasse.
//@RequestMapping("/root")
@RestController
public class TrashController {
    int number = 1;
    Random rand = new Random();
    List<String> sins = Arrays.asList("Lust", "Gluttony", "Greed", "Sloth", "Wrath", "Envy", "Pride");

        //todo create a route on root that sends a message back
        @GetMapping("/") // "/" is root
        public String index(){
            return "index";
        } //This is a route

        //todo create a clock that sends back the time
        //todo on the endpoint clock
        @GetMapping("/clock") //endpoint
        public Date clock(){
            return new Date();
        }

        //TODO create a new pokemon controller

        //TODO create a route that gives one of the seven deadly sins based on a number
        //TODO you are allowed to hardcode the number inside the route for now

        //TODO choose a number using path variable
        @GetMapping("/{id}/deadly")
        public String deadlySin(@PathVariable int id){
            int choice = rand.nextInt(7)+1;
            switch(id){
                case 1:
                    return "Lust";
                case 2:
                    return "Gluttony";
                case 3:
                    return "Greed";
                case 4:
                    return "Sloth";
                case 5:
                    return "Wrath";
                case 6:
                    return "Envy";
                case 7:
                    return "Pride";
                default:
                    return "no sins were committed";
            }
        }
        //Path variable opgave uden switch
        @GetMapping("/{id}/deadlySin")
        public String deadlySinNoSwitch(@PathVariable int id){
            try {
                return sins.get(id);
            }catch (Exception e) {
                return "Error: " + e.getMessage() + ", please enter a number as pathvariable";
            }
        }

        //TODO make a /trash route that returns whatever input
        @GetMapping("/trash")
        public String returnTrash(@RequestParam String trash, @RequestParam(required = false) String otherTrash) {
            return trash + " " + otherTrash;
        }

        @PostMapping("/rubbishbin")
        public String throwOutRubbish(@RequestBody String rubbish) {
            System.out.println(rubbish);
            return rubbish;
        }




        //@GetMapping()



}
