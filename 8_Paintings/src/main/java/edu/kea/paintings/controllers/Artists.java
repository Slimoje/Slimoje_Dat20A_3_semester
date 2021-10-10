package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Artists {

    @Autowired
    ArtistRepository artists;

    @GetMapping("/artists")
    public Iterable<Artist> getArtists() {
        return artists.findAll();
    }

    @GetMapping("/artists/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artists.findById(id).get();
    }

    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist newArtist){
        return artists.save(newArtist);
    }

    @PostMapping("/artists/gallery/{artistId}/{galleryId}")
    public Artist addGalleryToArtist(@PathVariable Long galleryId, @PathVariable Long artistId){
        Artist foundArtist = artists.findById(artistId).get();


        return null;
    }

    @PostMapping("/artists/painting/{paintingId}")
    public Artist addGalleryToArtist(@PathVariable Long paintingId){

        return null;
    }

    @PutMapping("/artists/{id}")
    public String replaceGallery(@PathVariable Long id, @RequestBody Artist newArtist) {
        if(artists.existsById(id)) {
            newArtist.setId(id);
            artists.save(newArtist);
            return "Artist was created";
        } else {
            return "Artist not found";
        }

    }

    @PatchMapping("/artists/{id}")
    public String replaceArtist(@PathVariable Long id, @RequestBody Artist newArtist) {
        //blindly trust user's id input
        //newArtist.setId(id);
        //artists.save(newArtist);
        return artists.findById(id).map(foundArtist -> {
            if (newArtist.getName() != null ) {
                foundArtist.setName(newArtist.getName());
            }
            if (newArtist.getAge() != 0) {
                foundArtist.setAge(newArtist.getAge());
            }
            if (newArtist.getGender() != null) {
                foundArtist.setGender(newArtist.getGender());
            }
            if (newArtist.getNationality() != null) {
                foundArtist.setNationality(newArtist.getNationality());
            }
            if (newArtist.getPrimaryStyle() != null) {
                foundArtist.setPrimaryStyle(newArtist.getPrimaryStyle());
            }
            if (newArtist.getBirthDate() != null) {
                foundArtist.setBirthDate(newArtist.getBirthDate());
            }
            artists.save(foundArtist);
            return "Artist updated";
        }).orElse("Artist not found");
    }

    @DeleteMapping("/artists/{id}")
    public String deleteArtist(@PathVariable Long id) {
        String name = artists.findById(id).get().getName();
        artists.deleteById(id);
        return name;
    }


}
