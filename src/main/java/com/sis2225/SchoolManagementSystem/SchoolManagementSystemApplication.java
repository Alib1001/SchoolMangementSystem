	package com.sis2225.SchoolManagementSystem;

	import com.sis2225.SchoolManagementSystem.Models.School;
	import com.sis2225.SchoolManagementSystem.Models.Student;
	import com.sis2225.SchoolManagementSystem.Models.SysUser;
	import com.sis2225.SchoolManagementSystem.Models.Teacher;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.transaction.annotation.EnableTransactionManagement;

	import java.util.ArrayList;

	@EnableTransactionManagement
	@SpringBootApplication
	public class SchoolManagementSystemApplication {

		public static void main(String[] args) {

			ArrayList<String> teach1Classes = new ArrayList<>();
			teach1Classes.add("11A");
			teach1Classes.add("10B");
			teach1Classes.add("9Г");
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			School gim60School = new School(10,"КГУ Гимназия #60", "Школа на 2500 учеников",
					"Общий", "Орбита 34","1696054437177_mrhtRPVc.png");
			School school45 = new School(8, "Общеобразовательная школа #45",
					"Школа Орбиты 2",
					"Общее направление", "Орбита 2","1695809025521_LbGKYd64Ye8.jpg");
			School school40 = new School(9, "Общеобразовательная школа #40",
					"Школа c каз.языком обучения",
					"Общее направление", "Орбита 2","1696054501895_pp.jpg");
			School school5 = new School(3, "Общеобразовательная школа #5",
					"Общеобразовательная школа",
					"Общее направление", "КызылОрда","1696054093216_skipper.jpg");

			SysUser student1 = new Student("Alibek", "Nurdaulet",18,"11A");
			student1.setUsername("baka");
			student1.setPassword("11111");
			SysUser student2 = new Student("Baka", "Durachkov",17,"11A");
			SysUser student3 = new Student("Сырна", "Сырный",16,"10B");
			SysUser teacher1 = new Teacher("Физрук","Спортивныч",46,"Физра",teach1Classes,
					"Не строгий");
			teacher1.setUsername("fizra");
			teacher1.setPassword("11111");

			gim60School.addUser(student1);
			school5.addUser(student2);
			school45.addUser(student3);
			gim60School.addUser(teacher1);


			session.persist(student1);
			session.persist(student3);
			session.persist(student2);

			session.persist(teacher1);

			session.persist(gim60School);
			session.persist(school45);
			session.persist(school40);
			session.persist(school5);
			session.getTransaction().commit();
			session.close();

			SpringApplication.run(SchoolManagementSystemApplication.class, args);
		}

	}
