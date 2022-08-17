package com.scadaict.project.member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scadaict.project.member.domain.Member;
import com.scadaict.project.member.repository.MemberRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

	private final MemberRepository repository;
	
	public List<Member> getMemberList() {
		return repository.getMemberList();
	}
	
	public Member getMemberInfo(String userId) {
		return repository.getMemberInfo(userId);
	}
}
