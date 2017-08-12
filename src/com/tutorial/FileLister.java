package com.tutorial;

import java.io.File;

public class FileLister {

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                System.out.println("----------" + fileEntry.getName() + "-------------");
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    public static void main(String[] args) {
        final File folder = new File("/home/tahin/Downloads/Tixati");
        listFilesForFolder(folder);
    }


}
