package com.demo.api.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "Ticket_Name")
	@Nonnull
	@Size(min=5, message = "Ticket name must be alteast 5 char")
	private String ticketName;
	@Nonnull
	private String priority;
	@Nonnull
	@Size(min=5, message = "Ticket Employee Id must be alteast 5 char")
	private String username;
	@Size(min=5, message = "Ticket description must be alteast 5 char")
	private String description;
	@Nonnull
	private String status;
	@Column(name = "Date_Of_Rise")
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
	private LocalDateTime dateOfRise;
	@Column(name = "Date_Of_Close")
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
	private LocalDateTime dateOfClose;
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	private List<WorkNotes> workNotes;
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(Integer id, @Size(min = 5, message = "Ticket name must be alteast 5 char") String ticketName,
			String priority, @Size(min = 5, message = "Ticket Employee Id must be alteast 5 char") String username,
			@Size(min = 5, message = "Ticket description must be alteast 5 char") String description, String status,
			LocalDateTime dateOfRise, LocalDateTime dateOfClose, List<WorkNotes> workNotes) {
		super();
		this.id = id;
		this.ticketName = ticketName;
		this.priority = priority;
		this.username = username;
		this.description = description;
		this.status = status;
		this.dateOfRise = dateOfRise;
		this.dateOfClose = dateOfClose;
		this.workNotes = workNotes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getDateOfRise() {
		return dateOfRise;
	}
	public void setDateOfRise(LocalDateTime dateOfRise) {
		this.dateOfRise = dateOfRise;
	}
	public LocalDateTime getDateOfClose() {
		return dateOfClose;
	}
	public void setDateOfClose(LocalDateTime dateOfClose) {
		this.dateOfClose = dateOfClose;
	}
	public List<WorkNotes> getWorkNotes() {
		return workNotes;
	}
	public void setWorkNotes(List<WorkNotes> workNotes) {
		this.workNotes = workNotes;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketName=" + ticketName + ", priority=" + priority + ", username=" + username
				+ ", description=" + description + ", status=" + status + ", dateOfRise=" + dateOfRise
				+ ", dateOfClose=" + dateOfClose + ", workNotes=" + workNotes + "]";
	}
	
	
}
