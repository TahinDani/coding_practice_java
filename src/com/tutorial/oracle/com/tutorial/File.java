package com.tutorial.oracle.com.tutorial;/*
Created by tahin on 2017.08.10..
*/

public class File {

    private String fileName;

    public File(String name) {
        this.fileName = name;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
