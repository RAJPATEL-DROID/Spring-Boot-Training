package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
