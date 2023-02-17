package com.demo.api.entity;

import java.sql.Time;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class WorkNotes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Size(min = 6)
	private String workNote;
	private LocalTime workTime;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Ticket ticket;
	public WorkNotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkNotes(Integer id, String workNote, LocalTime workTime, Ticket ticket) {
		super();
		this.id = id;
		this.workNote = workNote;
		this.workTime = workTime;
		this.ticket = ticket;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getWorkNote() {
		return workNote;
	}
	public void setWorkNote(String workNote) {
		this.workNote = workNote;
	}
	public LocalTime getWorkTime() {
		return workTime;
	}
	public void setWorkTime(LocalTime workTime) {
		this.workTime = workTime;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "WorkNotes [id=" + id + ", workNote=" + workNote + ", workTime=" + workTime + ", ticket=" + ticket + "]";
	}
	
	
}
