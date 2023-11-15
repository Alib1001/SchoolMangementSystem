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
	static Session session = sessionFactory.openSession();
	private static boolean exit = false;
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (!exit) {
			printMenu();
			runCLI();
		}



		/**
		String school68Description = "Школа №68 с углубленным изучением немецкого языка в Казахстане – это учебное заведение, которое предоставляет уникальные образовательные возможности для учеников, желающих овладеть навыками немецкого языка на более глубоком уровне. Эта школа является одной из ведущих образовательных учреждений в стране и предоставляет высококачественное образование с акцентом на изучении немецкого языка и культуры.\n" +
				"\n" +
				"Школа №68 располагается в живописном месте, где современные учебные здания и удобные классы создают благоприятную образовательную среду. Ученики здесь имеют доступ к современным учебным материалам и технологиям, которые помогают им эффективно изучать немецкий язык и развивать свои интеллектуальные способности.";

		session.beginTransaction();
		School gim68School = new School(10, "КГУ Гимназия #68", school68Description,
				"немецкий язык", "Орбита 2", "68_school.png");
		School rfmsh = new School(8, "Республиканский физико-математический лицей",
				"углубленное изучение физики и математики",
				"физика, математика", "бул. Бухар-Жирау 36", "rfmsh.png");
		School ektl = new School(8, "Казахско-Турецкий лицей",
				"школа в Есике",
				"физика, математика", "бул. Бухар-Жирау 36", "ektl.png");

		SysUser manager = new Manager();

		SysUser student1 = new Student("Alibek", "Nurdaulet", "Люблю игры", 18,
				"baka", "11111");

		SysUser teacher1 = new Teacher("Физрук", "Спортивныч", 46,
				"Физра", "Люблю спорт", "fizra", "1111");

		LearnSubject math = new LearnSubject();
		math.setName("Математика");

		ArrayList<LearnSubject> subjects = new ArrayList();
		subjects.add(math);

		LearnClass A11 = new LearnClass();
		A11.setName("11A");
		A11.setSchool(gim68School);
		A11.setSubjects(subjects);

		Mark mark = new Mark();
		mark.setSubject(math);
		mark.setScore(5);

		mark.setStudent((Student) student1);

		student1.setSchool(gim68School);
		((Student) student1).setLearnClass(A11);
		teacher1.setSchool(ektl);

		session.persist(math);
		session.persist(A11);
		session.persist(mark);

		session.persist(manager);
		session.persist(student1);
		session.persist(teacher1);

		session.persist(gim68School);
		session.persist(rfmsh);
		session.persist(ektl);

		student1.setIdSchool(student1.getSchool().getId());
		teacher1.setIdSchool(teacher1.getSchool().getId());

		session.getTransaction().commit();
		session.close();

		 **/

		SpringApplication.run(SchoolManagementSystemApplication.class, args);
	}

	private static void printMenu() {
		System.out.println("\nМеню:");
		System.out.println("1. Создать школу");
		System.out.println("2. Создать ученика");
		System.out.println("3. Создать учителя");
		System.out.println("4. Создать предмет");
		System.out.println("5. Создать класс");
		System.out.println("6. Создать оценку");
		System.out.println("7. Выйти и Подтвердить");
		System.out.print("Введите ваш выбор: ");
	}

	public static void createSchool() {
		System.out.println("Создание школы...");

		System.out.print("Введите рейтинг школы: ");
		int rating = getUserInputInt();

		System.out.print("Введите название школы: ");
		String schoolName = scanner.nextLine();

		System.out.print("Введите описание школы: ");
		String schoolDescription = scanner.nextLine();

		System.out.print("Введите направление школы: ");
		String focus = scanner.nextLine();

		System.out.print("Введите адрес школы: ");
		String schoolAddress = scanner.nextLine();

		System.out.print("Введите имя файла изображения школы: ");
		String schoolImage = scanner.nextLine();

		School school = new School(rating, schoolName, schoolDescription, focus, schoolAddress, schoolImage);
		session.beginTransaction();
		session.persist(school);
		session.getTransaction().commit();
		System.out.println("Школа создана: " + school);
	}

	public static void createClass() {
		System.out.println("Создание класса...");

		System.out.print("Введите название класса: ");
		String className = scanner.nextLine();

		System.out.print("Введите ID школы для класса: ");
		int schoolId = getUserInputInt();
		School school = session.get(School.class, schoolId);

		LearnClass learnClass = new LearnClass();
		learnClass.setName(className);
		learnClass.setSchool(school);

		session.beginTransaction();
		session.persist(learnClass);
		session.getTransaction().commit();

		System.out.println("Класс создан: " + learnClass);
	}

	public static void createStudent() {
		System.out.println("Создание ученика...");

		System.out.print("Введите имя ученика: ");
		String firstName = scanner.nextLine();

		System.out.print("Введите фамилию ученика: ");
		String lastName = scanner.nextLine();

		System.out.print("Введите интересы ученика: ");
		String interests = scanner.nextLine();

		System.out.print("Введите возраст ученика: ");
		int age = getUserInputInt();

		System.out.print("Введите имя пользователя ученика: ");
		String username = scanner.nextLine();

		System.out.print("Введите пароль ученика: ");
		String password = scanner.nextLine();

		System.out.print("Введите ID школы для ученика: ");
		int schoolId = getUserInputInt();
		School school = session.get(School.class, schoolId);

		System.out.print("Введите класс ученика: ");
		int classId = getUserInputInt();
		LearnClass learnClass = session.get(LearnClass.class, classId);


		Student student = new Student(firstName, lastName, interests, age, username, password);
		student.setSchool(school);
		student.setLearnClass(learnClass);
		student.setIdSchool(schoolId);
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		System.out.println("Ученик создан и связан с школой: " + student);
	}

	public static void createMark() {
		System.out.println("Создание оценки...");

		System.out.print("Введите ID предмета для оценки: ");
		int subjectId = getUserInputInt();
		LearnSubject subject = session.get(LearnSubject.class, subjectId);

		System.out.print("Введите ID ученика для оценки: ");
		int studentId = getUserInputInt();
		Student student = session.get(Student.class, studentId);

		System.out.print("Введите балл за оценку: ");
		int score = getUserInputInt();

		Mark mark = new Mark();
		mark.setSubject(subject);
		mark.setScore(score);
		mark.setStudent(student);

		session.beginTransaction();
		session.persist(mark);
		session.getTransaction().commit();

		System.out.println("Оценка создана: " + mark);
	}

	public static void createTeacher() {
		System.out.println("Создание учителя...");

		System.out.print("Введите имя учителя: ");
		String firstName = scanner.nextLine();

		System.out.print("Введите фамилию учителя: ");
		String lastName = scanner.nextLine();

		System.out.print("Введите возраст учителя: ");
		int age = getUserInputInt();

		System.out.print("Введите предмет учителя: ");
		String subject = scanner.nextLine();

		System.out.print("Введите биографию учителя: ");
		String bio = scanner.nextLine();

		System.out.print("Введите имя пользователя учителя: ");
		String username = scanner.nextLine();

		System.out.print("Введите пароль учителя: ");
		String password = scanner.nextLine();

		System.out.print("Введите ID школы для учителя: ");
		int schoolId = getUserInputInt();
		School school = session.get(School.class, schoolId);

		Teacher teacher = new Teacher(firstName, lastName, age, subject, bio, username, password);
		teacher.setSchool(school);
		teacher.setIdSchool(schoolId);

		session.beginTransaction();
		session.persist(teacher);
		session.getTransaction().commit();
		System.out.println("Учитель создан и связан с школой: " + teacher);
	}

	public static void createSubject() {
		System.out.println("Создание предмета");

		System.out.print("Введите название предмета: ");
		String subjectName = scanner.nextLine();

		LearnSubject subject = new LearnSubject();
		subject.setName(subjectName);

		session.beginTransaction();
		session.persist(subject);
		session.getTransaction().commit();

		System.out.println("Предмет создан: " + subject);
	}

	public static int getUserInputInt() {
		try {
			return Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Неверный ввод. Введите число.");
			return getUserInputInt();
		}
	}

	public static void displayStudentInfo() {
		System.out.println("Введите ID ученика для отображения информации: ");
		int studentId = getUserInputInt();
		session.beginTransaction();

		Student student = session.get(Student.class, studentId);

		if (student != null) {
			System.out.println("Имя и фамилия ученика: " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Возраст: " + student.getAge());
			System.out.println("Класс: " + student.getLearnClass().getName());
			System.out.println("Оценки по предметам:");

			for (Mark mark : student.getMarks()) {
				System.out.println(mark.getSubject().getName() + ": " + mark.getScore());
			}
		} else {
			System.out.println("Ученик с указанным ID не найден.");
		}

		session.getTransaction().commit();
	}


	private static void runCLI() {
		System.out.println("Добро пожаловать в CLI для управления школой!");

		while (!exit) {
			printMenu();
			int choice = getUserInputInt();

			switch (choice) {
				case 1:
					createSchool();
					break;
				case 2:
					createStudent();
					break;
				case 3:
					createTeacher();
					break;
				case 4:
					createSubject();
					break;
				case 5:
					createClass();
					break;
				case 6:
					createMark();
					break;

				case 7:
					exit = true;
					break;

				case 8:
					displayStudentInfo();
					break;
				default:
					System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
			}
		}
	}
}
