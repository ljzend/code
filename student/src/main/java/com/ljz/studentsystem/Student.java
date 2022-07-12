package com.ljz.studentsystem;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Objects;

/**
 * 封装学员信息
 */
public class Student {
    @ExcelProperty("学生学号")
    private int id;
    @ExcelProperty("学生姓名")
    private String name;
    @ExcelProperty("学生年龄")
    private int age;
    @ExcelProperty("学生性别")
    private String sex;

    public Student() {
    }

    public Student(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && Objects.equals(name, student.name) && Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sex);
    }
}
