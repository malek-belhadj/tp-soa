package com.example.howtodoinjava.springbootsoapservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.example.howtodoinjava.xml.student.Student;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {
        add("Sajal", 5, "Pune");
        add("Kajal", 5, "Chicago");
        add("Lokesh", 6, "Delhi");
        add("Sukesh", 7, "Noida");
    }

    private void add(String name, int standard, String address) {
        Student s = new Student();
        s.setName(name);
        s.setStandard(standard);
        s.setAddress(address);
        students.put(name, s);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
}