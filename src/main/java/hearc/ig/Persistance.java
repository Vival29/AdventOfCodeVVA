package hearc.ig;

import hearc.ig.day3.Day3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persistance {
    private static final Logger logger = LoggerFactory.getLogger(Persistance.class);
    public List<String> getInputByLine(String pathname) {
        List<String> sacs = new ArrayList<>();
        try {
            File input = new File(pathname);
            Scanner scanner = new Scanner(input);

            while (scanner.hasNextLine()) {
                String sac = scanner.nextLine();
                sacs.add(sac);
            }
            scanner.close();

        } catch (FileNotFoundException e) {

            logger.info("Le fichier n'a pas été trouvé.");
            e.printStackTrace();
        }
        return sacs;
    }
}
