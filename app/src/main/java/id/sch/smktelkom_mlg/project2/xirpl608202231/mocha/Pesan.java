package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

/**
 * Created by Dafa Zakhulhaq on 19/03/2017.
 */

public class Pesan {

    String id;
    String nama;
    Long tanggal;
    String text;

    public Pesan() {

    }

    public Pesan(String id, String nama, Long tanggal, String text) {
        this.id = id;
        this.nama = nama;
        this.tanggal = tanggal;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Long getTanggal() {
        return tanggal;
    }

    public String getText() {
        return text;
    }
}
