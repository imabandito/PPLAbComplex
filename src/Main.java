import Audio.Storage.Disk;
import Audio.UI.*;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        String path = "C:\\Users\\ilkop\\IdeaProjects\\PPLabComplex\\init.txt";
        try {
            Disk disk = new Disk(path,"Default");
            logger.info("Info log");
            logger.error("Error 1488");

            Menu menu = new Menu(
                    new PrintAudioCommand(disk),
                    new AddAudioCommand(disk),
                    new RemoveAudioCommand(disk),
                    new OrderByGenreCommand(disk),
                    new CalculateAudioDurationCommand(disk),
                    new RangeByDurationCommand(disk),
                    new HelpCommand(),
                    new ExitCommand());
            menu.run();
        } catch (IOException e) {
            System.out.println("IO Exception in file"+path);
            logger.error("IO Exception");
        } catch (NumberFormatException e){
            System.out.println(e.getCause()+" "+e.getMessage());
            logger.error("Number Exception");
        } catch (Exception e){
            System.out.println(e.getClass()+" (((fail(");
            logger.error("Exception");
        }
    }
}
