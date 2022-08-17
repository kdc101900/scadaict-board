package com.scadaict.project.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scadaict.common.Result;
import com.scadaict.project.member.service.MemberService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/member")
@AllArgsConstructor
public class MemberController {
	
	private final MemberService memberService;

	@GetMapping()
	public Result<?> getMemberList() {
		try {
			return Result.ok(memberService.getMemberList());
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}

	@GetMapping("/{userId}")
	public Result<?> getMemberInfo(@PathVariable String userId) {
		try {
			return Result.ok(memberService.getMemberInfo(userId));
		} catch (Exception e) {
			return Result.error(e.getMessage());
		}
	}
}
