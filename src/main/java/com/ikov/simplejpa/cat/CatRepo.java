package com.ikov.simplejpa.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {

    List<Cat> findCatsByAgeBefore(int age);

}
