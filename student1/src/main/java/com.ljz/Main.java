package com.ljz;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ljz.RandomUtil.*;


/**
 * @ClassName : Main
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/11  18:11
 */

public class Main {
    // 学生的数量
    private static final Integer STUDENT_NUM = 100;

    public static void main(String[] args) {
        Random random = new Random();
        List<Student> list = new ArrayList<>(STUDENT_NUM);
        int count = 0;
        int num = 0;
        int num1 = 0;
        for (int i = 0; i < STUDENT_NUM; i++) {
            Student student = new Student();
            student.setName(createString(5));
            String sex = createSex();
            if ("male".equals(sex) && (count <= STUDENT_NUM / 2)) {
                count++;
                student.setSex(sex);
            } else {
                student.setSex(sex);
            }
            int sno = createNum();
            if (sno >= 0 && sno < 20 && ((double)num / (double)STUDENT_NUM) <= 0.2) {
                num++;
                student.setAge((int)(Math.random() * 2 + 18));
            } else if (sno >= 30 && sno < 80 && ((double)num1 / (double)STUDENT_NUM) <= 0.5) {
                num1++;
                student.setAge((int)(Math.random() * 5 + 20));
            } else {
                if(random.nextInt(2) == 0){
                    student.setAge((int)(Math.random() * 18));
                }else{
                    student.setAge((int)(Math.random() * 25 + 25));
                }
            }
            list.add(student);
        }
        long l = System.currentTimeMillis();
        list.forEach(System.out::println);
        long l1 = System.currentTimeMillis();
        System.out.println("打印学生集合耗时: " + (l1 - l));
        System.out.println("====");
        getTotal(list);
        simpleWrite(list);
    }

    private static void getTotal(List<Student> list) {
        int male = 0;
        int age1 = 0;
        int age2 = 0;
        for (Student student : list) {
            System.out.println(student);
            if ("male".equals(student.getSex())) {
                male++;
            }
            if (student.getAge() >= 18 && student.getAge() < 20) {
                age1++;
            }
            if (student.getAge() >= 20 && student.getAge() < 25) {
                age2++;
            }
        }
        System.out.println(male + "," + age1 + "," + age2);
        System.out.println("男生的百分比：" + ((double) male / (double) STUDENT_NUM) * 100 + "%");
        System.out.println("女生的百分比：" + ((double) (STUDENT_NUM - male) / (double) STUDENT_NUM) * 100 + "%");
        System.out.println("18到20岁的百分比：" + ((double) age1 / (double) STUDENT_NUM) * 100 + "%");
        System.out.println("20到25岁的百分比：" + ((double) age2 / (double) STUDENT_NUM) * 100 + "%");
        System.out.println("其余岁的百分比：" + ((double) (STUDENT_NUM - age1 - age2) / (double) STUDENT_NUM) * 100 + "%");

    }

    private static void simpleWrite(List<Student> list) {
        long l = System.currentTimeMillis();
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, Student.class).sheet("模板").doWrite(list);
        long l1 = System.currentTimeMillis();
        System.out.println("将学生集合写到execl中耗时: " + (l1 - l));
    }
}
