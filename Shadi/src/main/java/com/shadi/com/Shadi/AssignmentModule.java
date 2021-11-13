package com.shadi.com.Shadi;

public class AssignmentModule{

	AssignmentPageObjModule assignmentPageObj = new AssignmentPageObjModule();

	public String verifyCommunityName(String username, String password, String createProfileFor, String gender) {
		assignmentPageObj.btnLetsBegin();
		assignmentPageObj.txtSignUpEmailId(username);
		assignmentPageObj.txtSignupPassword(password);
		assignmentPageObj.drpCreateProfileFor(createProfileFor);
		if(createProfileFor.equalsIgnoreCase("Self")) {
			if(gender.equalsIgnoreCase("Male")) {
				assignmentPageObj.rdbMale();
			}else if(gender.equalsIgnoreCase("Female")) {
				assignmentPageObj.rdbFemale();
			}
		}
		assignmentPageObj.btnNext();
		return assignmentPageObj.getComunity();
	}
}
