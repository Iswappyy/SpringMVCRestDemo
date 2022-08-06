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

	@Override
	public Student getStudentRollNum(int rollNum) {
		Student entity;
		String query = "from Student student where student.rollNum =:rollNum";
		try {
			Session session = sessionfactory.openSession();
			Transaction txc = session.beginTransaction();
			Query q1 = session.createQuery(query);
			q1.setParameter("rollNum", rollNum);
			entity = (Student)q1.uniqueResult();
			txc.commit();
            System.out.println("Student roll number  get succesfully...");
            System.out.println(entity);
            session.close();
			return entity;
		}
		catch(Exception e) {
			System.out.println("Oops ...object not get...");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateStudent(int rollNum, Student std) {
		String q = "update Student set name =:name where rollNum =: rollNum";
		try {
			Session session = sessionfactory.openSession();
			Transaction txc = session.beginTransaction();
			Query q1 = session.createQuery(q);
			q1.setParameter("rollNum", rollNum);
			q1.setParameter("name", std.getName());
			int r = q1.executeUpdate();
			System.out.println("Updated...");
			System.out.println(r);
			txc.commit();

			System.out.println("update operation get succesfully completed..");
			session.close();
			return true;
		}
		catch(Exception e) {
			System.out.println("oops data not get uppdated...");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int rollNum) {
		Student entity;
		String q = "delete from Student where rollNum =: rollNum";
		try {
			Session session = sessionfactory.openSession();
			Transaction txc = session.beginTransaction();
			Query q1 = session.createQuery(q);
			q1.setParameter("rollNum", rollNum);
			int r = q1.executeUpdate();
			System.out.println("deleted...: ");
			System.out.println(r);
			txc.commit();
			System.out.println("Object deleted succesfully...");
			session.close();
			return true;
		}
		catch(Exception e) {
			System.out.println("Oops object not get deleted...");
			e.printStackTrace();
			return false;
		}
	
	}

}
