package sv.com.manuelqh.appsubsidiobasico;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numeroHij, hijosEscola;
    Button btnProcess;
    RadioButton radio1, radio2;
    TextView tHijos, hEscolar, sViudez, sTotal, msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numeroHij = (EditText) findViewById(R.id.nHijos);
        hijosEscola = (EditText) findViewById(R.id.nHijosEescolar);
        btnProcess = (Button) findViewById(R.id.btnProcess);
        radio1 = (RadioButton) findViewById(R.id.rViuda);
        radio2 = (RadioButton) findViewById(R.id.rOtro);

        tHijos = (TextView) findViewById(R.id.txtTotalHijos);
        hEscolar = (TextView) findViewById(R.id.txtHijosEscolares);
        sViudez = (TextView) findViewById(R.id.txtViudez);
        sTotal = (TextView) findViewById(R.id.txtSubsidioTotal);
        msg = (TextView) findViewById(R.id.txtMensaje); 

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subsidio();
            }
        });
    }

    public void subsidio() {

        double subsidio1, subsidio2, subsidio3 = 0, subsidiofinal;
        String mensaje = null;

        String Nh = numeroHij.getText().toString();
        int sNh = Integer.parseInt(Nh);

        String Nes = hijosEscola.getText().toString();
        int sHe = Integer.parseInt(Nes);

        if (sNh<=2) {
            subsidio1 =1700;

        } else if (sNh<=5) {
            subsidio1 = 1900;

        } else {
            subsidio1 = 1200;
        }

        subsidio2 = sHe *200;

        if (radio1.isChecked()==true) {
            subsidio3=800;
            mostrarTextos();

        }else if (radio2.isChecked()==true) {
            mensaje = "No tenemos disponible esta opcion todavia";
            ocultarTextos();
        }

        subsidiofinal = subsidio1+subsidio2+subsidio3;

        tHijos.setText("El monto del Subsidio por Numero de Hijos es: "+subsidio1);
        hEscolar.setText("El subsidio de hijos por edad escolar es: "+subsidio2);
        sViudez.setText("El subsidio por Viudez es: "+subsidio3);
        sTotal.setText("El monto total de Subsidio acumulado es: " +subsidiofinal);
        msg.setText(mensaje);
    }
    
    

        public void mostrarTextos(){
            tHijos.setVisibility(View.VISIBLE);
            hEscolar.setVisibility(View.VISIBLE);
            sViudez.setVisibility(View.VISIBLE);
            sTotal.setVisibility(View.VISIBLE);
        }

        public void ocultarTextos() {
            tHijos.setVisibility(View.GONE);
            hEscolar.setVisibility(View.GONE);
            sViudez.setVisibility(View.GONE);
            sTotal.setVisibility(View.GONE);
        }

}
