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
import java.util.Scanner;

@EnableTransactionManagement
@SpringBootApplication
public class SchoolManagementSystemApplication {

	static Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	static SessionFactory sessionFactory = configuration.buildSessionFactory();
	static Session  session = sessionFactory.openSession();
	private static boolean exit = false;
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {


		while (!exit) {
			printMenu();
			runCLI();
		}

		String school68Description = "Школа №68 с углубленным изучением немецкого языка в Казахстане – это учебное заведение, которое предоставляет уникальные образовательные возможности для учеников, желающих овладеть навыками немецкого языка на более глубоком уровне. Эта школа является одной из ведущих образовательных учреждений в стране и предоставляет высококачественное образование с акцентом на изучении немецкого языка и культуры.\n" +
				"\n" +
				"Школа №68 располагается в живописном месте, где современные учебные здания и удобные классы создают благоприятную образовательную среду. Ученики здесь имеют доступ к современным учебным материалам и технологиям, которые помогают им эффективно изучать немецкий язык и развивать свои интеллектуальные способности.";


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

		ektl.addUser(student1);
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


	private static void printMenu() {
		System.out.println("\nMenu:");
		System.out.println("1. Create School");
		System.out.println("2. Create Student");
		System.out.println("3. Create Teacher");
		System.out.println("4. Create Subject");
		System.out.println("5. Create Class");
		System.out.println("6. Create Mark");
		System.out.println("7. Display School Info");
		System.out.println("8. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void createSchool() {
		System.out.println("Creating School...");

		System.out.print("Enter school rating: ");
		int rating = getUserInputInt();

		System.out.print("Enter school name: ");
		String schoolName = scanner.nextLine();

		System.out.print("Enter school description: ");
		String schoolDescription = scanner.nextLine();

		System.out.print("Enter school focus ");
		String focus = scanner.nextLine();

		System.out.print("Enter school address: ");
		String schoolAddress = scanner.nextLine();

		System.out.print("Enter school image filename: ");
		String schoolImage = scanner.nextLine();

		School school = new School( rating,schoolName, schoolDescription, focus, schoolAddress, schoolImage);
		session.beginTransaction();
		session.persist(school);
		session.getTransaction().commit();
		System.out.println("School created: " + school);
	}


	private static int getUserInputInt() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			return getUserInputInt();
		}
	}

	private List<String> parseSubjects(String subjectsInput) {
		String[] subjectsArray = subjectsInput.split(",");
		List<String> subjectsList = new ArrayList<>();
		for (String subject : subjectsArray) {
			subjectsList.add(subject.trim());
		}
		return subjectsList;
	}

	private static void runCLI() {
		System.out.println("Welcome to the School Management System CLI!");

		while (!exit) {
			printMenu();
			int choice = getUserInputInt();

			switch (choice) {
				case 1:
					createSchool();
					break;
				case 2:
				//	createStudent();
					break;
				case 3:
				//	createTeacher();
					break;
				case 4:
				//	createSubject();
					break;
				case 5:
				//	createClass();
					break;
				case 6:
				//	createMark();
					break;
				case 7:
				//	displaySchoolInfo();
					break;
				case 8:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}

}