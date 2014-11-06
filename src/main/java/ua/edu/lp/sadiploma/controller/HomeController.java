package ua.edu.lp.sadiploma.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.edu.lp.sadiploma.entity.InputData;
import ua.edu.lp.sadiploma.entity.OutputData;
import ua.edu.lp.sadiploma.service.InputDataService;
import ua.edu.lp.sadiploma.service.OutputDataService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger log = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private InputDataService inputDataService;

	@Autowired
	private OutputDataService outputDataService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/experimenter", method = RequestMethod.GET)
	public String getExperimenterPage(Model model) {
		model.addAttribute("inputData", new InputData());
		return "experimenter";
	}

	@RequestMapping(value = "/observer", method = RequestMethod.GET)
	public String getObserverPage(Model model) {
		model.addAttribute("inputList", inputDataService.findAll());
		model.addAttribute("outputList", outputDataService.findAll());
		return "observer";
	}

	@RequestMapping(value = { "/", "/main" }, method = RequestMethod.GET)
	public String main(Model model) {
		// model.addAttribute("inputData", new InputData());
		return "main";
	}

	@RequestMapping(value = "/setData", method = RequestMethod.POST)
	public String writeInputData(
			@ModelAttribute("inputData") InputData inputData) {
		log.info(String.format("POST setdata: inputData = %s", inputData));
		inputData.setDone(false);
		int numberOfNodes = inputDataService.getNumberOfNodes(inputData
				.getParentCode());
		System.err.println("Number of nodes!: " + numberOfNodes);
		String treeType = inputDataService.getTreeType(inputData.getRepCoef(),
				inputData.getGapsCoef());
		inputData.setTreeType(treeType);
		inputData.setNumberOfNodes(numberOfNodes);
		System.err.println("Number of nodes in input data: "
				+ inputData.getNumberOfNodes());
		inputDataService.create(inputData);
		return "main";
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public String filteroutput(
			@RequestParam(value = "parentCode") String parentCode,
			@RequestParam(value = "numberOfNodesFrom") int numberOfNodesFrom,
			@RequestParam(value = "numberOfNodesTo") int numberOfNodesTo,
			@RequestParam(value = "comment") String comment,
			@RequestParam(value = "startTimeFrom") Date startTimeFrom,
			@RequestParam(value = "startTimeTo") Date startTimeTo,
			@RequestParam(value = "finishTimeFrom") Date finishTimeFrom,
			@RequestParam(value = "finishTimeTo") Date finishTimeTo,
			Model model) {
		System.err.println("Parent code: "+parentCode);
		System.err.println("Number of nodes from: "+numberOfNodesFrom);
		System.err.println("Number of nodes to: "+numberOfNodesTo);
		System.err.println("Comment: "+comment);
		System.err.println("Start time from: "+startTimeFrom);
		System.err.println("Start time to: "+startTimeTo);
		System.err.println("Finish time from: "+finishTimeFrom);
		System.err.println("Finish time to: "+finishTimeTo);
		return "observer";
	}
}
