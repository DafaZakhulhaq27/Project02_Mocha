package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEvent extends Fragment {

    List<Event> eventList;
    DatabaseReference databaseEvent;
    FirebaseAuth firebaseAuth;
    ListView listViewevent;

    public FragmentEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_event, container, false);
        databaseEvent = FirebaseDatabase.getInstance().getReference("Event");
        listViewevent = (ListView) view.findViewById(R.id.list_of_event);
        eventList = new ArrayList<>();


        FloatingActionButton btnEvent = (FloatingActionButton) view.findViewById(R.id.btnaddevent);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), InputEvent.class));
            }
        });


        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        databaseEvent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                eventList.clear();
                for (DataSnapshot eventsnapshot : dataSnapshot.getChildren()) {
                    Event event = eventsnapshot.getValue(Event.class);

                    eventList.add(event);


                }

                EventList adapter = new EventList(getActivity(), eventList);
                listViewevent.setAdapter(adapter);

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
