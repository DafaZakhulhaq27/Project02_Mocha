package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        String nama = user.getEmail();
        Long tanggal = time;

        if (!TextUtils.isEmpty(pesan)) {

            String id = databasePesan.push().getKey();

            Pesan pesan1 = new Pesan(id, nama, tanggal, pesan);

            databasePesan.child(id).setValue(pesan1);
        }


    }

}
