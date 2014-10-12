package ua.edu.lp.sadiploma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/experimenter", method = RequestMethod.GET)
	public String getExperimenterPage(Model model) {
		model.addAttribute("inputData", new InputData());
		return "experimenter";
	}
	
	@RequestMapping(value="/observer", method = RequestMethod.GET)
	public String getObserverPage(Model model) {
		model.addAttribute("outputList", outputDataService.findAll());
		return "observer";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model){
		//model.addAttribute("inputData", new InputData());
		return "main";
	}
	
	@RequestMapping(value="/setData", method = RequestMethod.POST)
	public String writeInputData(@ModelAttribute("inputData") InputData inputData){
		inputDataService.create(inputData);
		return "main";
	}
}
