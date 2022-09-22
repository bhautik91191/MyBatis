package com.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.model.Student;

/**
 * Insert Student data in database
 * 
 *
 */
public class MyBatisInsert {

	public static void main(String[] args) throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		SqlSession session = sqlSessionFactory.openSession();

		// Create a new student object
		Student student = new Student("Bhautik", "It", 80, 984803322, "Bhautik12@gmail.com");

		// Insert student data
		session.insert("com.mybatis.model.Student.insert", student);
		System.out.println("record inserted successfully");

		session.commit();
		session.close();
	}

}
