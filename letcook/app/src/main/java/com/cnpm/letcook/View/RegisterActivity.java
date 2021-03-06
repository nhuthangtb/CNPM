package com.cnpm.letcook.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cnpm.letcook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRegister;
    EditText editEmail, editPassword, editRePassword;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = firebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        setContentView(R.layout.layout_register);
        btnRegister = findViewById(R.id.btnRegister);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassWord);
        editRePassword = findViewById(R.id.editRePassword);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        String repassword = editRePassword.getText().toString();

        progressDialog.setMessage(getString(R.string.processing));
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        if (email.trim().length() == 0) {
            Toast.makeText(this, getString(R.string.error_emptyemail), Toast.LENGTH_SHORT).show();
        } else if (password.trim().length() == 0) {
            Toast.makeText(this, getString(R.string.error_emptypassword), Toast.LENGTH_SHORT).show();
        } else if (repassword.trim().length() == 0) {
            Toast.makeText(this, getString(R.string.error_emptypassword), Toast.LENGTH_SHORT).show();
        } else if (!repassword.equals(password)) {
            Toast.makeText(this, getString(R.string.error_repassword), Toast.LENGTH_SHORT).show();

        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, getString(R.string.register_successful), Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
        }
    }
}
