package com.ai.app.aima.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ai.app.aima.R;
import com.ai.app.aima.firebase.ConfiguracaoFirebase;
import com.ai.app.aima.fragment.CicloFragment;
import com.ai.app.aima.fragment.HomeFragment;
import com.ai.app.aima.fragment.IdeiasFragment;
import com.ai.app.aima.fragment.NotesFragment;
import com.ai.app.aima.fragment.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth autenticar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        //firebase
        autenticar = ConfiguracaoFirebase.getRefAutenticar();

        //config bottom nav view
        configBottomNavigationView();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewPager, new HomeFragment()).commit();
    }

    private void configBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottom_navigation);

        //habilitar nav
        habNavegacao(bottomNavigationViewEx);
    }

    private void habNavegacao(BottomNavigationViewEx viewEx){
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(item.getItemId() == R.id.ic_home){
                    fragmentTransaction.replace(R.id.viewPager, new HomeFragment()).commit();
                    return true;
                }else if (item.getItemId()==R.id.ic_notes){
                    fragmentTransaction.replace(R.id.viewPager, new NotesFragment()).commit();
                    return true;
                }else if (item.getItemId()==R.id.ic_ciclo){
                    fragmentTransaction.replace(R.id.viewPager, new CicloFragment()).commit();
                    return true;
                }else if (item.getItemId()==R.id.ic_ideias){
                    fragmentTransaction.replace(R.id.viewPager, new IdeiasFragment()).commit();
                    return true;
                }else if (item.getItemId()==R.id.ic_perfil){
                    fragmentTransaction.replace(R.id.viewPager, new PerfilFragment()).commit();
                    return true;
                }
                    return false;

            }
        });
    }

    private void deslogarUser(){
        try {
            autenticar.signOut();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_sair) {
            deslogarUser();
            startActivity(new Intent(getApplicationContext(), Login_Activity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpToolbar() {
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
    }
}