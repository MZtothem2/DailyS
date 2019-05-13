package kr.co.md00to22.dailys;

import java.util.ArrayList;

public class Memo {
    private String title;
    private String writeTime;
    private boolean isLocked;
    private CharSequence password;

    private String category;
    private boolean isBookmarked;

    private ArrayList<String> texts;
    private ArrayList<Check> checks;
    private ArrayList<Photo> photos;

    public Memo(String title, String writeTime, boolean isLocked, String category, boolean isBookmarked) {
        this.title = title;
        this.writeTime = writeTime;
        this.isLocked = isLocked;
        this.category = category;
        this.isBookmarked = isBookmarked;

        this.texts=new ArrayList<>();
        this.checks=new ArrayList<>();
        this.photos=new ArrayList<>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public ArrayList<String> getTexts() {
        return texts;
    }

    public void setTexts(ArrayList<String> texts) {
        this.texts = texts;
    }

    public ArrayList<Check> getChecks() {
        return checks;
    }

    public void setChecks(ArrayList<Check> checks) {
        this.checks = checks;
    }

    public ArrayList<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photo> photos) {
        this.photos = photos;
    }
}
