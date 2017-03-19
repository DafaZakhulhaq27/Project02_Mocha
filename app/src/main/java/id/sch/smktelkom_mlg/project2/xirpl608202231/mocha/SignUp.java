package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        user = (EditText) findViewById(R.id.etuser);
        pass = (EditText) findViewById(R.id.etpass);
        signup = (Button) findViewById(R.id.etup);

        progressDialog = new ProgressDialog(this);

        signup.setOnClickListener(this);

    }

    private void daftar() {

        String user1 = user.getText().toString().trim();
        String pass1 = pass.getText().toString().trim();

        progressDialog.setMessage("Proses Mendaftar...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(user1, pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(SignUp.this, "Berhasil Mendaftar", Toast.LENGTH_LONG).show();


                } else {

                    Toast.makeText(SignUp.this, "Gagal Mendaftar", Toast.LENGTH_LONG).show();

                }
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public void onClick(View view) {

        daftar();
    }
}
