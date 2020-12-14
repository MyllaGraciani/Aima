package com.ai.app.aima.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ai.app.aima.R;
import com.ai.app.aima.firebase.ConfiguracaoFirebase;
import com.ai.app.aima.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class Login_Activity extends AppCompatActivity {
    private EditText  campoEmail, campoSenha;
    private Button btnEntrar;
    private Usuario usuario;

    private FirebaseAuth autenticar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verificarUserLogado();
        initComponentes();

        //fazer login
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String txtEmail = campoEmail.getText().toString();
                String txtSenha = campoSenha.getText().toString();

                if (!txtEmail.isEmpty()) {
                    if (!txtSenha.isEmpty()) {
                        usuario = new Usuario();
                        usuario.setEmail(txtEmail);
                        usuario.setSenha(txtSenha);
                        validarLogin(usuario);
                    } else {Toast.makeText(Login_Activity.this, "Por favor preencha a sua senha.", Toast.LENGTH_SHORT).show();}
                } else {Toast.makeText(Login_Activity.this, "Por favor preencha o seu e-mail.", Toast.LENGTH_SHORT).show();}
            }
        });


    }

    public void verificarUserLogado(){
        autenticar = ConfiguracaoFirebase.getRefAutenticar();
        if (autenticar.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }

    public void criarCadastro (View view){
        Intent i = new Intent(Login_Activity.this, Cadastro_Activity.class);
        startActivity(i);
    }

    public void validarLogin(Usuario usuario){
        autenticar = ConfiguracaoFirebase.getRefAutenticar();

        autenticar.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(Login_Activity.this, "Erro ao fazer login. ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initComponentes(){
        campoEmail = findViewById(R.id.l_edit_email);
        campoSenha = findViewById(R.id.l_edit_senha);
        btnEntrar = findViewById(R.id.l_btn_entrar);

        campoEmail.requestFocus();
    }

}