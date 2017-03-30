package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

/**
 * Created by Ryan on 30/03/2017.
 */

public class Event {

    String idev;
    String judulev;
    Long tanggalev;
    String author;


    public Event() {

    }

    public Event(String idev, String judulev, Long tanggalev, String author) {
        this.idev = idev;
        this.judulev = judulev;
        this.tanggalev = tanggalev;
        this.author = author;

    }

    public String getIdev() {
        return idev;
    }

    public String getJudulev() {
        return judulev;
    }

    public Long getTanggalev() {
        return tanggalev;
    }


    public String getAuthor() {
        return author;
    }
}

