package spring.project.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import spring.project.entities.Candidate;

public class CandidateDaoImpl implements CandidateDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insertCandidate(Candidate candidate) {
		String insertQuery = "INSERT INTO "
				+ "candidate"
				+ "(fullName, dateOfBirth,nationality, "
				+ "  partyName,partyLogo,noOfVotes) "
				+ "VALUES (?,?,?,?,?,?)";

		return this.jdbcTemplate.update(
				insertQuery, candidate.getFullName(),
				candidate.getDateOfBirth(), candidate.getNationality(),candidate.getPartyName(),candidate.getPartyLogo(),candidate.getNoOfVotes());
	}
	public Candidate getCandidate(int candidateId) {
		String getSingleCandidate = "SELECT * from candidate WHERE candidateId = ?";

		return this.jdbcTemplate.queryForObject(getSingleCandidate, 
				new RowMapperImpl(), candidateId);
	}


	public List<Candidate> getListOfCandidates() {
		String fetchAllCandidatesQuery = "SELECT * FROM candidate";	
		// RowMapper
		return this.jdbcTemplate.query(
				fetchAllCandidatesQuery, new RowMapperImpl());
	}
	public int updateCandidate(Candidate candidate) {
		String updateQuery = "UPDATE candidate "
				+ "SET noOfVotes = ? ";
		
		return this.jdbcTemplate.update(updateQuery, 
			 candidate.getNoOfVotes());
	}



}
