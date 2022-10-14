package hu.petrik.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
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
     AlertDialog.Builder alert;

     //0 - ÍRÁS, 1 - FEJ
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
        alert = new AlertDialog.Builder(this);

        fej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 1;
                botDobas();
                ellenorzes();
                vege();
            }
        });

        iras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipp = 0;
                botDobas();
                ellenorzes();
                vege();
            }
        });



    }

    private void botDobas(){
        dobas = (int)(Math.random() * 2);
        if (dobas == 1){
            kep.setImageResource(R.drawable.heads);
            Toast.makeText(getApplicationContext(), "Fej", Toast.LENGTH_SHORT).show();
            dobasCounter++;
            dobasok.setText(String.valueOf(dobasCounter));
        } else {
            dobas = (int)(Math.random() * 2);
            kep.setImageResource(R.drawable.tails);
            Toast.makeText(getApplicationContext(), "Írás", Toast.LENGTH_SHORT).show();
            dobasCounter++;
            dobasok.setText(String.valueOf(dobasCounter));
        }
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

    private void vege(){
        if (dobasCounter == 5){
            if (gyozelemCounter > veresegCounter){
                alert.setTitle("Győzelem").
                        setMessage("Szeretne új játékot játszani?").
                        setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                System.exit(0);
                            }
                        }).
                        setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                kep.setImageResource(R.drawable.heads);
                                dobasCounter = 0;
                                dobasok.setText(String.valueOf(dobasCounter));
                                gyozelemCounter = 0;
                                gyozelem.setText(String.valueOf(gyozelemCounter));
                                veresegCounter = 0;
                                vereseg.setText(String.valueOf(veresegCounter));
                            }
                        });
                alert.show();
            } else {
                alert.setTitle("Vereség").
                        setMessage("Szeretne új játékot játszani?").
                        setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                System.exit(0);
                            }
                        }).
                        setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                kep.setImageResource(R.drawable.heads);
                                dobasCounter = 0;
                                dobasok.setText(String.valueOf(dobasCounter));
                                gyozelemCounter = 0;
                                gyozelem.setText(String.valueOf(gyozelemCounter));
                                veresegCounter = 0;
                                vereseg.setText(String.valueOf(veresegCounter));
                            }
                        });
                alert.show();
            }
        }
    }
}