package edu.springz.aop;

import java.util.Arrays;

import org.apache.ibatis.logging.LogException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Component
@Log4j
public class LogAdvice {
	//AspectJ 표현식
	//execution( [접근제한자] 반환타입 [패키지.클래스.]이름([매개변수|...]) [throws 예외] )

	@Around("execution(* edu.springz.service.SampleService*.*(..))")
	public Object LogAround(ProceedingJoinPoint pjp) {
		log.info("pjp : " + pjp);
		Object result = null;
		
		log.info("TARGET : " + pjp.getTarget());
		log.info("PARAM : " + Arrays.toString(pjp.getArgs()));
		
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		log.info("result : " + result);
		return result;
		
	}
	
	@AfterThrowing(pointcut = "execution(* edu.springz.service.SampleService*.*(..))",
			throwing= "exception")
	public void LogException(Exception exception) {
		log.info("exception!!");
		log.info("exception : " + exception);
	}
	
	@Before("execution(* edu.springz.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1 :" + str1);
		log.info("str2 :" + str2);
	}
	
	@Before("execution(* edu.springz.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("logBefore()------------------");
	}


}
