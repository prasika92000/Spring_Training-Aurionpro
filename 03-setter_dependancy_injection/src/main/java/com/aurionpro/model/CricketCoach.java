package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Primary
@Scope("prototype")
public class CricketCoach implements ICoach {

	private IDiet diet;

	public CricketCoach(@Qualifier(value="weightLossDiet")IDiet diet) {
		  super();
		  this.diet = diet;
		 }

	 @Override
	 public String getTrainingPlan() {
	  return "Practise in cricket net for 2 hr";
	 }


	 public String getDietPlan() {
		//  System.out.println("Inside Cricket diet plan");
		//  System.out.println(diet.getPlan());
		  return diet.getPlan();
		 }
}
