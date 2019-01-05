package com.testapi.until;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {
	  

		@Override
		public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
				Method testMethod) {
			IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();//获取到retryAnalyzer的注解
			if (retryAnalyzer == null){ annotation.setRetryAnalyzer(TestNGRetry.class);
			} 
			}
			
		 }

