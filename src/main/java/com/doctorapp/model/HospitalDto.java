package com.doctorapp.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HospitalDto {

	private Integer hospitalId;
	private String hospitalName;
	private String hospitalType;
	private String city;
	private Set<DoctorDto> doctors;
}
