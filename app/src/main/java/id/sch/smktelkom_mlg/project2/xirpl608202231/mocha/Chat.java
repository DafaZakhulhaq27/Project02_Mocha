package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class Chat extends Fragment {

    FirebaseAuth firebaseAuth;
    EditText etinput;
    FloatingActionButton fabs;
    long time;

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


        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addpesan();

            }
        });


        return view;
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
