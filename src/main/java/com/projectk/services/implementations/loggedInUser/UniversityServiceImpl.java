package com.projectk.services.implementations.loggedInUser;

import com.projectk.entities.University;
import com.projectk.entities.searchEntities.SearchUniversity;
import com.projectk.entities.ServiceResult;
import com.projectk.services.interfaces.loggedInUserServices.UniversityService;
import com.projectk.storage.connectionManager.customExceptions.StorageException;
import com.projectk.storage.storageManager.interfaces.StorageManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UniversityServiceImpl implements UniversityService {
	private StorageManager<University, SearchUniversity> universityManager;

	@Autowired
	public UniversityServiceImpl(StorageManager<University, SearchUniversity> universityManager) {
		this.universityManager = universityManager;
	}

	@Override
	public ServiceResult addUniversity(University university) {
		String view = "";
		Map<String, Object> modelMap = new HashMap<>();
		try {
			universityManager.add(university);
			view = "UserPage";
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

	@Override
	public ServiceResult filterUniversities(SearchUniversity searchUniversity) {
		String view = "HomePage";
		Map<String, Object> modelMap = new HashMap<>();
		try {
			List<University> resultList = universityManager.filter(searchUniversity);
			if (resultList.isEmpty()) {
				modelMap.put("errorMessage", "No results found!");
			} else {
				modelMap.put("allUniversities", resultList);
				view = searchUniversity.getUniversityId() == null ? "universities" : "universityPage";
			}

		} catch (StorageException e) {
			modelMap.put("errorMessage", "Ups something went wrong...");
		}
		return new ServiceResult(view, modelMap);
	}
}
