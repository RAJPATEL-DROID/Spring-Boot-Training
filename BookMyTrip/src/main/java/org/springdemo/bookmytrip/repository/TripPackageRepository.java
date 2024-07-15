package org.springdemo.bookmytrip.repository;

import org.springdemo.bookmytrip.model.TripPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPackageRepository extends JpaRepository<TripPackage,Long> {

}
