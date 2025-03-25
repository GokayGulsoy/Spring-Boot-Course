package com.week2lab.springframeworkexploration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Week2LabApplication {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) SpringApplication.run(Week2LabApplication.class, args);

		// reading all bean names from context
		// String[] beanNames = context.getBeanDefinitionNames();

		String[] beanNames = {"book", "class", "grade", "student"};

		// displaying all beans
		for (String beanName : beanNames) {
			System.out.println(context.getBean(beanName));
		}

		// accessing specific bean (Singleton pattern!)
		Student student = context.getBean(Student.class);
		// display fields of Student bean
		System.out.println("Student name: " + student.getName());
		System.out.println("Student class: " + student.getClassName());
		System.out.println("Student's book: " + student.getBookName());
		System.out.println("Student's letter grade: " + student.getGrade());

	}

}
