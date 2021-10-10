package edu.kea.paintings.repositories;


import edu.kea.paintings.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
