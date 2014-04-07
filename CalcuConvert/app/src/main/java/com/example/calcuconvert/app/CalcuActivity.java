package com.example.calcuconvert.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalcuActivity extends ActionBarActivity {
Button boton0,boton1,boton2,boton3,boton4,boton5,boton6,boton7,boton8,boton9,Div,Mul,Sum,Res,DEL,CE,Punto,igual;
TextView Resultado;
String ValorTotal;
float primerNum;
float Calculo;
String TipoCalculo;

    public static final String PREFS_NAME = "LoginPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);
        boton0=(Button)findViewById(R.id.Boton0);
        boton1=(Button)findViewById(R.id.Boton1);
        boton2=(Button)findViewById(R.id.Boton2);
        boton3=(Button)findViewById(R.id.Boton3);
        boton4=(Button)findViewById(R.id.Boton4);
        boton5=(Button)findViewById(R.id.Boton5);
        boton6=(Button)findViewById(R.id.Boton6);
        boton7=(Button)findViewById(R.id.Boton7);
        boton8=(Button)findViewById(R.id.Boton8);
        boton9=(Button)findViewById(R.id.Boton9);
        Div=(Button)findViewById(R.id.Botondiv);
        Mul=(Button)findViewById(R.id.Botonmulti);
        Res=(Button)findViewById(R.id.Botonresta);
        Sum=(Button)findViewById(R.id.Botonsuma);
        DEL=(Button)findViewById(R.id.DEL);
        CE=(Button)findViewById(R.id.CE);
        Punto=(Button)findViewById(R.id.Botonpunto);
        Resultado=(TextView)findViewById(R.id.resultado);
        igual=(Button)findViewById(R.id.Botonigual);


        boton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton0.getText());
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton1.getText());
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton2.getText());
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton3.getText());
            }
        });
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton4.getText());
            }
        });
        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton5.getText());
            }
        });
        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton6.getText());
            }
        });
        boton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton7.getText());
            }
        });
        boton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton8.getText());
            }
        });
        boton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal=(String)Resultado.getText();
                Resultado.setText((String)ValorTotal+(String)boton9.getText());
            }
        });
        Sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Resultado.setText("");
                TipoCalculo="suma";
                primerNum=Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");

            }
        });
        Res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TipoCalculo = "resta";
                primerNum = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");

            }
        });
        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Resultado.setText("");
                TipoCalculo = "div";
                primerNum = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");

            }
        });
        Mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Resultado.setText("");
                TipoCalculo = "por";
                primerNum = Float.valueOf(Resultado.getText().toString());
                Resultado.setText("");
            }
        });
        Punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValorTotal = (String) Resultado.getText();
                String sTexto = ValorTotal;
                // Texto que vamos a buscar
                String sTextoBuscado = ".";

                if (sTexto.indexOf(sTextoBuscado)==-1) {
                    Resultado.setText((String) ValorTotal + (String) Punto.getText());
                }

            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TipoCalculo == "suma") {
                    Calculo = primerNum + Float.valueOf(Resultado.getText().toString());
                } else if (TipoCalculo == "resta") {
                    Calculo = primerNum - Float.valueOf(Resultado.getText().toString());
                } else if (TipoCalculo == "div") {
                    Calculo = primerNum / Float.valueOf(Resultado.getText().toString());
                } else if (TipoCalculo == "por") {
                    Calculo = primerNum * Float.valueOf(Resultado.getText().toString());
                }
                Resultado.setText(Float.toString(Calculo));
                primerNum = 0;
            }
        });
        CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resultado.setText("");
            }
        });

        DEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x = "";
                x= Resultado.getText().toString();
                if (x.length() > 0) {
                    x = x.substring(0, (x.length() - 1));
                    Resultado.setText(x);
                    }

            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calcu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (item.getItemId() == R.id.action_settings) {
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.remove("logged");
            editor.commit();
            finish();
            Intent intent = new Intent(CalcuActivity.this,LoginActivity.class );
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
