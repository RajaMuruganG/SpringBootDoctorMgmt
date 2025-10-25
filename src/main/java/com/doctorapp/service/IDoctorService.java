package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;

import com.doctorapp.model.DoctorDto;

public interface IDoctorService {

	List<DoctorDto> getAllDoctor();
	
	List<DoctorDto> getByDoctorSpecialityAndAvailability(String specialityType, LocalTime availablity);
	
	List<DoctorDto> getByDoctorSpecialityAndLocation(String specialityType, String city);
}
