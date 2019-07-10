package com.example.atmconsultoria.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ServiceCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.atmconsultoria.R;
import com.example.atmconsultoria.fragment.ClientesFragment;
import com.example.atmconsultoria.fragment.ContatoFragment;
import com.example.atmconsultoria.fragment.PrincipalFragment;
import com.example.atmconsultoria.fragment.ServicosFragment;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameContainer);


        //CARREGAR TELA PRINCIPAL
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction frameLayout = getSupportFragmentManager().beginTransaction();
        frameLayout.replace(R.id.frameContainer , principalFragment);
        frameLayout.commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction frameLayout = getSupportFragmentManager().beginTransaction();
            frameLayout.replace(R.id.frameContainer , principalFragment);
            frameLayout.commit();

        } else if (id == R.id.nav_servicos) {

            ServicosFragment servicosFragment = new ServicosFragment();
            FragmentTransaction frameLayout = getSupportFragmentManager().beginTransaction();
            frameLayout.replace(R.id.frameContainer , servicosFragment);
            frameLayout.commit();

        } else if (id == R.id.nav_clientes) {

            ClientesFragment clientesFragment = new ClientesFragment();
            FragmentTransaction frameLayout = getSupportFragmentManager().beginTransaction();
            frameLayout.replace(R.id.frameContainer , clientesFragment);
            frameLayout.commit();

        } else if (id == R.id.nav_contato) {

            enviarEmail();


        } else if (id == R.id.nav_sobre) {

            startActivity(new Intent(this, SobreActivity.class));


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void enviarEmail(){

        Intent email = new Intent( Intent.ACTION_SEND );
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"atmconsultoria@gmail.com,"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo app" );
        email.putExtra(Intent.EXTRA_TEXT, "Mensagem Automatica");
        //configurar apps para email
        email.setType("message/rfc822");
        //email.setType("application/pdf");

        try {
            startActivity(Intent.createChooser(email, "Escolha o app de email"));
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "Não ha app de Email encontrado", Toast.LENGTH_SHORT);
        } catch (Exception ex) {
            Toast.makeText(this, "Erro inesperado, tente novamente mais tarde ou outro aplicativo", Toast.LENGTH_SHORT);
        }


    }
}
