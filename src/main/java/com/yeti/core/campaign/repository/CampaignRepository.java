package com.yeti.core.campaign.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.Campaign;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Campaign", path = "Campaigns")
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {  //Entity, Id

}
