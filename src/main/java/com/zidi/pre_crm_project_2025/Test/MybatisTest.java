package com.zidi.pre_crm_project_2025.Test;

import com.zidi.pre_crm_project_2025.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public MybatisTest() throws IOException {
        // Load MyBatis configuration file
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // Try-with-resources to ensure session closure
            try (SqlSession session = sqlSessionFactory.openSession()) {
                // Fetch a student by ID
                Student s = session.selectOne("getStudentById", "S0011");
                if (s != null) {
                    System.out.println("Name: " + s.getName());
                    System.out.println("Age: " + s.getAge());
                } else {
                    System.out.println("Student with ID S0011 not found.");
                }

                // Fetch all students
                List<Student> studentList = session.selectList("getAllStudents");
                for (Student s1 : studentList) {
                    System.out.println(s1);
                }

                // Insert a new student
                Student insertStudent = new Student("S0012", "ZiDi", 22);
                int rowsInserted = session.insert("insertStudent", insertStudent);

                if (rowsInserted > 0) {
                    System.out.println("Inserted new student successfully!");
                }

                // Commit transaction
                session.commit();
            }
        }
    }
    public static void main(String[] args) {
        try {
            new MybatisTest(); // Execute test
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
