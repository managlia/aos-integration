package com.yeti.core.campaign.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeti.core.campaign.repository.CampaignRepository;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.util.Batch;

@Service
public class CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	public List<Campaign> getAllCampaigns() {
		List<Campaign> campaigns = new ArrayList<Campaign>();
		campaignRepository.findAll().forEach(campaigns::add);
		return campaigns;
	}
	
	public Campaign getCampaign(Integer id) {
		return campaignRepository.findOne(id);
	}
	
	public Campaign addCampaign(Campaign campaign) {
		return campaignRepository.save(campaign);
	}

	public Campaign updateCampaign(Integer id, Campaign campaign) {
		return campaignRepository.save(campaign);
	}

	public void deleteCampaign(Integer id) {
		campaignRepository.delete(id);
	}
	
	public void processBatchAction(Batch batch) {
		// TODO: Write logic for batch processing
	}
	
	public boolean exists(Integer id) {
		return campaignRepository.exists(id);
	}
	
}
