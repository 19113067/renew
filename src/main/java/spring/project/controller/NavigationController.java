package spring.project.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.project.dao.CandidateDao;
import spring.project.dao.User;
import spring.project.dao.Voter;
import spring.project.dao.VoterDao;
import spring.project.entities.Candidate;
@Controller
public class NavigationController {
	@RequestMapping(value = {"/", "/openAdminPage"})
	public String openAdminPage(Model model) {
		return "login";
	}
	@RequestMapping(value = {"/", "/openVoterLoginPage"})
	public String openVoterLoginPage(Model model) {
		return "voter_login";
	}
	@Autowired
	VoterDao voterDao;
	
	@RequestMapping(value = {"/", "/openCandidateListPage"})
	public String openCandidateListPage(Model model) {
		
		// Step 1: We have to get the list of candidates from the database
		List<Candidate> listOfCandidates = candidateDao.getListOfCandidates();	

		// Step 2: We have to pass the candidates List to candidate_dashboard.jsp
		model.addAttribute("listOfCandidates", listOfCandidates);
		
		return "candidate_list";
	}
	@Autowired
	CandidateDao candidateDao;
	
	@RequestMapping(value = {"/", "/openCandidateDashBoardPage"})
	public String openCandidateDashBoardPage(Model model) {
		
		// Step 1: We have to get the list of candidates from the database
		List<Candidate> listOfCandidates = candidateDao.getListOfCandidates();	

		// Step 2: We have to pass the candidates List to candidate_dashboard.jsp
		model.addAttribute("listOfCandidates", listOfCandidates);
		
		return "candidate_dashboard";
	}
	
	@RequestMapping("/openAddCandidatePage")
	public String openAddCandidatePage() {
		return "candidate_add";
	}
	
	
	
	

}

