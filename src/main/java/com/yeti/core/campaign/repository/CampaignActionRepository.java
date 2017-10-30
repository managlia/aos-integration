package com.yeti.core.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.CampaignAction;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CampaignAction", path = "CampaignActions")
public interface CampaignActionRepository extends JpaRepository<CampaignAction, Integer> {  //Entity, Id


}
