package com.example.projectname.app;

import com.example.projectname.entity.Student;
import com.example.projectname.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AppInitializer {

    public static void main(String[] args) {
        // Example operations
        Student student1 = new Student("Anne", 2000);
        saveStudent(student1);

        getAllStudents();

        updateStudent("Raja", 6000, 1); // Assuming ID 1 exists
        deleteStudent(1); // Assuming ID 1 exists
        findStudent(1); // Assuming ID 1 exists
    }

    public static void saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    public static void getAllStudents() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            List<Student> students = query.list();
            System.out.println(students);
        }
    }

    public static void updateStudent(String name, double fee, long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.find(Student.class, id);
            if (student != null) {
                student.setStudName(name);
                student.setFee(fee);
                Transaction transaction = session.beginTransaction();
                session.update(student);
                transaction.commit();
            } else {
                System.out.println("Can't Find Records");
            }
        }
    }

    public static void deleteStudent(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.find(Student.class, id);
            if (student != null) {
                Transaction transaction = session.beginTransaction();
                session.delete(student);
                transaction.commit();
            } else {
                System.out.println("Can't Find Records");
            }
        }
    }

    public static void findStudent(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.find(Student.class, id);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Can't Find Records");
            }
        }
    }
}

