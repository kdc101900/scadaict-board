package com.scadaict.project.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.scadaict.project.member.domain.Member;

@Repository
public interface MemberRepository {

	// 유저 목록 가져오기
	List<Member> getMemberList();
	
	// 유저 정보 가져오기
	Member getMemberInfo(String userId);
}
