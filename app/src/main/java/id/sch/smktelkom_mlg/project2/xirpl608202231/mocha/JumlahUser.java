package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class JumlahUser extends Fragment {

    TextView jumlah;
    FirebaseAuth firebaseAuth;

    public JumlahUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_jumlah_user, container, false);

        jumlah = (TextView) view.findViewById(R.id.tvjumlahu);

        firebaseAuth = FirebaseAuth.getInstance();


        return view;

    }

}
