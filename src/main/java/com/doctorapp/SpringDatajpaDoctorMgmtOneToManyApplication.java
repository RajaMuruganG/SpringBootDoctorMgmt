package com.doctorapp;

import java.io.File;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.doctorapp.model.HospitalDto;
import com.doctorapp.service.IDoctorService;
import com.doctorapp.service.IHospitalService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringDatajpaDoctorMgmtOneToManyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaDoctorMgmtOneToManyApplication.class, args);
	}

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	IHospitalService hospitalService;
	
	@Autowired
	IDoctorService doctorService;
	
	@Override
	public void run(String... args) throws Exception {

//		List<HospitalDto> hospitals = objectMapper.readValue(new File("src/main/resources/multiple-hospitals.json"),
//				new TypeReference<List<HospitalDto>>() {
//				});
//		HospitalDto hospitalDto = objectMapper.readValue(inputStream, HospitalDto.class);
//		System.out.println("----Hardcoded Hospital---");
//		hospitals.forEach(System.out::println);
//		hospitalService.addMultipleHospital(hospitals);
//		
		System.out.println("----List of Hospital---");
		hospitalService.getAll().forEach(System.out::println);
		System.out.println("");
		
		System.out.println("----List of Hospital based on doctor speciality---");
		hospitalService.getByDoctorSpeciality("ENT").forEach(System.out::println);
		System.out.println("");
		
		System.out.println("----List of Hospital based on doctor speciality and exp---");
		hospitalService.getBySpecialityExp("Orthopedics",5).forEach(System.out::println);
		System.out.println("");
		
		System.out.println("----List of Hospital based on doctor speciality and fees---");
		hospitalService.getBySpecialityFees("ENT",1000).forEach(System.out::println);
		System.out.println("");
		
		
		System.out.println("----List of Hospital based on doctor location---");
		hospitalService.getByDoctorLocation("Chennai").forEach(System.out::println);
		System.out.println("");
		
		System.out.println("----List of Hospital based on doctor availability---");
		hospitalService.getByDoctorAvailability(LocalTime.of(15, 15)).forEach(System.out::println);
		System.out.println("");
		
		System.out.println("-------------------------------------------------------");
		System.out.println("");
		
		System.out.println("----List of All Doctors----");
		doctorService.getAllDoctor().forEach(System.out::println);
		
		System.out.println("----List of All Doctors By Speciality and availablity----");
		doctorService.getByDoctorSpecialityAndAvailability("Orthopedics",LocalTime.of(9, 0)).forEach(System.out::println);
		
		System.out.println("----List of All Doctors By Speciality and availablity----");
		doctorService.getByDoctorSpecialityAndLocation("Orthopedics","Chennai").forEach(System.out::println);
		
	}

}
