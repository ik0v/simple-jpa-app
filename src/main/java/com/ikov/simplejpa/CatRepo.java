package com.ikov.simplejpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {

}
