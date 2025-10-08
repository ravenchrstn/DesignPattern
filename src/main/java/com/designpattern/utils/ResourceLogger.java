package com.designpattern.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ResourceLogger {

    private BufferedWriter writer;

    public ResourceLogger(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void log(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}