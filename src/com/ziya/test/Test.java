package com.ziya.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.ziya.dto.Student;
import com.ziya.factory.ConnectionFactory;
import com.ziya.factory.StudentServiceFactory;
import com.ziya.service.StudentService;

public class Test {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println();
			System.out.println("1.ADD STUDENT\n2.SEARCH STUDENT\n3.UPDATE STUDENT\n4.DELETE STUDENT\n5.EXIT");
			System.out.println("Enter your Choice");
			int choice = Integer.parseInt(br.readLine());
			String status = "";
			String sid = "";
			String sname = "";
			String saddr = "";
			Student student = null;
			StudentService studentService = null;
			switch(choice) {
			case 1:
				System.out.print("====ADD Student Module====");
				System.out.println("Student ID");
				sid = br.readLine();
				System.out.println("Student Name");
				sname = br.readLine();
				System.out.println("Student Address");
				saddr = br.readLine();
				
				student = new Student();
				student.setSid(sid);
				student.setSname(sname);
				student.setSaddr(saddr);
				
				studentService = StudentServiceFactory.getStudentService();
				status = studentService.addStudent(student);
				System.out.println(status);
				
				break;
				
			case 2:
				System.out.println("====SEARCH Student Module====");
				System.out.println("Enter Student ID");
				sid = br.readLine();
				studentService = StudentServiceFactory.getStudentService();
				student = studentService.searchStudent(sid);
				if(student == null) {
					System.out.println("Student does not exist");
				}else {
					System.out.println("Student Details\n=================");
					System.out.println("Student ID      : "+student.getSid());
					System.out.println("Student Name    : "+student.getSname());
					System.out.println("Student Address : "+student.getSaddr());					
				}
				break;
				
			case 3:
				System.out.println("====UPDATE Student Module====");
				System.out.println("Student ID");
				sid = br.readLine();
				studentService = StudentServiceFactory.getStudentService();
				student = studentService.searchStudent(sid);
				if(student == null) System.out.println("Student does'nt exist");
				else {
					System.out.println("Student Name[Old :"+student.getSname()+"] New : ");
					sname = br.readLine();
					if(sname==null || sname.equals("")) {
						sname = student.getSname();
					}
					System.out.println("Student Address[Old :"+student.getSaddr()+"] New : ");
					saddr = br.readLine();
					if(saddr == null || sname.equals("")) {
						saddr = student.getSaddr();
					}
					
					student = new Student();
					student.setSid(sid);
					student.setSname(sname);
					student.setSaddr(saddr);
					
					status = studentService.updateStudent(student);
					System.out.println(status);
				}
				
				break;
				
			case 4:
				System.out.println("====DELETE Student Module====");
				System.out.println("Student ID");
				sid = br.readLine();
				studentService = StudentServiceFactory.getStudentService();
				student = studentService.searchStudent(sid);
				if(student == null) {
					System.out.println("Student does not exists");
				}else {
					status = studentService.deleteStudent(sid);
					System.out.println(status);
				}
				break;
				
			case 5:
				System.out.println("Thanks");
				ConnectionFactory.cleanUp();
				System.exit(0);
				break;
			default: System.out.println("Please enter correct choice");
				break;
			}
		}
	}

}
