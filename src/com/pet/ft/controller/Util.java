package com.pet.ft.controller;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

    public static void MakeFolder(String path, int member_no) {
        File folder = new File(path + member_no);

        if (!folder.exists()) {
            try {
                if (folder.mkdir()) {
                    System.out.println("폴더 생성");
                } else {
                    System.out.println("폴더 생성 실패");
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("이미 폴더가 생성되어 있습니다");
        }

    }

    public static void deleteFile(String path) {


        File file = new File(path);
        if (file.exists()) {
            System.out.println("파일 존재");
        } else if (file.isDirectory()){
            System.out.println("2");
        } else if (file.isFile()) {
            System.out.println("3");
        } else {
            System.out.println("접자");
        }
    }
}
