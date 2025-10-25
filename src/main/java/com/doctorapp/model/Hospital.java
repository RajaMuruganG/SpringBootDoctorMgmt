package com.doctorapp.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "hospital_gen")
	@SequenceGenerator(name = "hospital_gen", sequenceName = "hospital_seq", initialValue = 100, allocationSize = 1)
	private Integer hospitalId;
	
	private String hospitalName;
	
	private String hospitalType;
	
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "hospital_id")
	private Set<Doctor> doctors;
}
