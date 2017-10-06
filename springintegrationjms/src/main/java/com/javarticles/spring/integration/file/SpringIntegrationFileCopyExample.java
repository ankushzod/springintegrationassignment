package com.javarticles.spring.integration.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIntegrationFileCopyExample {

    public static void main(String[] args) throws InterruptedException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "fileCopyApplicationContext.xml");
        try {            
            Thread.sleep(2000);
            Properties prop = new Properties();
            FileInputStream is = new FileInputStream(new File(System.getProperty("user.dir") + "/output/fileToCopy.properties"));
            prop.load(is);
            System.out.println(prop);
        } finally {
            context.close();
        }
    }
    
}
