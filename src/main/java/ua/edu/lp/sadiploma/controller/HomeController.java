package ua.edu.lp.sadiploma.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;






import ua.edu.lp.sadiploma.entity.InputData;
import ua.edu.lp.sadiploma.entity.OutputData;
import ua.edu.lp.sadiploma.service.InputDataService;
import ua.edu.lp.sadiploma.service.OutputDataService;
import ua.edu.lp.sadiploma.tool.PictureSize;
import ua.edu.lp.sadiploma.tool.Proba;

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
			@RequestParam(value = "startTimeFrom") String startTimeFrom,
			@RequestParam(value = "startTimeTo") String startTimeTo,
			@RequestParam(value = "finishTimeFrom") String finishTimeFrom,
			@RequestParam(value = "finishTimeTo") String finishTimeTo,
			Model model) {
		System.err.println("Parent code: "+parentCode);
		System.err.println("Number of nodes from: "+numberOfNodesFrom);
		System.err.println("Number of nodes to: "+numberOfNodesTo);
		System.err.println("Comment: "+comment);
		System.err.println("Start time from: "+startTimeFrom);
		System.err.println("Start time to: "+startTimeTo);
		System.err.println("Finish time from: "+finishTimeFrom);
		System.err.println("Finish time to: "+finishTimeTo);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date startTimeFromDate=null;
		Date startTimeToDate=null;
		Date finishTimeFromDate=null;
		Date finishTimeToDate=null;
		try {
			startTimeFromDate = dateFormat.parse(startTimeFrom);
			startTimeToDate = dateFormat.parse(startTimeTo);
			finishTimeFromDate = dateFormat.parse(finishTimeFrom);
			finishTimeToDate = dateFormat.parse(finishTimeTo);
		} catch (ParseException e) {
			System.err.println("Parse exception!");
			e.printStackTrace();
		}
		System.err.println("Start time from d : "+startTimeFromDate);
		System.err.println("Start time to d : "+startTimeToDate);
		
		List<OutputData> result = outputDataService.filterOutput(numberOfNodesFrom, numberOfNodesTo, comment, startTimeFromDate, startTimeToDate, finishTimeFromDate, finishTimeToDate);
		System.err.println("Result of filtering!!!: "+result.toString());
		model.addAttribute("outputList",result);
		return "observer";
	}
	
	@RequestMapping(value="/request", method=RequestMethod.GET)
	public String executeQuery(@RequestParam(value="query") String query, Model model){
		List<OutputData> result = outputDataService.executeRequest(query);
		System.err.println("Result of request!!!: "+result.toString());
		model.addAttribute("outputList",result);
		return "observer";
	}

	@RequestMapping(value="/info/{id}", method=RequestMethod.GET)
	public String info(@PathVariable(value="id") Long id, Model model){
		OutputData result = outputDataService.findById(id);
		System.err.println("Result of info: "+result.toString());
		model.addAttribute("output",result);
		return "output_info";
	}
	
	@RequestMapping("/getPicture")
	public @ResponseBody PictureSize getPicture(
			@RequestParam(value="parentCode") String parentCode, HttpServletRequest httpServletRequest){
		System.err.println("Parent code: "+parentCode);
		log.info("REAL PATH: "+httpServletRequest.getSession().getServletContext().getRealPath("/"));
		Proba proba = new Proba(httpServletRequest.getSession().getServletContext().getRealPath("/"));
		PictureSize pictureSize = proba.generatePicture(parentCode);
		return pictureSize;
	}
}
