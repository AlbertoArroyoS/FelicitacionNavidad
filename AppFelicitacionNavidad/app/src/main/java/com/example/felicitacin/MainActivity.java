package com.example.felicitacin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().show();


        //musica de la aplicacion
        MediaPlayer mediaPlayer = MediaPlayer.create( this, R.raw.audio_navidad);
        mediaPlayer.start();

        //conseguir la referencia del identificador
        TextView titulo = findViewById(R.id.titulo);
        //crear la animacion
        Animation animTitulo = AnimationUtils.loadAnimation(this,R.anim.anim_titulo);
        //Asignar la animacion al titulo
        titulo.startAnimation(animTitulo);

        //animacion del año
        TextView year = findViewById(R.id.year);
        Animation animYear= AnimationUtils.loadAnimation(this,R.anim.slideup);
        year.startAnimation(animYear);

        //animacion frase
        TextView frase1 = findViewById(R.id.frase1);
        Animation animFrase1 = AnimationUtils.loadAnimation(this,R.anim.anim_frase);
        frase1.startAnimation(animFrase1);

        TextView frase2 = findViewById(R.id.frase2);
        Animation animFrase2 = AnimationUtils.loadAnimation(this,R.anim.anim_frase2);
        frase2.startAnimation(animFrase2);

        TextView frase3 = findViewById(R.id.frase3);
        Animation animFrase3 = AnimationUtils.loadAnimation(this,R.anim.anim_frase3);
        frase3.startAnimation(animFrase3);

        //Hago que el gif aparezca cuanto terminen todas las frases

        GifImageView gifImageView = findViewById(R.id.fuegos);
        //que aparezca invisible
        gifImageView.setVisibility(View.INVISIBLE);
        try {
            // Cargar el GIF desde recursos
            GifDrawable gifFuego = new GifDrawable(getResources(), R.drawable.fuegos_artificiales);

            // Establecer el loopCount a 1 para reproducir el GIF solo una vez, 0 continuamente
            gifFuego.setLoopCount(0);

            // Asignar el GifDrawable al GifImageView
            gifImageView.setImageDrawable(gifFuego);

            // Utilizar un Handler para agregar un retraso de 13 segundos antes de hacer visible el GifImageView
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Hacer visible el GifImageView
                    gifImageView.setVisibility(View.VISIBLE);
                }
            }, 13000);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}