package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    String judul1, deskrip1;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.list_event, container, false);

        FloatingActionButton btnEvent = (FloatingActionButton) view.findViewById(R.id.naddevent);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Tulis Nama Event");
                final EditText judul = new EditText(getActivity());
                builder.setView(judul);

                AlertDialog.Builder deskripsi = new AlertDialog.Builder(getActivity());
                deskripsi.setTitle("Tulis Keterangan Event");
                final EditText deskrip = new EditText(getActivity());
                deskripsi.setView(deskrip);

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        judul1 = judul.getText().toString();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                deskripsi.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        deskrip1 = deskrip.getText().toString();

                    }
                });
                deskripsi.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });

                deskripsi.show();
                builder.show();


            }
        });
        return view;
    }


}
