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

public class Login extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth firebaseAuth;
    EditText user;
    EditText pass;
    Button signin;
    ProgressDialog progressDialog;
    TextView ready;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
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
        signin = (Button) findViewById(R.id.etin);
        ready = (TextView) findViewById(R.id.tvready);

        progressDialog = new ProgressDialog(this);

        signin.setOnClickListener(this);
        ready.setOnClickListener(this);
    }

    private void login() {

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

        progressDialog.setMessage("Proses Login...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(user1, pass1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if (task.isSuccessful()) {

                            Toast.makeText(Login.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), Main.class));


                        } else {

                            Toast.makeText(Login.this, "Gagal Login", Toast.LENGTH_LONG).show();

                        }
                        progressDialog.dismiss();
                    }
                });


    }

    @Override
    public void onClick(View view) {

        if (view == signin) {
            login();
        }
        if (view == ready) {

            startActivity(new Intent(this, SignUp.class));
        }

    }
}
