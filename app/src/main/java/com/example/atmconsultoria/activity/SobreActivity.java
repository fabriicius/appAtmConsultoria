package com.example.atmconsultoria.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);

        String descrição = "A ATM Consultoria tem como missão apoiar as organizações que desejam alcançar o sucesso através da excelência em gestão e da busca pela Qualidade.\n\n" +
                "Nosso trabalho é dar suporte às empresas que desejam se certificar em padrões de qualidade ou investir no desenvolvimento e evolução de sua gestão, por meio da otimização dos processos e da disseminação dos Fundamentos e Critérios de Excelência.";

        View sobre = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription(descrição)
                .addGroup("Fale Conosco")
                .addEmail("" , "Envie um email")
                .addWebsite("", "Acesse nosso site")
                .addGroup("Redes Sociais")
                .addFacebook("", "Siga nos no facebook")
                .addTwitter("", "Siga nos no twitter")
                .addYoutube("", "Se inscrevam no canal do youtube")
                .addPlayStore("", "Baixe nosso APP")
                .addGitHub("", "Acesse nosso Github")
                .addInstagram("", "Siga nos no instagram")
                .create();


        setContentView(sobre);

    }
}
