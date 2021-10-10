package edu.kea.paintings.controllers;


import edu.kea.paintings.models.Gallery;
import edu.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Galleries {

    @Autowired
    GalleryRepository galleries;

    @GetMapping("/galleries")
    public Iterable<Gallery> getGalleries(){
        return galleries.findAll();
    }

    @GetMapping("/galleries/{id}")
    public Gallery getGalleryById(@PathVariable Long id) {
        return galleries.findById(id).get();
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery newGallery){
        return galleries.save(newGallery);
    }

    @PutMapping("/galleries/{id}")
    public String replaceGallery(@PathVariable Long id, @RequestBody Gallery newGallery) {
        if(galleries.existsById(id)) {
            newGallery.setId(id);
            galleries.save(newGallery);
            return "Gallery was created";
        } else {
            return "Gallery not found";
        }

    }

    @PatchMapping("/galleries/{id}")
    public String updateGallery(@PathVariable Long id, @RequestBody Gallery newGallery) {
        return galleries.findById(id).map(foundGallery -> {
            if (newGallery.getOwner() != null) {
                foundGallery.setOwner(newGallery.getOwner());
            }
            if (newGallery.getName() != null) {
                foundGallery.setName(newGallery.getName());
            }
            if (newGallery.getLocation() != null) {
                foundGallery.setLocation(newGallery.getLocation());
            }
            if (newGallery.getSquareFeet() != 0) {
                foundGallery.setSquareFeet(newGallery.getSquareFeet());
            }
            galleries.save(foundGallery);
            return "Gallery updated";
        }).orElse("Gallery not found");
    }

    @DeleteMapping("/galleries/{id}")
    public String deleteGallery(@PathVariable Long id) {
        String name = galleries.findById(id).get().getName();
        galleries.deleteById(id);
        return name;
    }
}
