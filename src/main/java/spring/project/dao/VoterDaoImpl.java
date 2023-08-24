package spring.project.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;



public class VoterDaoImpl implements VoterDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int registerVoter(Voter voter) {
		String insertQuery = "INSERT INTO voters "
				+ "(fullName,dateOfBirth,aadharNumber,password,nationality,file,status) "
				+ "VALUES (?,?,?,?,?,?,?)";
		
		System.out.println("Here we are getting the full name");
		
		
		return jdbcTemplate.update(
				insertQuery, 
				voter.getFullName(),
				voter.getDateOfBirth(),
				voter.getAadharNumber(),
				voter.getPassword(), 
				voter.getNationality(),
				voter.getFile(),
				voter.getStatus());
				
		
	}

	@Override
	public Voter isVoterRegistered(String aadharNumber, String password) throws DataAccessException {
		String checkQuery = "SELECT * FROM voters WHERE  aadharNumber = ? AND password = ?";
		Voter voter = null;
		
		if(aadharNumber != null && !aadharNumber.isEmpty() ) {
			if( password != null && !password.isEmpty()) {
				System.out.println("voter : " + voter);
				voter = jdbcTemplate.queryForObject(checkQuery, new VoterRowMapper(), aadharNumber, password); 
			}
		
		}
		System.out.println("-------");
		System.out.println(voter);
		return voter;
	}
	
	public int updateVoter(Voter voter) {
		String updateQuery = "UPDATE voters "
				+ "SET status = ? ";
		
		return this.jdbcTemplate.update(updateQuery, 
				voter.getStatus());
	}
	

}
