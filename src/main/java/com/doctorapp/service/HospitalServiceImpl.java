package com.doctorapp.service;

import java.time.LocalTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorapp.model.Hospital;
import com.doctorapp.model.HospitalDto;
import com.doctorapp.repo.HospitalRepo;

@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	HospitalRepo hospitalRepo;

	@Autowired
	ModelMapper mapper;

	@Override
	public void addMultipleHospital(List<HospitalDto> hospitalDtos) {
		hospitalRepo
				.saveAll(hospitalDtos.stream().map(hospitalDto -> mapper.map(hospitalDto, Hospital.class)).toList());
	}

	@Override
	public void addHospital(HospitalDto hospitalDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateHospital(HospitalDto hospitalDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteHospital(int hospitalId) {
		// TODO Auto-generated method stub

	}

	@Override
	public HospitalDto getById(int hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getAll() {
		List<HospitalDto> hospitalDtos = hospitalRepo.findAll().stream().map(hospital -> mapper.map(hospital, HospitalDto.class)).toList();
			
		return hospitalDtos;
	}

	@Override
	public List<HospitalDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getBySpecialityType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalDto> getByDoctorSpeciality(String speciality) {
		List<HospitalDto> hospitalDtos = hospitalRepo.findByDoctorSpeciality(speciality).stream().map(hospital -> mapper.map(hospital, HospitalDto.class)).toList();
		
		return hospitalDtos;
	}

	@Override
	public List<HospitalDto> getBySpecialityExp(String speciality, int experience) {
		List<HospitalDto> hospitalDtos = hospitalRepo.findBySpecialityExp(speciality, experience).stream().map(hospital -> mapper.map(hospital, HospitalDto.class)).toList();
		
		return hospitalDtos;
	}

	@Override
	public List<HospitalDto> getBySpecialityFees(String speciality, double fees) {
		List<HospitalDto> hospitalDtos = hospitalRepo.findBySpecialityFees(speciality, fees).stream().map(hospital -> mapper.map(hospital, HospitalDto.class)).toList();
		
		return hospitalDtos;
	}

	@Override
	public List<HospitalDto> getByDoctorLocation(String location) {
		List<HospitalDto> hospitalDtos = hospitalRepo.findByDoctorLocation(location).stream().map(hospital -> mapper.map(hospital, HospitalDto.class)).toList();
		
		return hospitalDtos;
	}

	@Override
	public List<HospitalDto> getByDoctorAvailability(LocalTime availability) {
		List<HospitalDto> hospitalDtos = hospitalRepo.findByDoctorAvailability(availability).stream().map(hospital -> mapper.map(hospital, HospitalDto.class)).toList();
		
		return hospitalDtos;
	}

}
