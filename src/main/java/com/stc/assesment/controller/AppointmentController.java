package com.stc.assesment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stc.assesment.model.Appointments;
import com.stc.assesment.repository.AppointmentRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	 AppointmentRepo appointmentObject;
	
	@GetMapping
	public Flux<Appointments> getAllTodaysAppointments() throws ParseException{
		 Date today = new Date(); 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
		 String convertedTodatString = formatter.format(today);
		 Date todayDate=new SimpleDateFormat("yyyy-mm-dd").parse(convertedTodatString);  
		return (Flux<Appointments>) appointmentObject.findByAppointmentDate(todayDate);	
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/appointments")
	public Mono<Appointments> addAppointment(@RequestBody Appointments appointment) {
		return appointmentObject.save(appointment);
	}
	
	@GetMapping("/{userDate}")
	public Flux<Appointments> getAppointmentsByDate(@PathVariable Date userDate) throws ParseException{
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
		 String convertedTodatString = formatter.format(userDate);
		 Date userFinalDate=new SimpleDateFormat("yyyy-mm-dd").parse(convertedTodatString);  
		return (Flux<Appointments>) appointmentObject.findByAppointmentDate(userFinalDate);	
		
	}
	
	  @PutMapping("/{id}")
	    public Mono<Appointments> cancleAppointment(@RequestBody Appointments Appointments, @PathVariable Integer id,@PathVariable String reason){
	        return appointmentObject.findById(id)
	                        .map((c) -> {
	                            c.setCancellation_status(true);
	                            c.setCancellation_reason(reason);
	                            return c;
	                        }).flatMap( c -> appointmentObject.save(c));

	    }
	  
		@GetMapping("/{appointmentByName}")
		public Flux<Appointments> getAppointmentsByName(@PathVariable int patientID) throws ParseException{
			 
			return (Flux<Appointments>) appointmentObject.findByPaitentId(patientID);	
			
		}
		
		@GetMapping("/{appointmentByPatient}")
		public Flux<Appointments> getAppointmentsByPatientId(@PathVariable int patientID) throws ParseException{
			 
			return (Flux<Appointments>) appointmentObject.findByPaitentId(patientID);	
			
		}
		
		

}
