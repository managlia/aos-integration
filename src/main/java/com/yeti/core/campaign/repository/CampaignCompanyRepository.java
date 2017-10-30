package com.yeti.core.campaign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.CampaignCompany;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CampaignCompany", path = "CampaignCompanies")
public interface CampaignCompanyRepository extends JpaRepository<CampaignCompany, Integer> {  //Entity, Id


}
