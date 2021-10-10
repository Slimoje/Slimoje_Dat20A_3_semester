package edu.kea.paintings.repositories;

import edu.kea.paintings.models.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PaintingRepository extends JpaRepository<Painting, Long> {

    Iterable<Painting> findPaintingsByArtistAndYear(String artistName, int year);

    @Query(
            value = "SELECT * FROM paintings WHERE price > ?",
            nativeQuery = true)
    Iterable<Painting> findPaintingAboveACertainPrice(double price);
}
