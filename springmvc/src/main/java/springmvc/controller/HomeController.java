package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	

	@RequestMapping(path = "/home")
	public String home(Model model) {
		System.out.println("Inside the Home Page");
		model.addAttribute("name","Robin");
		return "home";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("suggestion","help page");
		mv.setViewName("help");
		return mv;
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String name, @RequestParam("password") String password, Model model) {
		model.addAttribute("name",name);
		if ("admin123".equals(password)) {
			return "home";
		}else {
			return "redirect:/error";
		}
	}
	
	@RequestMapping(path="/loginRequest", method=RequestMethod.POST)

	public String login(HttpServletRequest request,Model model) {
		String name=request.getParameter("username");
		model.addAttribute("name",name);
		String password = request.getParameter("password");
		if ("admin123".equals(password)) {
			return "home";
		}else {
			return "redirect:/error";
		}
	}
	
	
	@RequestMapping(path="/loginModel", method=RequestMethod.POST)
	public String login(@ModelAttribute User user,Model model) {
		System.out.println("Inside login");
		model.addAttribute("name",user.getUsername());
		String password = user.getPassword();
		if ("admin123".equals(password)) {
			return "home";
		}else {
			return "redirect:/error";
		}
	}
	
	@RequestMapping("/sumModel")
	public ModelAndView getTwoSum(@RequestParam("username") String num1, @RequestParam("password") String num2) {
	
		int ni = Integer.parseInt(num1);
		int nt = Integer.parseInt(num2);
		
		int sum = ni+nt;
		
		ModelAndView model = new ModelAndView();
		
		System.out.print("Sum: "+sum);
		model.addObject("sumTwo", sum);
		model.setViewName("result");
		return model;
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}

}
