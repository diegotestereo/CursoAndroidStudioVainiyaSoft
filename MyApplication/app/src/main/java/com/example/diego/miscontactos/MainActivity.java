package com.example.diego.miscontactos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.diego.miscontactos.util.Contacto;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private EditText txtNombre,txtTelefono,txtEmail,txtDireccion;
    private Button btnAgregar;
    private List<Contacto> contactos = new ArrayList<Contacto>();
    private ListView contactsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponenteUI();
        inicializarTabs();
    }

    private void inicializarTabs()  {

        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec  =tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");
        tabHost.addTab(spec);

        spec  =tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");
        tabHost.addTab(spec);

    }

    private void inicializarComponenteUI(){

        txtNombre=(EditText)findViewById(R.id.cmpNombreContacto);
        txtTelefono=(EditText)findViewById(R.id.cmpTelefono);
        txtEmail=(EditText)findViewById(R.id.cmpCorreoElectronico);
        txtDireccion=(EditText)findViewById(R.id.cmpDireccion);
        btnAgregar=(Button)findViewById(R.id.btnAgregarContacto);
        contactsListView= (ListView) findViewById(R.id.listView);

    }

    public void onClick(View view) {

        agregarContacto(txtNombre.getText().toString(), txtEmail.getText().toString(), txtDireccion.getText().toString(), txtTelefono.getText().toString());
        String mensaje =String.format("Ha sido agregado a la lista "+txtNombre.getText());
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
        inicializarListView();
        LimpiarCampos();

    }

    private void inicializarListView() {


    }

    private void agregarContacto(String nombre, String direccion, String email, String telefono) {
        // agrego contactos  ala lista
        contactos.add(new Contacto(nombre,telefono ,email,direccion));

    }

    private void LimpiarCampos() {
        txtNombre.getText().clear();
        txtDireccion.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
    }
}
