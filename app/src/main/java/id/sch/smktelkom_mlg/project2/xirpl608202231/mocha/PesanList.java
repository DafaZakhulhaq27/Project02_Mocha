package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dafa Zakhulhaq on 20/03/2017.
 */

public class PesanList extends ArrayAdapter<Pesan> {

    private Activity context;
    private List<Pesan> pesanList;

    public PesanList(Activity context, List<Pesan> pesanList) {
        super(context, R.layout.chat, pesanList);

        this.context = context;
        this.pesanList = pesanList;


    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View ListViewItem = inflater.inflate(R.layout.chat, null, true);

        TextView user = (TextView) ListViewItem.findViewById(R.id.user);
        TextView tanggal = (TextView) ListViewItem.findViewById(R.id.time);
        TextView teks = (TextView) ListViewItem.findViewById(R.id.text);

        Pesan pesan = pesanList.get(position);

        user.setText(pesan.getNama());
        tanggal.setText(DateFormat.format("dd-MM-yyy |hh:mm|", pesan.getTanggal()));
        teks.setText(pesan.getText());

        return ListViewItem;
    }

}
