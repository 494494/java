import java.util.*;
public class Album {
    // write code here
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    
    public Album(String name,String artist){
        this.name=name;
        this.artist=artist;
        this.songs=new ArrayList<Song>();
    }
    
    private Song findSong(String title){
        
        for(var x:songs){
            if(x.getTitle().equals(title)){
                return x;
            }
        }
        return null;
        
    }
    
    public boolean addSong(String title, double duration){
        if(findSong(title)!=null){
            return false;
        }
        songs.add(new Song(title,duration));
        return true;
    }
    
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songs.size())) {
            playList.add(songs.get(index));
            return true;
        }
        return false;
    }
 
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        return false;
    }
}
