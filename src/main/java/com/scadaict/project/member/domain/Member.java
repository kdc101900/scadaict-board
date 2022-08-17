package com.scadaict.project.member.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Member {

	private String userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userAuth;
	private Date createDt;
	private Date updateDt;
}
