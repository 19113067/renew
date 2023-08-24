package spring.project.entities;

import java.time.LocalDate;
import java.util.Arrays;

public class Candidate {
	private int candidateId;
	private String fullName;
	private LocalDate dateOfBirth;
	private String nationality;
	private String partyName;
	private byte[] partyLogo;
	private int noOfVotes;
	public Candidate() {
		super();
		
	}
	public Candidate(int candidateId, String fullName, LocalDate dateOfBirth, String nationality, String partyName,
			byte[] partyLogo, int noOfVotes) {
		super();
		this.candidateId = candidateId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.partyName = partyName;
		this.partyLogo = partyLogo;
		this.noOfVotes = 0;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
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
	public void setDateOfBirth(LocalDate age) {
		this.dateOfBirth = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPartyName() {
		return partyName;
	}
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	public byte[] getPartyLogo() {
		return partyLogo;
	}
	public void setPartyLogo(byte[] partyLogo) {
		this.partyLogo = partyLogo;
	}
	 
	public int getNoOfVotes() {
		return noOfVotes;
	}
	public void setNoOfVotes(int noOfVotes) {
		this.noOfVotes = noOfVotes;
	}
	@Override
	public String toString() {
		return "\nCandidate [candidateId=" + candidateId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", nationality=" + nationality + ", partyName=" + partyName + ", partyLogo="
				+ Arrays.toString(partyLogo) + ", noOfVotes=" + noOfVotes + "]";
	}
    public void incrementVotes() {
        this.noOfVotes++;
    }
	
	
	
}