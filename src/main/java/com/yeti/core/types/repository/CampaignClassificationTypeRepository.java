package com.yeti.core.types.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.CampaignClassificationType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CampaignClassificationType", path = "CampaignClassificationTypes")
public interface CampaignClassificationTypeRepository extends JpaRepository<CampaignClassificationType, Integer> {  //Entity, Id

}

