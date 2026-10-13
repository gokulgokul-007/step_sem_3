import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    public void addSong(String title) {
        if (count < songs.length) {
            songs[count++] = title;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count); // safe copy
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("p.getSongs()[0] = " + p.getSongs()[0]);
        System.out.println("count = " + p.getSongCount());
    }
}