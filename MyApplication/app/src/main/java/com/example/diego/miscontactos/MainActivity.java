package com.example.diego.miscontactos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText txtNombre,txtTelefono,txtEmail,txtDireccion;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponenteUI();
    }

    private void inicializarComponenteUI(){

        txtNombre=(EditText)findViewById(R.id.cmpNombreContacto);
        txtTelefono=(EditText)findViewById(R.id.cmpTelefono);
        txtEmail=(EditText)findViewById(R.id.cmpCorreoElectronico);
        txtDireccion=(EditText)findViewById(R.id.cmpDireccion);
        btnAgregar=(Button)findViewById(R.id.btnAgregarContacto);

    }

    public void onClick(View view) {

        String mensaje =String.format("Ha sido agregado a la lista "+txtNombre.getText());
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        LimpiarCampos();

    }

    private void LimpiarCampos() {
        txtNombre.getText().clear();
        txtDireccion.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
    }
}
