package spring.project.dao;
import java.time.LocalDate;
import java.util.Arrays;

import spring.project.entities.Candidate;

public class Voter {
	private String fullName;
	private LocalDate dateOfBirth;
	private String aadharNumber;
	private String password;
	private String nationality;
	private byte[] file;
	private Boolean status;
	public Voter() {
		super();
	}
	public Voter(String fullName, LocalDate dateOfBirth, String aadharNumber, String password, String nationality,
			byte[] file, Boolean status) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.aadharNumber = aadharNumber;
		this.password = password;
		this.nationality = nationality;
		this.file = file;
		this.status = status;
	}
	
	public String getFullName() {
		
		return fullName;
		
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "\nVoter [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", aadharNumber=" + aadharNumber
				+ ", password=" + password + ", nationality=" + nationality + ", file=" + Arrays.toString(file)
				+ ", status=" + status + "]";
	}

	   public boolean hasVotedFor(Candidate candidate) {
	        // Assuming you have a collection of voted candidates
	        // Check if the candidate exists in the collection
	        // Return true if voted, false if not voted
	        return false;
	    }

	    public void addVotedCandidate(Candidate candidate) {
	        // Assuming you have a collection of voted candidates
	        // Add the candidate to the collection
	    }
	

}
