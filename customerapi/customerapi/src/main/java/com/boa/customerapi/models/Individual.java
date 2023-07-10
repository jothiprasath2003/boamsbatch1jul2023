package com.boa.customerapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="Individual")
@Data
@EqualsAndHashCode(callSuper=false)
public class Individual extends Customer{
    @Enumerated(EnumType.STRING)
    @Column(name="Gender")
	private Gender gender;
    @Column(name="DOB")
    @DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
}