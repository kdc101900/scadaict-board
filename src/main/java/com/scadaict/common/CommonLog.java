package com.scadaict.common;

import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class CommonLog {
	
	@Around("within(com.scadaict..*)")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		
		String params = getRequestParams();
		
		long startAt = System.currentTimeMillis();
		
//		log.info(">> REQUEST : {}({}) = {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), params);
		System.out.printf(">> REQUEST : %s(%s) = %s\r\n", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), params);
		
		Object result = pjp.proceed();
		
		long endAt = System.currentTimeMillis();
		
//		log.info(">> RESPONSE : {}({}) = {} ({}ms)", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), result, endAt - startAt);
		System.out.printf(">> RESPONSE : %s(%s) = %s (%sms)\r\n", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), result, endAt - startAt);
		
		return result;
	}
	
	private String paramMapToString(Map<String, String[]> paramMap) {
//	    return paramMap.entrySet().stream()
//	        .<Object>map(entry -> String.format("%s -> (%s)",
//	            entry.getKey(), Joiner.on(",").join(entry.getValue())))
//	        .collect(Collectors.joining(", "));
		
		return paramMap.keySet().stream()
				.map(key -> key + "=" + paramMap.get(key))
				.collect(Collectors.joining(", ", "{", "}"));
	  }
	
	private String getRequestParams() {
		
		String params = "없음";
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		
		if(requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			
			Map<String, String[]> paramMap = request.getParameterMap();
			if(!paramMap.isEmpty()) {
				params = "[" + paramMapToString(paramMap) + "]";
			}
		}
		
		return params;
	}
}
