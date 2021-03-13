package com.ziya.factory;

import com.ziya.dao.StudentDao;
import com.ziya.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentDao = null;
	static {
		studentDao = new StudentDaoImpl();
	}
	
	public static StudentDao getStudentDao() {
		return studentDao;
	}
}
