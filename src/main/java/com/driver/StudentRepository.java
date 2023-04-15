package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb= new HashMap<>();
    HashMap<String,Teacher> teacherDb=new HashMap<>();
    HashMap<String,List<String>>teacherStudentDb=new HashMap<>();

    public void addStudent(Student student){
        String key=student.getName();
        studentDb.put(key,student);
    }

    public void addTeacher(Teacher teacher){
        String key=teacher.getName();
        teacherDb.put(key,teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName){
        if(teacherStudentDb.containsKey(teacherName)) {

            List<String>students = teacherStudentDb.get(teacherName);
            students.add(studentName);
            teacherStudentDb.put(teacherName,students);
            return;
        }
        List<String> students =new ArrayList<>();
        students.add(studentName);
        teacherStudentDb.put(teacherName,students);
    }

    public Student getStudentByName(String name){
        if(studentDb.containsKey(name)) {
            Student student = studentDb.get(name);
            return student;
        }
        return null;
    }
    public Teacher getTeacherByName(String name){
        if(teacherDb.containsKey(name)) {
            Teacher teacher = teacherDb.get(name);
            return teacher;
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        if(teacherStudentDb.containsKey(teacherName)){
            return teacherStudentDb.get(teacherName);
        }
        return new ArrayList<>();
    }
    public List<String> getAllStudents(){
        List<String>studentsList=new ArrayList<>();
        for (String studentName: studentDb.keySet()){
            studentsList.add(studentName);
        }
        return studentsList;
    }
    public void deleteTeacherByName(String teacherName){
//        if (teacherDb.containsKey(teacherName)) {
//            teacherDb.remove(teacherName);
//        }
//        if (teacherStudentDb.containsKey(teacherName)) {
//            for (String student : teacherStudentDb.get(teacherName)) {
//                if(studentDb.containsKey(student)) {
//                    studentDb.remove(student);
//                }
//            }
//            teacherStudentDb.remove(teacherName);
//        }
//
        teacherDb.remove(teacherName);
        teacherStudentDb.remove(teacherName);
    }
    public void deleteAllTeachers(){
//        for(String teacherName:teacherDb.keySet()){
//            teacherDb.remove(teacherName);
//            if (teacherStudentDb.containsKey(teacherName)) {
//                for (String student : teacherStudentDb.get(teacherName)) {
//                    if(studentDb.containsKey(student)) {
//                        studentDb.remove(student);
//                    }
//                }
//                teacherStudentDb.remove(teacherName);
//            }
//        }
//        teacherStudentDb.clear();
        teacherDb.clear();
        teacherStudentDb.clear();
    }
}
