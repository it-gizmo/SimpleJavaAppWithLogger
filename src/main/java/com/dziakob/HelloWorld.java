package com.dziakob;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.exit;

public class HelloWorld {

    private static final Logger logger = LogManager.getLogger(HelloWorld.class);

    public static void main(String[] args) {

        Properties props = new Properties();
        InputStream is = HelloWorld.class.getResourceAsStream("/log4j2.properties");
        try{
            props.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long counter = 0;
        while (true) {
            System.out.println("Hello World");
            logger.log(Level.DEBUG, "jak leci po raz: " + counter);
            logger.log(Level.ERROR, "jak leci po errorze raz: " + counter);
            logger.log(Level.INFO, "jak leci po info raz: " + counter);
            logger.log(Level.TRACE, "jak leci po trace raz: " + counter);
            counter++;
            try {
                Thread.sleep(10000l);
            } catch (InterruptedException e) {
                logger.error(e.getMessage(), e);
            }
            if (counter == 100)
                exit(-1);
        }
    }
}
