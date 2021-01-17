import Audio.AudioFile;
import Audio.Client;
import Audio.Commands.Command;
import Audio.Storage.Disk;
import Audio.UI.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\ilkop\\IdeaProjects\\PPLabComplex\\init.txt";
        try {
            Disk disk = new Disk(path);

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
            System.out.println("IO Exception at file"+path);
        } catch (NumberFormatException e){
            System.out.println(e.getCause()+" "+e.getMessage());
        } catch (Exception e){
            System.out.println(e.getClass()+" (((fail(");
        }
    }
}
