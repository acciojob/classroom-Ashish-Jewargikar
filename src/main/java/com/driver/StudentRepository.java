package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private Map<String, Student> students = new HashMap<>();
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, List<String>> teacherToStudents = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName) {
        List<String> students = teacherToStudents.getOrDefault(teacherName, List.of());
        students.add(studentName);
        teacherToStudents.put(teacherName, students);
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        return teacherToStudents.getOrDefault(teacherName, List.of());
    }

    public List<Student> getAllStudents() {
        return students.values().stream().collect(Collectors.toList());
    }

    public void deleteTeacherByName(String name) {
        teachers.remove(name);
        teacherToStudents.remove(name);
    }

    public void deleteAllTeachers() {
        teachers.clear();
        teacherToStudents.clear();
    }
}
