package com.example.calcuconvert.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ConvertActivity extends ActionBarActivity {
    Button GradosF,GradosC;
    EditText Dato;
    TextView Resultado;
    public static final String PREFS_NAME = "LoginPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        GradosC=(Button)findViewById(R.id.btnC);
        GradosF=(Button)findViewById(R.id.btnF);
        GradosC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Dato=(EditText)findViewById(R.id.Valor);
                Dato.requestFocus();
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            Resultado=(TextView)findViewById(R.id.result);
                try {

                    float GRADO_F=Float.parseFloat(Dato.getText().toString());
                    float gradosC=((GRADO_F-32)*5)/9;

                           Resultado.setText("El resultado es:"+gradosC+"°C");


                }catch (Exception e){
                Resultado.setText("Se deben ingresar solo numeros");
            }
            }
        });
        GradosF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Dato = (EditText) findViewById(R.id.Valor);
                    Resultado = (TextView) findViewById(R.id.result);
                    float GRADO_C = Float.parseFloat(Dato.getText().toString());
                    float gradosF = 32 + (9 * GRADO_C / 5);
                    Resultado.setText("El resultado es:" + gradosF+"°F");
                }catch (Exception e){
                    Resultado.setText("Se deben ingresar solo numeros");
                }
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container);

        Dato = (EditText) view.findViewById(R.id.Valor);



        Dato.requestFocus();

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);



        return view;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.convert, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if (item.getItemId() == R.id.action_settings) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.remove("logged");
            editor.commit();
            finish();
            Intent intent = new Intent(ConvertActivity.this,LoginActivity.class );
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
