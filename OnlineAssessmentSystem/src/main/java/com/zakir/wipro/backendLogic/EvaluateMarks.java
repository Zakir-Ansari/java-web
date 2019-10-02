package com.zakir.wipro.backendLogic;

import com.zakir.wipro.bean.SelectedOptions;
import com.zakir.wipro.pojo.HibernateAssessment;
import com.zakir.wipro.pojo.SpringAssessment;

public class EvaluateMarks {
	public String getEvaluations(SelectedOptions selectedOption, String forUser, String assignmentName) {
		System.out.println("User name got: "+forUser);
		HibernateAssessment HA = new HibernateAssessment();
		SpringAssessment SA = new SpringAssessment();
		String result = "failed";
		int obtainedMarks =0;
		System.out.println("initial Marks: "+obtainedMarks);
		
		if(assignmentName.equalsIgnoreCase("Hibernate")) {
			if(selectedOption.getForQuestion1().equalsIgnoreCase(HA.getQue1Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion2().equalsIgnoreCase(HA.getQue2Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion3().equalsIgnoreCase(HA.getQue3Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion4().equalsIgnoreCase(HA.getQue4Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion5().equalsIgnoreCase(HA.getQue5Ans())) obtainedMarks = obtainedMarks + 10;
		}
		if(assignmentName.equalsIgnoreCase("Spring")) {
			if(selectedOption.getForQuestion1().equalsIgnoreCase(SA.getQue1Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion2().equalsIgnoreCase(SA.getQue2Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion3().equalsIgnoreCase(SA.getQue3Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion4().equalsIgnoreCase(SA.getQue4Ans())) obtainedMarks = obtainedMarks + 10;
			if(selectedOption.getForQuestion5().equalsIgnoreCase(SA.getQue5Ans())) obtainedMarks = obtainedMarks + 10;
		}
		System.out.println("Final marks: "+obtainedMarks);
		
		return "";
	}

}
