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
 * Created by Ryan on 30/03/2017.
 */

public class EventList extends ArrayAdapter<Event> {

    private Activity context;
    private List<Event> eventList;

    public EventList(Activity context, List<Event> eventList) {
        super(context, R.layout.fragment_fragment_event, eventList);

        this.context = context;
        this.eventList = eventList;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View ListViewEvent = inflater.inflate(R.layout.eventlist, null, true);


        TextView judul = (TextView) ListViewEvent.findViewById(R.id.tvjudul);
        TextView waktu = (TextView) ListViewEvent.findViewById(R.id.tvtime);
        TextView by = (TextView) ListViewEvent.findViewById(R.id.tvby);

        Event event = eventList.get(position);

        judul.setText(event.getJudulev());
        waktu.setText(DateFormat.format("dd-MM-yyy |hh:mm|", event.getTanggalev()));
        by.setText(event.getAuthor());

        return ListViewEvent;
    }
}
