package com.project.dto;

public class MemberDTO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_birth;
	private String member_gender;
	private String member_add;
	private int member_phone;
	
	
	public MemberDTO() {};
	
	
	public MemberDTO(String member_id, String member_pw, String member_name, String member_birth, String member_gender,
			String member_add, int member_phone) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_birth = member_birth;
		this.member_gender = member_gender;
		this.member_add = member_add;
		this.member_phone = member_phone;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_add() {
		return member_add;
	}
	public void setMember_add(String member_add) {
		this.member_add = member_add;
	}
	public int getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(int member_phone) {
		this.member_phone = member_phone;
	}
	

	
}
