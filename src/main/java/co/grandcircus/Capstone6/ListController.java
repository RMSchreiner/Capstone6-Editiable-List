package co.grandcircus.Capstone6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.Capstone6.dao.TaskRepository;
import co.grandcircus.Capstone6.dao.UserRepository;
import co.grandcircus.Capstone6.entity.Task;
import co.grandcircus.Capstone6.entity.User;

@Controller
public class ListController {

	private static final String Task = null;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private HttpSession session;


	@RequestMapping("/")
	public String welcomeOrLogin(Model model) {
		if (session.getAttribute("user") !=null) {
			return "welcome";
		}else {
			return "login";
		}
	}	
	@RequestMapping("/login-submit")
	public String submitLoginForm(@RequestParam("email") String email,
			@RequestParam("password") String password, Model model) {

		Optional<User> foundUser = userRepo.findByEmailAndPassword(email, password);
		if(foundUser.isPresent()) {
			session.setAttribute("user", foundUser.get());
			return "redirect:/";
		} else {
			model.addAttribute("message", "Incorrect email or password.");
			//insert message declaring incorrect email or password
			return "login";
		}
	}

	@RequestMapping("/create-account")
	public String accountPage() {
		return "create-account";	
	}

	@PostMapping("/submit-account")
	public String createAccount(@RequestParam("email") String email,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("pTest") String pTest,
			@RequestParam("theme") String theme , Model model) {

		if(password.equals(pTest)) {
			User user = new User(name, email, password, theme);
			userRepo.save(user);

			model.addAttribute("user",user);
			model.addAttribute("message","Your account has been created. Log in.");
			return "login";
		}
		model.addAttribute("message", "Passwords did not match, Try again.");
		return "create-account";
	}
	
	
	@RequestMapping("/change-complete")
	public String changeComplete(@RequestParam("complete") Boolean complete,
			@RequestParam("id") Long id, Model model) {
	   // User user = (User) session.getAttribute("user"); 
		//user = userRepo.findById(user.getId()).get();
		
		if(complete == true) {
			complete = false;}
		else{
			complete = true;}
		
	    Optional<Task> updateTask = taskRepo.findById(id);
	    Task task = new Task();
	    task = updateTask.get();
		task.setComplete(complete);
		taskRepo.save(task);
		return "redirect:/my-task";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") Long id, Model model) { 
		
		taskRepo.deleteById(id);
		
		return "redirect:/my-task";
	}
	

	@RequestMapping ("/my-task")
	public String taskList(Model model) {
		//we know what user is current by getting the user by 'session' and associating the task with that 'userId' below
		User user = (User) session.getAttribute("user");

		model.addAttribute("tasks",taskRepo.findByUserId(user.getId()));

		return "task-list";
	}
	

	@RequestMapping("/add-task")
	public String showAddTaskForm() {
		return "add-task";
	}
	

	@RequestMapping("/submit-task")
	public String submitAddTaskForm(Task task, Model model) { //we will look at the http and see the submit to something....
		System.out.print(task);
		System.out.print(model);
		
	    User user = (User) session.getAttribute("user");
	    System.out.print(user);
		//we get a fresh copy form the data base
		//objects in session can become stale so we update to have most recent info
		//we take the user Object from the session above and use it to get a new object of the user byId below.  
		user = userRepo.findById(user.getId()).get();

		task.setUser(user);
		task.setComplete(false);
		taskRepo.save(task);

		return "redirect:my-task";

	}
}