package epam.task.composite.reader;

import epam.task.composite.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReader {

    private static final Logger logger = LogManager.getLogger();

    public static String readText(String filepath) throws  CustomException {
        Path path = Paths.get(filepath);
        try {

            return Files.readString(path);

        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new CustomException("File not found " + filepath,e);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }
    }
}
