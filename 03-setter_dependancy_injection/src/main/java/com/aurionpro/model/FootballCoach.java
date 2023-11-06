package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Primary
public class FootballCoach implements ICoach {
	private IDiet diet;

	 public FootballCoach(@Qualifier(value="atheletDiet")IDiet diet) {
	  super();
	  this.diet = diet;
	 }
	
	 @Override
	 public String getTrainingPlan() {
	  return "Practise football in ground for 2 hr";
	 }


	 @Override
	 public String getDietPlan() {
	//  System.out.println("Inside football diet plan");
	//  System.out.println(diet.getPlan());
	  return diet.getPlan();
	 }


}
