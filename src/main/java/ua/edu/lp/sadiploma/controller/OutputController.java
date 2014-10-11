package ua.edu.lp.sadiploma.controller;

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

@Controller
public class OutputController {
	@Autowired
	private InputDataService inputDataService;

	@Autowired
	private OutputDataService outputDataService;

	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public String setData(Model model,
			@ModelAttribute("inputData") InputData inputData,
			BindingResult result) {
		System.err.println("Input data:  " + inputData);
		inputDataService.create(inputData);
		model.addAttribute("outputList", outputDataService.findAll());
		return "output";
	}

}
