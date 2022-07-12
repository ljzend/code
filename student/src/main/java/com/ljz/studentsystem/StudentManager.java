package com.ljz.studentsystem;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 学生管理系统
 *
 * @author think
 */
public class StudentManager {

    private static int SNO = 1001;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // 数组是Java中最基本的数据容器
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    /**
     * 展示菜单
     */
    public void showMenu() {
        System.out.println("==========学生管理系统==========");
        System.out.println("1、显示学员列表信息");
        System.out.println("2、录入录入学员信息");
        System.out.println("3、修改学员信息");
        System.out.println("4、删除学员信息");
        System.out.println("5、将学生信息导出到execl");
//        System.out.println("6、从execl中导入学生信息");
        System.out.println("0、退出系统");
    }

    /**
     * 添加学生信息
     */
    private void addStuInfo() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        student.setId(SNO++);
        System.out.println("你即将录入学员信息: ");
        System.out.println("--请输入要录入学生的信息: ");
        System.out.println("--学生姓名: ");
        String name = sc.nextLine();
        student.setName(name);
        System.out.println("--学生年龄: ");
        int age = sc.nextInt();
        while (age < 0 || age > 50) {
            System.out.println("--年龄必须在0到50岁，请重新输入年龄: ");
            age = sc.nextInt();
        }
        student.setAge(age);
        System.out.println("--学生性别: ");
        String a = sc.nextLine();
        String sex = sc.nextLine();
        while (!("男".equals(sex)) && !("女".equals(sex))) {
            System.out.println("--性别必须为男或女，请重新输入性别: ");
            sex = sc.nextLine();
        }
        student.setSex(sex);
        students.add(student);
        System.out.println("--成功录入一个学生!!!");
    }

    /**
     * 更新学生信息
     */
    private void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--请输入你要修改信息学生的个数: ");
        int num = sc.nextInt();
        while (num > students.size()){
            System.out.println("--参数不合法,请重新输入你要修改信息学生的个数: ");
            num = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            System.out.println("--请输入你要修改信息的学生id: ");
            int id = sc.nextInt();
            students.forEach(item -> {
                if (item.getId() == id) {
                    System.out.println("请输入你要修改的信息: ");
                    extracted(sc, item);
                    System.out.println("--修改了" + id + "学生的信息");
                } else {
                    System.out.println("--要修改信息的学生 " + id + " 不存在...");
                }
            });
        }
    }

    /**
     * 修改学生的信息
     * @param sc
     * @param item
     */
    private void extracted(Scanner sc, Student item) {
        boolean flag = true;
        while (flag){
            showMenuUpdate();
            System.out.println("--请输入你要修改的操作: ");
            int nextInt = sc.nextInt();
            switch (nextInt){
                case 1:
                    System.out.println("--请输入你要修改的名字");
                    String a = sc.nextLine();
                    String name = sc.nextLine();
                    item.setName(name);
                    break;
                case 2:
                    System.out.println("--请输入你要修改的年龄");
                    int age = sc.nextInt();
                    item.setAge(age);
                    break;
                case 0:
                    System.out.println("--退出修改");
                    flag = false;
                    break;
                default:
                    System.out.println("--输入的参数不合法，请输入0 - 2的数字！！！");
                    break;
            }
        }
    }

    /**
     * 展示修改的学生菜单
     */
    private void showMenuUpdate() {
        System.out.println("1、修改学生的名字: ");
        System.out.println("2、修改学生的年龄: ");
        System.out.println("0、结束修改: ");
    }

    /**
     * 删除学生信息
     */
    private void del() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--请输入你要删除学生的个数: ");
        int num = sc.nextInt();
        while (num > students.size()){
            System.out.println("--参数不合法,请重新输入你要删除学生的个数: ");
            num = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            System.out.println("--请输入你要删除的学生id: ");
            int id = sc.nextInt();
            Iterator<Student> iterator = students.iterator();
            while(iterator.hasNext()) {
                Student next = iterator.next();
                if (next.getId() == id) {
                    iterator.remove();
                    System.out.println("--删除了" + id + "学生");
                } else {
                    System.out.println("--删除的学生 " + id + " 不存在...");
                }
            }
        }
    }

    /**
     * 主方法
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.println("请输入你将要进行的操作: ");
            int num = sc.nextInt();
            switch (num) {
                case 0:
                    System.out.println("你已经退出系统!!!");
                    return;
                case 1:
                    showData();
                    break;
                case 2:
                    System.out.println("请输入你要录入学生的个数: ");
                    int snum = sc.nextInt();
                    for (int i = 0; i < snum; i++) {
                        addStuInfo();
                    }
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    del();
                    break;
                case 5:
                    export();
                    break;
//                case 6:
//                    System.out.println("请输入导入的文件名: ");
//                    String a = sc.nextLine();
//                    String filename = sc.nextLine();
//                    simpleRead(filename);
//                    break;
                default:
                    System.out.println("输入不合法请输入(0到1的数字)");
                    break;
            }
        }
    }

    /**
     * 展示学生信息
     */
    private void showData() {
        if (students.isEmpty()) {
            System.out.println("--学生列表为空不能不能展示！！！");
        } else {
            students.forEach(System.out::println);
        }
    }

    /**
     * 导出到 execl 表格
     */
    private void export(){
        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Student.class).sheet("模板").doWrite(students);
    }


    public void simpleRead(String fileName) {
        EasyExcel.read(fileName, Student.class, new StudentDataListener()).sheet().doRead();
    }

}
