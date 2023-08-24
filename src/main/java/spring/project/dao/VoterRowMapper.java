package spring.project.dao;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class VoterRowMapper implements RowMapper<Voter> {
	@Override
	public Voter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voter voter = new Voter();
		
		voter.setFullName(rs.getString("fullName"));
		voter.setDateOfBirth(
				rs.getDate("dateOfBirth").toLocalDate());
		
		voter.setAadharNumber(rs.getString("aadharNumber"));
		voter.setPassword(rs.getString("password"));
		voter.setNationality(rs.getString("nationality"));
		
		Blob file = rs.getBlob("file");
		voter.setFile(file.getBytes(1, (int)file.length()));
		
		voter.setStatus(rs.getBoolean("status"));
		return voter;
	}

}
