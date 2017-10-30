package com.yeti.core.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.CampaignContact;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CampaignContact", path = "CampaignContacts")
public interface CampaignContactRepository extends JpaRepository<CampaignContact, Integer> {  //Entity, Id


}
