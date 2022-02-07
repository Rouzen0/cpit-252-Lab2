/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author 1936447
 */
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Logger {
  DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
  String currentDateTimeString = LocalDateTime.now().format(myFormatter);
  private final String logFile = currentDateTimeString + ".txt";
  private PrintWriter writer; 
  private static Logger log;

  private Logger() {
    try {
      FileWriter fw = new FileWriter(logFile);
      writer = new PrintWriter(fw, true);
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  public void info (String message) {
    writer.println("INFO: " + message);
  }
  public void error (String message) {
    writer.println("Error: " + message);
    
  }
  public static Logger getInstance(){
      if(log==null){
    return log=new Logger();
      }
      return log;
    }
}

