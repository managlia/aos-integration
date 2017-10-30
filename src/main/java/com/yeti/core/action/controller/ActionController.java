package com.yeti.core.action.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.yeti.core.action.service.ActionService;
import com.yeti.model.action.Action;
import com.yeti.model.util.Batch;

@RestController
@ExposesResourceFor(Action.class)
@RequestMapping(value = "/Actions", produces = "application/hal+json")
public class ActionController {

	@Autowired
	private ActionService actionService;

	@GetMapping
	public ResponseEntity<List<Resource<Action>>> getAllActions() {
		List<Action> actions = actionService.getAllActions();
		if( actions != null ) {
			List<Resource<Action>> returnActions = new ArrayList<Resource<Action>>();
			for( Action action : actions ) {
				returnActions.add(getActionResource(action));
			}
			return ResponseEntity.ok(returnActions);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource<Action>> getAction(@PathVariable Integer id) {
		Action action = actionService.getAction(id);
		if( action == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(getActionResource(action));
		}
	}
	
	@PostMapping
	public ResponseEntity<Resource<Action>> addAction(@RequestBody Action action, HttpServletRequest request ) {
		Action newAction = actionService.addAction(action);
		if( newAction != null ) {
			String requestURI = request.getRequestURI();
			try {
				return ResponseEntity.created(new URI(requestURI + "/" + newAction.getActionId())).build();		
			} catch( Exception e ) {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Resource<Action>> updateAction(@RequestBody Action action, @PathVariable Integer id) {
		if( !actionService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			actionService.updateAction(id, action);
			Action updatedAction = actionService.updateAction(id, action);
			if( updatedAction != null ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Resource<Action>> deleteAction(@PathVariable Integer id) {
		if( !actionService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			actionService.deleteAction(id);
			if( !actionService.exists(id) ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@PatchMapping
	public void processBatch(@RequestBody Batch batch) {
		actionService.processBatch(batch);
	}

	private Resource<Action> getActionResource(Action a) {
	    Resource<Action> resource = new Resource<Action>(a);
	    resource.add(linkTo(methodOn(ActionController.class).getAction(a.getActionId())).withSelfRel());
	    return resource;
	}

}








