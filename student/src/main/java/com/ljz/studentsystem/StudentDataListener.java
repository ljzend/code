package com.ljz.studentsystem;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;

import java.util.List;

/**
 * @ClassName : DemoDataListener
 * @Description :
 * @Author : ljz
 * @Date: 2022/7/12  19:11
 */

public class StudentDataListener implements ReadListener<Student> {

    private static final int BATCH_COUNT = 100;
    private List<Student> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    @Override
    public void invoke(Student data, AnalysisContext context) {
        cachedDataList.add(data);
        StudentManager studentManager = new StudentManager();
        List<Student> students = studentManager.getStudents();
        students.addAll(cachedDataList);
        if (cachedDataList.size() >= BATCH_COUNT) {
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        StudentManager studentManager = new StudentManager();
        List<Student> students = studentManager.getStudents();
        students.addAll(cachedDataList);
    }
}
