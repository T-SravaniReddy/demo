package com.zaggle1.demozaggle;

public class EmpSkills {
	private String Skill;
	private int experienceInYears;
	private String empId;
	public String getSkill() {
		return Skill;
	}
	public void setSkill(String skill) {
		Skill = skill;
	}
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "EmpSkills [Skill=" + Skill + ", experienceInYears=" + experienceInYears + ", empId=" + empId + "]";
	}
	
}
