package Audio;

import java.util.Comparator;

public class GenreComparator implements Comparator<AudioFile> {

    @Override
    public int compare(AudioFile audioFile1, AudioFile audioFile2) {
        return audioFile1.getGenre().compareTo(audioFile2.getGenre());
    }
}
