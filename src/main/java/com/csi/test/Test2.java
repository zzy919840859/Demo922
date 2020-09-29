package com.csi.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.domain.Student;

public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student(1,"dawa");
        Student s2 = new Student(2,"erwa");
        s1.setStudent(s2);
        s2.setStudent(s1);
//        JSON.DEFAULT_GENERATE_FEATURE|=SerializerFeature.DisableCircularReferenceDetect.getMask();
        String s3 = JSON.toJSONString(s1, SerializerFeature.PrettyFormat);
        System.out.println(s3);
        String s4 = JSON.toJSONString(s2, SerializerFeature.PrettyFormat);
        System.out.println(s4);
    }
}
