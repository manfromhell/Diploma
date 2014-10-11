package ua.edu.lp.sadiploma.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.edu.lp.sadiploma.entity.InputData;
import ua.edu.lp.sadiploma.service.InputDataService;
import ua.edu.lp.sadiploma.service.OutputDataService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private InputDataService inputDataService;
	
	@Autowired
	private OutputDataService outputDataService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("inputData", new InputData());
		
		return "home";
	}
	
	@RequestMapping(value="/setData", method = RequestMethod.POST)
	public String setData(Model model, @ModelAttribute("inputData") InputData inputData, BindingResult result) {
		System.err.println("Input data:  "+inputData);
		inputDataService.create(inputData);
		model.addAttribute("outputList", outputDataService.findAll());
		return "output";
	}
	
	@RequestMapping(value = "/lp/main", method = RequestMethod.GET)
	public String main(){
		return "main";
	}
	
	@RequestMapping(value = "/lp/info", method = RequestMethod.GET)
	public String info(){
		return "info";
	}
}
