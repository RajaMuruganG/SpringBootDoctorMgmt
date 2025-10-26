package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.DoctorDetailDto;
import com.doctorapp.model.DoctorDto;
import com.doctorapp.repo.DoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	DoctorRepo doctorRepo;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<DoctorDto> getAllDoctor() {
		return doctorRepo.findAll().stream().map(doctor -> mapper.map(doctor, DoctorDto.class)).toList();
	}

	@Override
	public List<DoctorDto> getByDoctorSpecialityAndAvailability(String specialityType, LocalTime availablity) {
		List<DoctorDto> doctorList = doctorRepo.findByDoctorSpecialityAndAvailability(specialityType, availablity)
				.stream().map(doctor -> mapper.map(doctor, DoctorDto.class)).toList();
		return doctorList;
	}

	@Override
	public List<DoctorDto> getByDoctorSpecialityAndLocation(String specialityType, String city) {
		List<DoctorDto> doctorList = doctorRepo.findByDoctorSpecialityAndLocation(specialityType, city)
				.stream().map(doctor -> mapper.map(doctor, DoctorDto.class)).toList();
		return doctorList;
	}

	@Override
	public List<DoctorDetailDto> getByDoctorDetail() {
		return doctorRepo.findByAllDoctorDetail();
	}

}
