package com.b0n3.avaj.simulator.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Logger {
    private  static OutputStream output;
    private static Logger logger;
    public Logger() throws IOException {
        var logFile = new File("simulation.txt");
        if (logFile.exists())
            logFile.delete();
            logFile.createNewFile();
            output = new FileOutputStream(logFile);
        }


    public static void log(String msg ) throws IOException {
        if (logger == null) {
            logger = new Logger();
        }

        output.write(msg.getBytes(StandardCharsets.UTF_8));
    }

    public static void close() throws IOException {
        output.flush();
        output.close();
    }
}
