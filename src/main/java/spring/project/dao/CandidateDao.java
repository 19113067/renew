package spring.project.dao;
import java.util.List;

import spring.project.entities.Candidate;

public interface CandidateDao {
	int insertCandidate(Candidate candidate);
	int updateCandidate(Candidate candidate);
	
	Candidate getCandidate(int candidateId);

	List<Candidate> getListOfCandidates();
	
}
