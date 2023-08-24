package spring.project.dao;


public interface VoterDao {
	int registerVoter(Voter voter);
	int updateVoter(Voter voter);
	Voter isVoterRegistered(
			String aadharNumber,
			String password);

			

}
