package com.muratesenkaya.travelApp.repository;

import com.muratesenkaya.travelApp.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    // Eğer ileride istersen isimle tag bulmak gibi işlemler de ekleyebilirsin:
    Tag findByName(String name);
}
