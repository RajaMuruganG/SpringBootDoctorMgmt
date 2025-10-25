package com.doctorapp.repo;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalDto;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

		//derived query
		List<Hospital> findByCity(String city);
		List<Hospital> findByHospitalType(String type);
		
		//custom query - 2 entities
		@Query("FROM Hospital h INNER JOIN h.doctors d WHERE d.specialityType=?1")
		List<Hospital> findByDoctorSpeciality(String speciality);
		
		@Query("FROM Hospital h INNER JOIN h.doctors d WHERE d.specialityType=?1 and d.experience>?2")
		List<Hospital> findBySpecialityExp(String speciality, int experience);

		@Query("FROM Hospital h INNER JOIN h.doctors d WHERE d.specialityType=?1 and d.fees<?2")
		List<Hospital> findBySpecialityFees(String speciality, double fees);

		@Query("FROM Hospital h INNER JOIN h.doctors d INNER JOIN d.address a WHERE a.city=?1")
		List<Hospital> findByDoctorLocation(String location);
		
		@Query("FROM Hospital h INNER JOIN h.doctors d INNER JOIN d.availableSlots slot WHERE slot IN ?1")
		List<Hospital> findByDoctorAvailability(LocalTime availability);
		
}
