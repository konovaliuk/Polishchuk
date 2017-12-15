package ua.com.delivery.testpackage.logging;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test implements Reader{
    private final static Logger LOGGER = Logger.getLogger(Test.class);
    @Override
    public String read() {
        String message = "";
        try {
            URI url = ClassLoader.getSystemResource("message.txt").toURI();
            LOGGER.info("File URL ---= have been gotten");

            byte[] fileBytes = Files.readAllBytes(Paths.get(url));
            LOGGER.info("Byte array from file have been gotten");

            message = new String(fileBytes);
            LOGGER.info("Message from file have been gotten");
        } catch (URISyntaxException| NullPointerException |IOException e){
            LOGGER.error(e);
        }
        return message;
    }
}
