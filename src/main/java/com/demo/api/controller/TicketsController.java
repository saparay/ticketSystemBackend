package com.demo.api.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.entity.Ticket;
import com.demo.api.entity.WorkNotes;
import com.demo.api.service.TicketSerive;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/reso")
public class TicketsController {

	private TicketSerive ticketSerive;

	public TicketsController(TicketSerive ticketSerive) {
		super();
		this.ticketSerive = ticketSerive;
	}

	@GetMapping(path = "/tickets")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD', 'MEMBER')")
	public List<Ticket> retriveAllTickets(){
		return ticketSerive.listOfTickets();
	}
	@GetMapping(path = "/tickets/{username}/user")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD', 'MEMBER')")
	public List<Ticket> retriveTicketsByUser(@PathVariable String username){
		return ticketSerive.listOfTicketsOfUser(username);
	}
	
	@PostMapping(path="/tickets")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD')")
	public ResponseEntity<Ticket> createTicket(@RequestBody @Valid Ticket ticket) {
		ticket.setDateOfRise(LocalDateTime.now());
		Ticket tkt = ticketSerive.addTicket(ticket);
		return ResponseEntity.ok(tkt);
	}
	
	@DeleteMapping(path = "/tickets/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteTicket(@PathVariable int id){
		ticketSerive.deleteTicketById(id);
	}
	
	@PutMapping(path = "/tickets/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD')")
	public Ticket updateTicketById(@PathVariable int id, @RequestBody @Valid Ticket ticket) {
		return ticketSerive.updateById(id, ticket);
	}
	
	@GetMapping(path = "/tickets/{id}")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD', 'MEMBER')")
	public Ticket getTicketById(@PathVariable int id) {
		return ticketSerive.getTicketById(id);
	}
	
	@GetMapping(path = "/tickets/{id}/work-notes")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD', 'MEMBER')")
	public List<WorkNotes> retriveWorkNotesForTicket(@PathVariable int id){
		return ticketSerive.workNotesList(id);
	}
	
	@PostMapping(path = "/tickets/{id}/work-notes")
	@PreAuthorize("hasAnyRole('ADMIN', 'LEAD', 'MEMBER')")
	public WorkNotes addWorkNoteToTicket(@PathVariable int id, @RequestBody WorkNotes workNotes) {
		workNotes.setWorkTime(LocalTime.now());
		return ticketSerive.createWorkNoteForTicket(id, workNotes);
	}
	
	
}
