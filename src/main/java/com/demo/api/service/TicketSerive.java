package com.demo.api.service;

import java.util.List;

import com.demo.api.entity.Ticket;
import com.demo.api.entity.WorkNotes;

public interface TicketSerive {
	
	List<Ticket> listOfTickets();
	List<Ticket> listOfTicketsOfUser(String username);
	
	Ticket addTicket(Ticket ticket);
	
	void deleteTicketById(int id);
	
	Ticket updateById(int id, Ticket ticket);
	
	Ticket getTicketById(int id);
	
	List<WorkNotes> workNotesList(int id);
	
	WorkNotes createWorkNoteForTicket(int id, WorkNotes workNotes);

}
