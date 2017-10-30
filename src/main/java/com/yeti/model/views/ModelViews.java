package com.yeti.model.views;

public class ModelViews {

	public interface ShallowCampaignView {}
	public interface DeeperCampaignView extends ShallowCampaignView{}
	public interface DeepestCampaignView extends DeeperCampaignView {}
	
}
