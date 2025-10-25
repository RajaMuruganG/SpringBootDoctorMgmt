package com.doctorapp.model;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "doctor_gen")
	@SequenceGenerator(name = "doctor_gen", sequenceName = "doctor_seq", initialValue = 100, allocationSize = 1)
	private Integer doctorId;

	private String doctorName;
	@Column(unique = true)
	private String emailId;

	private int experience;
	
	private double fees;

	private String specialityType;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "doc_availability", joinColumns = @JoinColumn(name = "doctor_id"))
	private List<LocalTime> availableSlots;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;
}
