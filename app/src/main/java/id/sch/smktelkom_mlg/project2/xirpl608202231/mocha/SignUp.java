package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    EditText user;
    EditText pass;
    Button signup;
    ProgressDialog progressDialog;
    TextView ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        //lek user gak ana
        if (firebaseAuth.getCurrentUser() != null) {
            //tutup activity
            finish();

            //buka activity anyar
            startActivity(new Intent(getApplicationContext(), Main.class));
        }

        user = (EditText) findViewById(R.id.etuser);
        pass = (EditText) findViewById(R.id.etpass);
        signup = (Button) findViewById(R.id.etup);
        ready = (TextView) findViewById(R.id.tvready);

        progressDialog = new ProgressDialog(this);

        signup.setOnClickListener(this);
        ready.setOnClickListener(this);

    }

    //buat daftar
    private void daftar() {

        String user1 = user.getText().toString().trim();
        String pass1 = pass.getText().toString().trim();

        if (TextUtils.isEmpty(user1)) {
            Toast.makeText(this, "Tolong masukan username(email)", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pass1)) {
            Toast.makeText(this, "Tolong masukan password", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Proses Mendaftar...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(user1, pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Berhasil Mendaftar", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), Main.class));
                } else {
                    Toast.makeText(SignUp.this, "Gagal Mendaftar", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public void onClick(View view) {

        if (view == signup) {
            daftar();
        }
        if (view == ready) {

            startActivity(new Intent(this, Login.class));
        }

    }
}
