package com.ljz;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Objects;

/**
 * @ClassName : Student
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/11  18:08
 */

public class Student {
    @ExcelProperty("学生姓名")
    private String name;
    @ExcelProperty("学生性别")
    private String sex;
    @ExcelProperty("学生年龄")
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(sex, student.sex) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
}
