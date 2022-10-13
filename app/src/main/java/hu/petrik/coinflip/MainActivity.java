package hu.petrik.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     ImageView kep;
     Button fej;
     Button iras;
     TextView dobasok;
     TextView gyozelem;
     TextView vereseg;

     private int tipp;
     private int dobas;
     private int dobasCounter = 0;
     private int gyozelemCounter = 0;
     private int veresegCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kep = (ImageView) findViewById(R.id.kep);
        fej = (Button) findViewById(R.id.fej);
        iras = (Button) findViewById(R.id.iras);
        dobasok = (TextView) findViewById(R.id.dobasCounter);
        gyozelem = (TextView) findViewById(R.id.gyozelemCounter);
        vereseg = (TextView) findViewById(R.id.veresegCounter);

        fej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                dobas = (int)Math.random() * 1;
                kep.setImageResource(R.drawable.heads);
                Toast.makeText(getApplicationContext(), "Fej", Toast.LENGTH_SHORT).show();
                dobasCounter++;
                dobasok.setText(String.valueOf(dobasCounter));
                ellenorzes();
            }
        });

        iras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 0;
                dobas = (int)Math.random() * 1;
                kep.setImageResource(R.drawable.tails);
                Toast.makeText(getApplicationContext(), "Írás", Toast.LENGTH_SHORT).show();
                dobasCounter++;
                dobasok.setText(String.valueOf(dobasCounter));
                ellenorzes();
            }
        });



    }
    private void ellenorzes(){
        if (tipp == dobas){
            gyozelemCounter++;
            gyozelem.setText(String.valueOf(gyozelemCounter));
        } else {
            veresegCounter++;
            vereseg.setText(String.valueOf(veresegCounter));
        }
    }
}