 package com.employee;

 import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {

    public static void main(String[] args) {
        // Check if file exists
        checkFileExists("example.txt");


        // Delete file and check if it does not exist
        deleteFile("example.txt");

        // Create directory
        createDirectory("example_directory");

        // Create empty file
        createEmptyFile("example_empty_file.txt");
        createEmptyFile("example_empty_file1.txt");
        checkFileExists("example_empty_file.txt");


        // List files in a directory
        listFiles("example_directory");

        // List files with a specific extension in a directory
        listFilesWithExtension("example_directory", ".txt");
    }

    public static void checkFileExists(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                System.out.println("File exists: " + filePath);
            } else {
                System.out.println("File does not exist: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                Files.delete(path);
                System.out.println("File deleted: " + filePath);
            } else {
                System.out.println("File does not exist: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createDirectory(String dirPath) {
        try {
            Path path = Paths.get(dirPath);
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("Directory created: " + dirPath);
            } else {
                System.out.println("Directory already exists: " + dirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createEmptyFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Empty file created: " + filePath);
            } else {
                System.out.println("File already exists: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listFiles(String dirPath) {
        try {
            Path path = Paths.get(dirPath);
            if (Files.exists(path) && Files.isDirectory(path)) {
                Files.list(path).forEach(System.out::println);
            } else {
                System.out.println("Directory does not exist: " + dirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listFilesWithExtension(String dirPath, String extension) {
        try {
            Path path = Paths.get(dirPath);
            if (Files.exists(path) && Files.isDirectory(path)) {
                Files.newDirectoryStream(path, entry -> entry.toString().endsWith(extension))
                        .forEach(System.out::println);
            } else {
                System.out.println("Directory does not exist: " + dirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

