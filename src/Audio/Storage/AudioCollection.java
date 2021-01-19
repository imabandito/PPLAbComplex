package Audio.Storage;

import Audio.Compare.GenreComparator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AudioCollection {
    private List<AudioFile> audioFiles;

    public AudioCollection(){ audioFiles = new ArrayList<>(); }
    public AudioCollection(List<AudioFile> collection) {
        this.audioFiles = collection;
    }
    public AudioCollection(String path) throws IOException {this.audioFiles = readAudiosFromFile(path);}

    public void addAudio(AudioFile audioFile){ audioFiles.add(audioFile); }
    public void addAudios(List<AudioFile> collection) throws Exception {audioFiles.addAll(collection);}
    public void addAudios(String path) throws IOException {audioFiles.addAll(readAudiosFromFile(path));}

    public void deleteAudio(int index){audioFiles.remove(index);}
    public void deleteAllAudios(){audioFiles.clear();}
    public List<AudioFile> getAudioFiles(){ return audioFiles; }

    public int calcutateDurarion(){
        int totalDuration=0;
        for (AudioFile audioFile: audioFiles) {
            totalDuration+=audioFile.getDuration();
        }
        return totalDuration;
    }
    public List<AudioFile> audioByRange(int from,int to){
        List<AudioFile> list = new ArrayList<>();
        for (AudioFile audioFile: audioFiles) {
            if(audioFile.getDuration()>=from && audioFile.getDuration()<=to)
                list.add(audioFile);
        }
        return list;
    }
    public List<AudioFile> orderByGenre(){
        audioFiles.sort(new GenreComparator());
        return audioFiles;
    }

    private List<AudioFile> readAudiosFromFile(String path) throws NumberFormatException, IOException {
        List<AudioFile> audioFiles = new ArrayList<>();
        int i = 0;
        Scanner sc = new Scanner(new File(path));
        sc.useDelimiter("[,\n]");
        while (sc.hasNext()) {
            audioFiles.add(new AudioFile());
            audioFiles.get(i).setArtist(sc.next());
            audioFiles.get(i).setTitle(sc.next());
            audioFiles.get(i).setGenre(sc.next());
            audioFiles.get(i).setDuration((Integer.parseInt(sc.next().trim())));
            i++;
        }

        return audioFiles;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudioCollection audio = (AudioCollection) o;
        return  this.toString().equals(audio.toString());
    }

    @Override
    public int hashCode() { return this.toString().hashCode(); }

    @Override
    public String toString() {
        String result = "";
        for (AudioFile audio:audioFiles) {
            result +=audio+"\n";
        }
        return result;
    }
}
