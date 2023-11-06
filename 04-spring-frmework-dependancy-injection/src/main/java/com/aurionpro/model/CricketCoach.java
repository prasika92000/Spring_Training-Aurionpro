package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CricketCoach implements ICoach{

	@Autowired
	@Qualifier(value="weightLossDiet") 
	private IDiet diet;

	public CricketCoach() {
		super();
		this.diet = diet;
	}
	
	
	
	@Override
	public String getTrainingPlan() {
		return "Practice in net for 1.4 hours";
	}

	@Override
	public String getDietPlain() {
		System.out.println("Inside Cricket diet plan");
		System.out.println(diet.getPlan());
		return diet.getPlan();
	}

}
