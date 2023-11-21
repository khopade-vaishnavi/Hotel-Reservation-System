package com.example.hotelreservation.repository;

import com.example.hotelreservation.model.ReservationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationMaster,Integer> {
}
