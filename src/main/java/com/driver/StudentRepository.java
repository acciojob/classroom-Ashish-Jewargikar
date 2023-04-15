package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class StudentRepository {

    private  Map<String, Student> students = new HashMap<>();
    private  Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, List<String>> studentTeacherPairs = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName) {
        List<String> teacherList = studentTeacherPairs.getOrDefault(studentName, new ArrayList<>());
        teacherList.add(teacherName);
        studentTeacherPairs.put(studentName, teacherList);
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        List<String> studentList = studentTeacherPairs.get(teacherName);
        return studentList != null ? studentList : Collections.emptyList();
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void deleteTeacherByName(String teacherName) {
        teachers.remove(teacherName);
        studentTeacherPairs.entrySet().removeIf(entry -> entry.getValue().contains(teacherName));
    }

    public void deleteAllTeachers() {
        teachers.clear();
        studentTeacherPairs.clear();
    }
}
