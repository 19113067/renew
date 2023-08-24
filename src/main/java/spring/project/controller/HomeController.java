package spring.project.controller;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import spring.project.dao.CandidateDao;
import spring.project.entities.Candidate;
import spring.project.dao.User;
import spring.project.dao.UserDao;
import spring.project.dao.Voter;
import spring.project.dao.VoterDao;
@Controller

public class HomeController {
	 
	
	@GetMapping(value = { "/", "/openIndexPage" })
	public String openIndexPage() {
		return "index";
	}

	@Autowired
	UserDao userDao;


	@GetMapping("/openLoginPage")
	public String openLoginPage() {
		return "login";
	}
	
	@GetMapping("/openRegistrationPage")
	public String openRegistrationPage() {
		return "registration";
	}

	@PostMapping("/register")
	public String register(
			@ModelAttribute("user") User user, 
			Model model) {

		int result = userDao.registerUser(user);

		if (result == 1) {
			model.addAttribute("result", "Registered successfully. Login to continue");
			return "login";
		} else {
			model.addAttribute("result", "Registration failed. Try again");
			return "registration";
		}
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
		
		System.out.println(user);
		
		try {
			User registeredUser = userDao.isUserRegistered(user.getUsername(), user.getPassword());

			if (registeredUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", registeredUser);
				
				System.out.println(session.getAttribute("user"));
				
				return "redirect:openCandidateDashBoardPage";
			} else {
				
				model.addAttribute("result", "Can't find credentials");
				return "login";
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			model.addAttribute("result", "Can't find credentials");
			return "index";
		}
	}
	@GetMapping("/logout")
	public String processLogout(HttpSession session, 
			Model attr) {

		System.out.println(session.getAttribute("user"));
		session.invalidate();
		attr.addAttribute("result", "Logged out successfully");
		return "login";
	}

	

	@Autowired
	VoterDao voterDao;
	
	@GetMapping("/openVoterLoginPage")
	public String openVoterLoginPage() {
		return "voter_login";
	}
	
	@GetMapping("/openVoterRegistrationPage")
	public String openVoterRegistrationPage() {
		return "voter_registration";
	}

	@PostMapping("/register1")
	public String register(
			@RequestParam("full_name") String fullName,
		    @RequestParam("date_of_birth") String dateOfBirth,
		    @RequestParam("aadhar_number") String aadharNumber,
		    @RequestParam("nationality") String nationality,
		    @RequestParam("password") String password,
		    @RequestParam("status") boolean status,
		    @RequestParam("file") MultipartFile file,
		    
		    Model model
		) {

		    Voter voter = new Voter();

		    voter.setFullName(fullName);
		    voter.setDateOfBirth(LocalDate.parse(dateOfBirth));
		    voter.setAadharNumber(aadharNumber);
		    voter.setNationality(nationality);
		    voter.setPassword(password);
		    voter.setStatus(status);


		    try {
		        voter.setFile(file.getBytes());
		    } catch (IOException e) {
		        e.printStackTrace();
		    }

		    
		    System.out.println(voter);

		    int result = voterDao.registerVoter(voter);
		    System.out.println("Result = " + result);


		if (result == 1) {
			model.addAttribute("result", "Registered successfully. Login to continue");
			return "voter_login";
		} else {
			model.addAttribute("result", "Registration failed. Try again");
			return "voter_registration";
		}
	}
	@PostMapping("/login1")
	public String login(@ModelAttribute("voter") Voter voter, Model model, HttpServletRequest request) {
		
		System.out.println(voter);
		
		try {
			Voter registeredVoter = voterDao.isVoterRegistered(

					voter.getAadharNumber(),
					voter.getPassword()

					);
					
					

			if (registeredVoter != null) {
				HttpSession session = request.getSession();
				session.setAttribute("voter", registeredVoter);
				
				System.out.println(session.getAttribute("voter"));
				
				return "redirect:openCandidateListPage";
			} else {
				
				model.addAttribute("result", "Can't find credentials");
				return "voter_login";
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			model.addAttribute("result", "Can't find credentials");
			return "index";
		}
	}

	@GetMapping("/logout1")
	public String processLogout1(HttpSession session, 
			Model attr) {

		System.out.println(session.getAttribute("voter"));
		session.invalidate();
		attr.addAttribute("result", "Logged out successfully");
		return "voter_login";
	}
	

	
	@Autowired
	CandidateDao candidateDao;


	@RequestMapping("/add")
	public String addCandidateRequest(
	    @RequestParam("full_name") String fullName,
	    @RequestParam("date_of_birth") String dateOfBirth,
	    @RequestParam("nationality") String nationality,
	    @RequestParam("party_name") String partyName,
	    @RequestParam("party_logo") MultipartFile partyLogo,
	    @RequestParam("no_of_votes") int noOfVotes,
	    Model model
	) {

	    Candidate candidate = new Candidate();

	    candidate.setFullName(fullName);
	    candidate.setDateOfBirth(LocalDate.parse(dateOfBirth));
	    candidate.setNationality(nationality);
	    candidate.setPartyName(partyName);

	    try {
	        candidate.setPartyLogo(partyLogo.getBytes());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    candidate.setNoOfVotes(noOfVotes);

	    System.out.println(candidate);

	    int result = candidateDao.insertCandidate(candidate);
	    System.out.println("Result = " + result);

	    if (result ==1) {
	        List<Candidate> listOfCandidates = candidateDao.getListOfCandidates();

	        List<Candidate> filteredCandidates = new ArrayList<>();
	        
	        for (Candidate candidates : listOfCandidates) {
	            if ("INDIAN".equalsIgnoreCase(nationality) || "Indian".equalsIgnoreCase(nationality)) {
	                LocalDate birthDate = candidate.getDateOfBirth();
	                LocalDate currentDate = LocalDate.now();
	                
	                int age = Period.between(birthDate, currentDate).getYears();

	                if (age >= 35) {
	                    candidate.setDateOfBirth(LocalDate.now().minusYears(age));
	                    filteredCandidates.add(candidates);
	                }
	            }
	        }

	        model.addAttribute("listOfCandidates", filteredCandidates);
	        model.addAttribute("message", "Candidate Added Successfully");

	        return "candidate_dashboard";
	    } else {
	        model.addAttribute("message", "Candidate cannot be added");
	        return "candidate_add";
	    }
	   
	}
	@RequestMapping("/update/{candidateId}")
	public ModelAndView updateCandidateRequest(
	        @RequestParam("fullName") String fullName,
	        @RequestParam("partyName") String partyName,
	        @RequestParam("partyLogo") MultipartFile partyLogo,
	        @RequestParam("noOfVotes") int updatedVoteCount,
	        @PathVariable("candidateId") int candidateId
	) {

	    ModelAndView modelAndView = new ModelAndView();
	    
	    Candidate candidate = candidateDao.getCandidate(candidateId);

	    candidate.setFullName(fullName);
	    candidate.setPartyName(partyName);

	    try {
	        if (!partyLogo.isEmpty()) {
	            candidate.setPartyLogo(partyLogo.getBytes());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    candidate.setNoOfVotes(updatedVoteCount); // Update the vote count

	    int result = candidateDao.updateCandidate(candidate);

	    if (result > 0) {
	        List<Candidate> listOfCandidates = candidateDao.getListOfCandidates();

	        modelAndView.addObject("listOfCandidates", listOfCandidates);
	        modelAndView.addObject("message", "Candidate Updated Successfully");
	        modelAndView.setViewName("candidate_list");
	    } else {
	        modelAndView.addObject("message", "Candidate could not be Updated");
	        modelAndView.setViewName("candidate_list");
	    }

	    return modelAndView;
	}

}
	

