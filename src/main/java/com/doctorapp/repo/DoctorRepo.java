package com.doctorapp.repo;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorapp.model.Doctor;
import com.doctorapp.model.DoctorDto;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

	@Query("FROM Doctor d INNER JOIN d.availableSlots slot WHERE d.specialityType = ?1 AND slot = ?2")
	List<Doctor> findByDoctorSpecialityAndAvailability(String specialityType, LocalTime availablity);
	
	@Query("FROM Doctor d INNER JOIN d.address a WHERE d.specialityType = ?1 AND a.city = ?2")
	List<Doctor> findByDoctorSpecialityAndLocation(String specialityType, String city);
	
}
