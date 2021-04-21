package com.ai.app.aima.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class UsuarioFirebase {

    public static FirebaseUser getUsuarioAtual(){
        FirebaseAuth usuario = ConfiguracaoFirebase.getRefAutenticar();
        return usuario.getCurrentUser();
    }

    public static void atualizarNomeUsuario(String nome){
        try {
            //user logado
            FirebaseUser user = getUsuarioAtual();

            //configuracao do objeto para alterar perfil
            UserProfileChangeRequest profile = new UserProfileChangeRequest
                    .Builder().setDisplayName(nome).build();

            user.updateProfile(profile).addOnCompleteListener(task -> {
                if(!task.isSuccessful()){
                    Log.d("Perfil", "Erro ao atualizar o nome de perfil.");
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
