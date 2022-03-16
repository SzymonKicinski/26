package Main.Album;

import Main.Song.Song;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();

    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
/*
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
*/
    }

   public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(trackNumber);
        if (checkedSong != null) {

            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String titile, LinkedList<Song> playList){
        Song checkedSong = this.songs.findSong(titile);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song "+ titile + " is not in this album");
        return false;
    }

    private class SongList{
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(title))
                    return checkedSong;
            }
            return null;
        }

        protected Song findSong(int trackNumber) {
            int index = trackNumber -1;
            if ((index >0 ) && (index<songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }
}
