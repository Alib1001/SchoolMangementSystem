package com.sis2225.SchoolManagementSystem;

import com.sis2225.SchoolManagementSystem.Models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@SpringBootApplication
public class SchoolManagementSystemApplication {

	public static void main(String[] args) {

		String school68Description = "Школа №68 с углубленным изучением немецкого языка в Казахстане – это учебное заведение, которое предоставляет уникальные образовательные возможности для учеников, желающих овладеть навыками немецкого языка на более глубоком уровне. Эта школа является одной из ведущих образовательных учреждений в стране и предоставляет высококачественное образование с акцентом на изучении немецкого языка и культуры.\n" +
				"\n" +
				"Школа №68 располагается в живописном месте, где современные учебные здания и удобные классы создают благоприятную образовательную среду. Ученики здесь имеют доступ к современным учебным материалам и технологиям, которые помогают им эффективно изучать немецкий язык и развивать свои интеллектуальные способности.";

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		School gim68School = new School(10,"КГУ Гимназия #68", school68Description,
				"немецкий язык", "Орбита 2","68_school.png");
		School rfmsh = new School(8, "Республиканский физико-математический лицей",
				"углубленное изучение физики и математики",
				"физика, математика", "бул. Бухар-Жирау 36","rfmsh.png");
		School ektl = new School(8, "Казахско-Турецский лицей",
				"школа в Есике",
				"физика, математика", "бул. Бухар-Жирау 36","ektl.png");


		SysUser manager = new Manager();

		SysUser student1 = new Student("Alibek", "Nurdaulet","Люблю игры",18,"11A",
				"baka","11111");

		SysUser teacher1 = new Teacher("Физрук","Спортивныч",46,
				"Физра", "Люблю спорт","fizra","1111");

		LearnSubject math = new LearnSubject();
		math.setName("Math");

		ArrayList<LearnSubject> subjects = new ArrayList();
		subjects.add(math);

		LearnClass A11 = new LearnClass();
		A11.setName("11A");
		A11.setSchool(gim68School);
		A11.setSubjects(subjects);

		Mark mark = new Mark();
		mark.setSubject(math);
		mark.setScore(1);

		mark.setStudent((Student) student1);

		gim68School.addUser(student1);
		gim68School.addUser(teacher1);
		gim68School.addUser(manager);

		session.persist(math);
		session.persist(A11);
		session.persist(mark);

		session.persist(manager);

		session.persist(student1);


		session.persist(teacher1);

		session.persist(gim68School);
		session.persist(rfmsh);
		session.persist(ektl);
		session.getTransaction().commit();
		session.close();




		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

}