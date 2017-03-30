package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl608202231.mocha.R;
import id.sch.smktelkom_mlg.project2.xirpl608202231.mocha.model.GuruModel;

/**
 * Created by Muchsin on 28/10/2016.
 */
public class GuruAdapter extends RecyclerView.Adapter<GuruAdapter.ViewHolder> {
    ArrayList<GuruModel> guruList;

    public GuruAdapter(ArrayList<GuruModel> guruList) {
        this.guruList = guruList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GuruModel guru = guruList.get(position);
        holder.tvJudul.setText(guru.judul);
        holder.tvDeskripsi.setText(guru.deskripsi);
        holder.ivFoto.setImageDrawable(guru.foto);
    }

    @Override
    public int getItemCount() {
        if (guruList != null)
            return guruList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
