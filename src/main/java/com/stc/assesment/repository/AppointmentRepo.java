package com.stc.assesment.repository;

import java.util.Date;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.stc.assesment.model.Appointments;

import reactor.core.publisher.Flux;

public interface AppointmentRepo extends ReactiveCrudRepository<Appointments, Integer>{

	Flux<Appointments> findByAppointmentDate(Date today);
	Flux<Appointments> findByPaitentId(int id);

}
