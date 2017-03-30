package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class TentangKita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_kita);

        setTitle("About Us");

        findViewById(R.id.imageView1)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/daniamri18/");
                    }
                });
        findViewById(R.id.textViewJudul1)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/daniamri18/");
                    }
                });
        findViewById(R.id.textViewDeskripsi1)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/daniamri18/");
                    }
                });
        findViewById(R.id.imageView2)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/dafa_zakhulhaq/");
                    }
                });
        findViewById(R.id.textViewJudul2)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/dafa_zakhulhaq/");
                    }
                });
        findViewById(R.id.textViewDeskripsi2)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/dafa_zakhulhaq/");
                    }
                });

        findViewById(R.id.imageView3)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/muchsinhisyam/");
                    }
                });
        findViewById(R.id.textViewJudul3)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/muchsinhisyam/");
                    }
                });
        findViewById(R.id.textViewDeskripsi3)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/muchsinhisyam/");
                    }
                });

        findViewById(R.id.imageView4)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/ryan_maheynz/");
                    }
                });
        findViewById(R.id.textViewJudul4)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/ryan_maheynz/");
                    }
                });
        findViewById(R.id.textViewDeskripsi4)
                .setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        openWebPage("https://www.instagram.com/ryan_maheynz/");
                    }
                });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }
}
