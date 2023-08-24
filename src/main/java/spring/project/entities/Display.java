package spring.project.entities;

import java.util.Arrays;

public class Display {
	private String candidateName;
	private String partyName;
	private byte[] partyLogo;
	public Display() {
		super();
			}
	public Display(String candidateName, String partyName, byte[] partyLogo) {
		super();
		this.candidateName = candidateName;
		this.partyName = partyName;
		this.partyLogo = partyLogo;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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
	@Override
	public String toString() {
		return "\nDisplay [candidateName=" + candidateName + ", partyName=" + partyName + ", partyLogo="
				+ Arrays.toString(partyLogo) + "]";
	}
	}
	
	



