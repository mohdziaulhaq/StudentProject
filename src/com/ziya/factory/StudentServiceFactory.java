package com.ziya.factory;

import com.ziya.service.StudentService;
import com.ziya.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService = null;
	
	static {
		studentService = new StudentServiceImpl();
	}
	
	public static StudentService getStudentService() {
		return studentService;
	}
}
