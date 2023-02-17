package com.demo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.api.entity.Ticket;
import com.demo.api.entity.WorkNotes;
import com.demo.api.repository.TicketRepository;
import com.demo.api.repository.WorkNotesRepository;


@Service
public class TicketSeriveImpl implements TicketSerive{
	
	private TicketRepository ticketRepository;
	private WorkNotesRepository workNotesRepository;

	public TicketSeriveImpl(TicketRepository ticketRepository, WorkNotesRepository workNotesRepository) {
		super();
		this.ticketRepository = ticketRepository;
		this.workNotesRepository = workNotesRepository;
	}

	@Override
	public List<Ticket> listOfTickets() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket updateById(int id, Ticket ticket) {
		Optional<Ticket> tkt = ticketRepository.findById(id);
		
		tkt.ifPresent(t -> {t.setTicketName(ticket.getTicketName());
							t.setDateOfRise(ticket.getDateOfRise().now());
							t.setDateOfClose(ticket.getDateOfClose().now());
							t.setDescription(ticket.getDescription());
							t.setPriority(ticket.getPriority());
							t.setStatus(ticket.getStatus());
							t.setUsername(ticket.getUsername());
			
		});
		return ticketRepository.save(tkt.orElseThrow(null));
	}

	@Override
	public Ticket getTicketById(int id) {
		Optional<Ticket> tkt = ticketRepository.findById(id);
		return tkt.get();
	}

	@Override
	public List<WorkNotes> workNotesList(int id) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		if(ticket.isEmpty()) return null;
		return ticket.get().getWorkNotes();
	}

	@Override
	public WorkNotes createWorkNoteForTicket(int id, WorkNotes workNotes) {
		Optional<Ticket> ticket = ticketRepository.findById(id);
		
		workNotes.setTicket(ticket.get());
		
		return workNotesRepository.save(workNotes);
	}

	@Override
	public List<Ticket> listOfTicketsOfUser(String username) {
		return ticketRepository.findByUsername(username);
	}
	
	
	
}