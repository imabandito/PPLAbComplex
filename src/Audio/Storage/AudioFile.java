package Audio.Storage;

import java.util.Objects;

public class AudioFile {
    private  String artist;
    private  String title;
    private  String genre;
    private  int duration;

    public AudioFile(){}
    public AudioFile(String artist, String title, String genre, int duration) {
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public int getDuration() { return duration; }
    public String getArtist() { return artist; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }

    public void setArtist(String artist) { this.artist = artist; }
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudioFile audio = (AudioFile) o;
        return  artist.equals(audio.artist) &&
                title.equals(audio.title) &&
                genre.equals(audio.genre) &&
                duration == audio.duration;
    }

    @Override
    public int hashCode() { return Objects.hash(artist,title,genre,duration); }

    @Override
    public String toString() {
        return "artist = " + artist  + "\ttitle = '" + title  + "',\tgenre = " + genre  + ",\tduration = " + duration; }
}
