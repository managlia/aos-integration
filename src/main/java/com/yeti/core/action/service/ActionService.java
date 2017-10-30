package com.yeti.core.action.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.core.action.repository.ActionRepository;
import com.yeti.model.action.Action;
import com.yeti.model.util.Batch;

@Service
public class ActionService {
	
	@Autowired
	private ActionRepository actionRepository;
	
	public List<Action> getAllActions() {
		List<Action> actions = new ArrayList<Action>();
		actionRepository.findAll().forEach(actions::add);
		return actions;
	}
	
	public List<Action> getAllActionsByDescription(String actionDescription) {
		List<Action> actions = new ArrayList<Action>();
		actionRepository.findByActionDescriptionIgnoreCaseContaining(actionDescription).forEach(actions::add);
		return actions;
	}

	public List<Action> getAllActionsByName(String actionName) {
		List<Action> actions = new ArrayList<Action>();
		actionRepository.findByActionNameIgnoreCaseContaining(actionName).forEach(actions::add);
		return actions;
	}
	
	public List<Action> findUsingActiveFlag(Boolean activeFlag) {
		List<Action> actions = new ArrayList<Action>();
		actionRepository.findUsingActiveFlag(activeFlag).forEach(actions::add);
		return actions;
	}
	
	public Action getAction(Integer id) {
		return actionRepository.findOne(id);
	}
	
	public Action addAction(Action action) {
		return actionRepository.save(action);
	}

	public Action updateAction(Integer id, Action action) {
		return actionRepository.save(action);
	}

	public void deleteAction(Integer id) {
		actionRepository.delete(id);
	}
	
	public void processBatch(Batch batch) {
		// TODO: Write logic for batch processing
	}
	
	public boolean exists(Integer id) {
		return actionRepository.exists(id);
	}
	
}
