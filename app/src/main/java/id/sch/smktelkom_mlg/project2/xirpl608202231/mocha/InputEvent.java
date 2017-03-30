package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InputEvent extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText editjudul;
    EditText editdeskrip;
    Button simpan;
    long time;
    List<Event> eventList;
    DatabaseReference databaseEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_event);


        databaseEvent = FirebaseDatabase.getInstance().getReference("Event");

        editjudul = (EditText) findViewById(R.id.editTextNama);
        editdeskrip = (EditText) findViewById(R.id.editTextDeskripsi);
        simpan = (Button) findViewById(R.id.buttonSimpan);
        eventList = new ArrayList<>();

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addevent();
                finish();
            }
        });

    }

    private void addevent() {
        firebaseAuth = FirebaseAuth.getInstance();
        time = new Date().getTime();
        FirebaseUser user = firebaseAuth.getCurrentUser();


        String judul = editjudul.getText().toString().trim();

        long tanggal = time;
        String author = user.getEmail();


        if (!TextUtils.isEmpty(judul)) {

            String idev = databaseEvent.push().getKey();

            Event event1 = new Event(idev, judul, tanggal, author);

            databaseEvent.child(idev).setValue(event1);

        }
    }


}

