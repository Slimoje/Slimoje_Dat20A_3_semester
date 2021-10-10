package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.PaintingRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="Paintings controller", description = "REST endpoints for painting")
@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;

    @GetMapping("/paintings")
    public Iterable<Painting> getPaintings() {
        return paintings.findAll();
    }

    @GetMapping("/paintings/{id}")
    public Painting getPaintingById(@PathVariable Long id) {
        return paintings.findById(id).get();
    }

    @GetMapping("/paintings/timeline")
    public Iterable<Painting> getPaintingsByArtistAndYear(@RequestParam String artist, @RequestParam int year){
        return paintings.findPaintingsByArtistAndYear(artist, year);
    }

    @GetMapping("/paintings/priceabove/{price}")
    public Iterable<Painting> getPaintingsAboveACertainPrice(@PathVariable double price){
        return paintings.findPaintingAboveACertainPrice(price);
    }

    @PostMapping("/paintings")
    public Painting addPainting(@RequestBody Painting newPainting){
        return paintings.save(newPainting);
    }
    @PutMapping("/paintings/{id}")
    public String replacePainting(@PathVariable Long id, @RequestBody Painting newPainting) {
        if(paintings.existsById(id)) {
            newPainting.setId(id);
            paintings.save(newPainting);
            return "Painting was created";
        } else {
            return "Painting not found";
        }

    }

    @PatchMapping("/paintings/{id}")
    public String updatePainting(@PathVariable Long id, @RequestBody Painting newPainting) {
        //blindly trust user's id input
        //newPainting.setId(id);
        //paintings.save(newPainting);
        return paintings.findById(id).map(foundPainting -> {
            if (newPainting.getArtist() != null) {
                foundPainting.setArtist(newPainting.getArtist());
            }
            if (newPainting.getPrice() != 0) {
                foundPainting.setPrice(newPainting.getPrice());
            }
            if (newPainting.getTitle() != null) {
                foundPainting.setTitle(newPainting.getTitle());
            }
            if (newPainting.getGenre() != null) {
                foundPainting.setGenre(newPainting.getGenre());
            }
            if (newPainting.getYear() != 0) {
                foundPainting.setYear(newPainting.getYear());
            }

            paintings.save(foundPainting);
            return "Painting updated";
        }).orElse("Painting not found");
    }

    @DeleteMapping("/paintings/{id}")
    public String deletePainting(@PathVariable Long id) {
        String name = paintings.findById(id).get().getArtist();
        paintings.deleteById(id);
        return name;
    }
}
