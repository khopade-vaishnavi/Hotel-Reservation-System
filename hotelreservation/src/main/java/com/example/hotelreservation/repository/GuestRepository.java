package com.example.hotelreservation.repository;

import com.example.hotelreservation.model.GuestMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestMaster,Integer> {
}
