package com.projectk.requester.implementations.services.implementations;

import com.projectk.entities.University;
import com.projectk.entities.ServiceResult;
import com.projectk.requester.implementations.services.interfaces.UniversityService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.implementations.universityManager.UniversityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UniversityServiceImpl implements UniversityService {
	private UniversityManager universityManager;

	@Autowired
	public UniversityServiceImpl(UniversityManager universityManager) {
		this.universityManager = universityManager;
	}

	@Override
	public ServiceResult addUniversity(University university) {
		String view = "";
		Map<String, Object> modelMap = new HashMap<>();
		try {
			universityManager.add(university);
			view = "/user/UserPage";
		} catch (StorageException e) {
			modelMap.put("errorMessage", "Couldn't add university");
			view = "universityAdd";
		}
		return new ServiceResult(view, modelMap);
	}

	@Override
	public ServiceResult updateUniversity(University university) {
		String view = "universityAdd";
		Map<String, Object> modelMap = new HashMap<>();
		try {
			universityManager.update(university);
		} catch (StorageException e) {
			modelMap.put("errorMessage", "Ups something went wrong...");
		}
		return new ServiceResult(view, modelMap);
	}
}
