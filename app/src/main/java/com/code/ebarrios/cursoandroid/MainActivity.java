package com.code.ebarrios.cursoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.code.ebarrios.cursoandroid.View.ContainerActivity;
import com.code.ebarrios.cursoandroid.View.CreateAccountActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button irFragment;
    private TextView crearCuenta;

    private TextView usuario;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mapear inputs de login
        usuario = (TextView)findViewById(R.id.userName);
        password = (TextView)findViewById(R.id.userPassword);

        irFragment = (Button)findViewById(R.id.btnLogin);
        irFragment.setOnClickListener(this);

        crearCuenta = (TextView)findViewById(R.id.creaCuenta);
        crearCuenta.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogin:
                String txtUsuario = usuario.getText().toString();
                String txtPassword = password.getText().toString();

                if(txtUsuario.equals("") || txtPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"No ha ingresado un Usuario y/o Contraseña",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intentFragment = new Intent(MainActivity.this, ContainerActivity.class);
                    startActivity(intentFragment);
                }
                break;

            case R.id.creaCuenta:
                Intent intentCrearCuenta = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intentCrearCuenta);
                break;
        }
    }
}
