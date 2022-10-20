package dev.mah.labo2;

public class Exercice {

    private String id;
    private String title;
    private String image;
    private String time;
    private String repeat;
    private String categ;
    private String description;
    private String video;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }

    public String getRepeat() {
        return repeat;
    }

    public String getCateg() {
        return categ;
    }

    public String getDescription() {
        return description;
    }

    public String getVideo() {
        return video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Exercice(String id, String title, String image, String time, String repeat, String categ, String description, String video) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.time = time;
        this.repeat = repeat;
        this.categ = categ;
        this.description = description;
        this.video = video;
    }

    public Exercice(String title, String image, String time, String repeat, String categ, String description, String video) {
        this.title = title;
        this.image = image;
        this.time = time;
        this.repeat = repeat;
        this.categ = categ;
        this.description = description;
        this.video = video;
    }

    public String toString() {
        return this.id +"\n"+
        this.title +"\n"+
        this.image +"\n"+
        this.time +"\n"+
        this.repeat +"\n"+
        this.categ +"\n"+
        this.description +"\n"+
        this.video;
    }
}


