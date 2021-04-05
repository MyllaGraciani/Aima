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

public class Cadastro_Activity extends AppCompatActivity {

    private EditText campoNome, campoEmail, campoGenero, campoSenha;
    private Button btnCadastrar;
    private Usuario usuario;

    private FirebaseAuth autenticar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initComponentes();

        //cadastrar user
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNome = campoNome.getText().toString();
                String txtEmail = campoEmail.getText().toString();
                String txtGenero = campoGenero.getText().toString();
                String txtSenha = campoSenha.getText().toString();

                if (!txtNome.isEmpty()   ){
                   if ( !txtEmail.isEmpty()){
                       if (!txtSenha.isEmpty()){
                           if (!txtGenero.isEmpty()){
                               usuario =  new Usuario();
                               usuario.setNome(txtNome);
                               usuario.setEmail(txtEmail);
                               usuario.setGenero(txtGenero);
                               usuario.setSenha(txtSenha);
                               cadastrar(usuario);
                           }else{
                               txtGenero = "Não informado";
                               usuario =  new Usuario();
                               usuario.setNome(txtNome);
                               usuario.setEmail(txtEmail);
                               usuario.setGenero(txtGenero);
                               usuario.setSenha(txtSenha);
                               cadastrar(usuario);
                           }

                       }else{Toast.makeText(Cadastro_Activity.this, "Por favor preencha sau senha.", Toast.LENGTH_SHORT).show();}
                   }else{Toast.makeText(Cadastro_Activity.this, "Por favor preencha seu e-mail.", Toast.LENGTH_SHORT).show();}

                }else{Toast.makeText(Cadastro_Activity.this, "Por favor preencha seu nome.", Toast.LENGTH_SHORT).show();}
            }
        });
    }

    public void cadastrar(Usuario usuario){
        autenticar = ConfiguracaoFirebase.getRefAutenticar();
        autenticar.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(
                this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            try{

                                //Salvar dados do user no bd
                                String idUsuario = task.getResult().getUser().getUid();
                                usuario.setId(idUsuario);
                                usuario.salvar();

                                Toast.makeText(Cadastro_Activity.this, "Cadastro feito com sucesso!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                        else{
                              String erroException="";
                              try {
                                  throw task.getException();
                              }catch (FirebaseAuthWeakPasswordException e){
                                  erroException = "Digite uma senha mais forte!";
                              }catch (FirebaseAuthInvalidCredentialsException e){
                                  erroException = "Por favor, digite uma e-mail válido!";
                              }catch (FirebaseAuthUserCollisionException e){
                                  erroException = "Esta conta já foi cadastrada.";
                              }catch (Exception e){
                                  erroException = "Ao se cadastrar: "+e.getMessage();
                                  e.printStackTrace();
                              }

                              Toast.makeText(Cadastro_Activity.this, "Erro: "+ erroException, Toast.LENGTH_SHORT).show();
                         }
                }

    }
        );
    }

    public void initComponentes(){
        campoNome = findViewById(R.id.c_edit_name);
        campoEmail = findViewById(R.id.c_edit_email);
        campoGenero = findViewById(R.id.c_edit_genero);
        campoSenha = findViewById(R.id.c_edit_senha);
        //pegar foto
        btnCadastrar = findViewById(R.id.c_btn_cadastrarUser);

        campoNome.requestFocus();
    }
}