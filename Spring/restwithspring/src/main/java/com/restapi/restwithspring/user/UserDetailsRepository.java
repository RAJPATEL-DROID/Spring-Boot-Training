package com.restapi.restwithspring.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<userDetails, Long> {

}
