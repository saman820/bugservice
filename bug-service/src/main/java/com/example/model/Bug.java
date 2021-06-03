package com.example.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bugs")
public class Bug {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bug_id", nullable = false, unique = true)
	private int bugId;

	@Column(name = "description", nullable = false)
	private String bugDescription;

	@Column(name = "submission_date", nullable = false)
	private LocalDateTime bugSubmissionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	private User bugOwner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id_fk")
	private Status bugStatus;

	public Bug(int bugId, String bugDescription, LocalDateTime bugSubmissionDate, User bugOwner, Status bugStatus) {
		super();
		this.bugId = bugId;
		this.bugDescription = bugDescription;
		this.bugSubmissionDate = bugSubmissionDate;
		this.bugOwner = bugOwner;
		this.bugStatus = bugStatus;
	}

	public Bug(String bugDescription, LocalDateTime bugSubmissionDate, User bugOwner, Status bugStatus) {
		super();
		this.bugDescription = bugDescription;
		this.bugSubmissionDate = bugSubmissionDate;
		this.bugOwner = bugOwner;
		this.bugStatus = bugStatus;
	}

	public Bug() {
		super();
	}

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	public LocalDateTime getBugSubmissionDate() {
		return bugSubmissionDate;
	}

	public void setBugSubmissionDate(LocalDateTime bugSubmissionDate) {
		this.bugSubmissionDate = bugSubmissionDate;
	}

	public User getBugOwner() {
		return bugOwner;
	}

	public void setBugOwner(User bugOwner) {
		this.bugOwner = bugOwner;
	}

	public Status getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(Status bugStatus) {
		this.bugStatus = bugStatus;
	}

	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", bugDescription=" + bugDescription + ", bugSubmissionDate=" + bugSubmissionDate
				+ ", bugOwner=" + bugOwner + ", bugStatus=" + bugStatus + "]";
	}

}
