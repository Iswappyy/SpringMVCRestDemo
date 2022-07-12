package com.pro.wings.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import com.pro.wings.entity.Student;


@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addStudent(Student entity) {

		try {
			Session session = sessionfactory.openSession();
			Transaction txs = session.beginTransaction();
			session.save(entity);

			txs.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Object Not able to save database");
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Student> getList() {
		List<Student> studentList;
		String query = "from Student";
		try {
			Session session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();
			Query q = session.createQuery(query);
			List<Student> std1 = q.list();
			// List<Student> studentList = session.createQuery("from Student").list();
			for (Student student : std1) {
				System.out.println(student.getName() + " : " + student.getMarks());
			}
			tx.commit();
			System.out.println("we got the list of student...");
			session.close();
			return std1;

		} catch (Exception e) {
			System.out.println("oops List of student not found...");
			return null;
		}

	}

}
