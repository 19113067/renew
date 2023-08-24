package spring.project.dao;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.project.entities.Candidate;

public class RowMapperImpl implements RowMapper<Candidate> {

	public Candidate mapRow(ResultSet rs, int rowNum) throws SQLException {		
		Candidate candidate = new Candidate();
		candidate.setCandidateId(rs.getInt("candidateId"));
		candidate.setFullName(rs.getString("fullName"));
		candidate.setPartyName(rs.getString("partyName"));
		candidate.setNoOfVotes(rs.getInt("noOfVotes"));
		candidate.setNationality(rs.getString("nationality"));
		
		
		// java.sql.Date -> java.time.LocalDate
		candidate.setDateOfBirth(
				rs.getDate("dateOfBirth").toLocalDate());
		
		// Converting Blob into byte[]
		Blob partyLogo = rs.getBlob("partyLogo");
		candidate.setPartyLogo(partyLogo.getBytes(1, (int)partyLogo.length()));
		
		return candidate;
	}

}
