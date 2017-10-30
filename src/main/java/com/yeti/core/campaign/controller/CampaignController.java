package com.yeti.core.campaign.controller;

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

import com.yeti.core.campaign.service.CampaignService;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.util.Batch;

@RestController
@ExposesResourceFor(Campaign.class)
@RequestMapping(value = "/Campaigns", produces = "application/hal+json")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@GetMapping
	public ResponseEntity<List<Resource<Campaign>>> getAllCampaigns() {
		List<Campaign> campaigns = campaignService.getAllCampaigns();
		if( campaigns != null ) {
			List<Resource<Campaign>> returnCampaigns = new ArrayList<Resource<Campaign>>();
			for( Campaign campaign : campaigns ) {
				returnCampaigns.add(getCampaignResource(campaign));
			}
			return ResponseEntity.ok(returnCampaigns);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource<Campaign>> getCampaign(@PathVariable Integer id) {
		Campaign campaign = campaignService.getCampaign(id);
		if( campaign == null ) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(getCampaignResource(campaign));
		}
	}
	
	@PostMapping
	public ResponseEntity<Resource<Campaign>> addCampaign(@RequestBody Campaign campaign, HttpServletRequest request ) {
		Campaign newCampaign = campaignService.addCampaign(campaign);
		if( newCampaign != null ) {
			String requestURI = request.getRequestURI();
			try {
				return ResponseEntity.created(new URI(requestURI + "/" + newCampaign.getCampaignId())).build();		
			} catch( Exception e ) {
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Resource<Campaign>> updateCampaign(@RequestBody Campaign campaign, @PathVariable Integer id) {
		if( !campaignService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			campaignService.updateCampaign(id, campaign);
			Campaign updatedCampaign = campaignService.updateCampaign(id, campaign);
			if( updatedCampaign != null ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Resource<Campaign>> deleteCampaign(@PathVariable Integer id) {
		if( !campaignService.exists(id) ) {
			return ResponseEntity.notFound().build();
		} else {
			campaignService.deleteCampaign(id);
			if( !campaignService.exists(id) ) {
				return ResponseEntity.accepted().build();		
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
	}
	
	@PatchMapping
	public void processBatchAction(@RequestBody Batch batch) {
		campaignService.processBatchAction(batch);
	}
	
	private Resource<Campaign> getCampaignResource(Campaign a) {
	    Resource<Campaign> resource = new Resource<Campaign>(a);
	    resource.add(linkTo(methodOn(CampaignController.class).getCampaign(a.getCampaignId())).withSelfRel());
	    return resource;
	}

}