package com.projectk.requester.implementations;

import com.projectk.requester.implementations.services.interfaces.UniversityService;
import com.projectk.requester.interfaces.UniversityListingRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UniversityListing implements UniversityListingRequester {
	private UniversityService universityService;

	@Autowired
	public UniversityListing(UniversityService universityService) {
		this.universityService = universityService;
	}

	@Override
	@GetMapping("/universityListing")
	public ModelAndView displayUniversityListing() {
		ModelAndView model = new ModelAndView("/universityListing");
		//todo: get this data from service
		model.addObject("uniName", "Free University of Tbilisi");
		model.addObject("uniDescription", "The best university btw ->|");
		return model;
	}
}
