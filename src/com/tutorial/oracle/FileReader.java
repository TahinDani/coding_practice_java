package com.tutorial.oracle;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    private Path path;
    // An object to iterate over the entries in a directory.
    // A directory stream allows for the convenient use of the
    // for-each construct to iterate over a directory.
    private DirectoryStream<Path> stream;

    public void setPath(String path){
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void getFiles() throws IOException {
        stream = Files.newDirectoryStream(path);
    }

    public void listFiles() throws IOException {
        stream.forEach(e -> System.out.println(e.getFileName()));
        stream.close();

    }


    public static void main(String[] args) {
        FileReader fr1 = new FileReader();
        fr1.setPath("/home/tahin/Downloads/Tixati");
        try {
            fr1.getFiles();
            fr1.listFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("fr2:");

        FileReader fr2 = new FileReader();
        fr2.setPath("/home/tahin/Downloads/practice.txt");
        System.out.format("toString: %s%n", fr2.getPath().toString());
        System.out.format("getFileName: %s%n", fr2.getPath().getFileName());
        System.out.format("getName(0): %s%n", fr2.getPath().getName(0));
        System.out.format("getNameCount: %d%n", fr2.getPath().getNameCount());
        System.out.format("subpath(0,2): %s%n", fr2.getPath().subpath(0,2));
        System.out.format("getParent: %s%n", fr2.getPath().getParent());
        System.out.format("getRoot: %s%n", fr2.getPath().getRoot());

    }
}
