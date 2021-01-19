package Tests;

import Audio.Storage.AudioCollection;
import Audio.Storage.AudioFile;
import Audio.Storage.Disk;
import Audio.UI.AddAudioCommand;
import Audio.UI.Menu;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.ArrayList;

public class TestFunctional {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testReadFromFile() throws IOException {
        exception.expect(IOException.class);
        AudioCollection collection = new AudioCollection("");
        collection = new AudioCollection("inittest.txt");
    }

    @Test
    public void testCorrectReadFromFile() throws IOException {
        AudioCollection collection = new AudioCollection("inittest2.txt");
        AudioCollection collection2 = new AudioCollection();
        collection2.addAudio(new AudioFile("MC poh", "Baranduchka", "repchina", 11));
        Assert.assertEquals(collection,collection2);
    }

    @Test
    public void testAudioDuration() throws IOException {
        AudioCollection collection = new AudioCollection("init.txt");
        int calcutated = collection.calcutateDurarion();
        Assert.assertEquals(calcutated,326);
    }

}