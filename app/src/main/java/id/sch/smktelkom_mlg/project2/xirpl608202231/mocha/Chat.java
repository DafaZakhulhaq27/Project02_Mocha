package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chat extends Fragment {

    FirebaseAuth firebaseAuth;
    EditText etinput;
    FloatingActionButton fabs;
    long time;
    ListView listViewpesan;
    List<Pesan> pesanList;
    DatabaseReference databasePesan;
    String nama;
    public Chat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);


        databasePesan = FirebaseDatabase.getInstance().getReference("Pesan");

        etinput = (EditText) view.findViewById(R.id.input);
        fabs = (FloatingActionButton) view.findViewById(R.id.fab);
        listViewpesan = (ListView) view.findViewById(R.id.list_of_chat);
        pesanList = new ArrayList<>();

        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addpesan();

            }
        });


        listViewpesan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setMessage("Hapus Semua Pesan");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Ya",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                databasePesan.addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {

                                        dataSnapshot.getRef().removeValue();


                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });

                            }
                        });

                builder1.setNegativeButton(
                        "Tidak",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();



                return true;
            }
        });

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        databasePesan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                pesanList.clear();
                for (DataSnapshot pesansnapshot : dataSnapshot.getChildren()) {
                    Pesan pesan = pesansnapshot.getValue(Pesan.class);

                    pesanList.add(pesan);

                    notif();


                }

                PesanList adapter = new PesanList(getActivity(), pesanList);
                listViewpesan.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void addpesan() {


        firebaseAuth = FirebaseAuth.getInstance();

        time = new Date().getTime();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        String pesan = etinput.getText().toString().trim();
        nama = user.getEmail();
        Long tanggal = time;

        if (!TextUtils.isEmpty(pesan)) {


            String id = databasePesan.push().getKey();

            Pesan pesan1 = new Pesan(id, nama, tanggal, pesan);

            databasePesan.child(id).setValue(pesan1);
            etinput.setText("");


        }


    }

    private void notif() {


        // Key for the string that's delivered in the action's intent.
        // define sound URI, the sound to be played when there's a notification

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(getActivity(), Main.class);
        PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
        Notification mNotification = new Notification.Builder(getActivity()).setContentTitle("MOCHA")
                .setContentText("Pesan Baru")
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentIntent(pIntent)
                .setSound(soundUri)
                .build();
        NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, mNotification);
    }

    public void cancelNotification(int notificationId) {
        if (NOTIFICATION_SERVICE != null) {
            String ns = NOTIFICATION_SERVICE;
            NotificationManager nMgr = (NotificationManager) getActivity().getApplicationContext().getSystemService(ns);
            nMgr.cancel(notificationId);
        }
    }
}

