package com.example.diego.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.diego.miscontactos.util.ContactListAdapter;
import com.example.diego.miscontactos.util.Contacto;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private EditText txtNombre,txtTelefono,txtEmail,txtDireccion;
    private Button btnAgregar;
    private ArrayAdapter<Contacto> adapter ;
    private ImageView imgViewContacto;
    private ListView contactsListView;
    private int request_code =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponenteUI();
        inicializarListaContactos();
        inicializarTabs();
    }

    private void inicializarListaContactos() {

        adapter=new ContactListAdapter(this,new ArrayList<Contacto>());
        contactsListView.setAdapter(adapter);

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
        LimpiarCampos();

    }



    private void agregarContacto(String nombre, String direccion, String email, String telefono) {
        // agrego contactos  ala lista
        Contacto nuevo = new Contacto(nombre,telefono ,email,direccion);
        adapter.add(nuevo);

    }

    private void LimpiarCampos() {
        txtNombre.getText().clear();
        txtDireccion.getText().clear();
        txtTelefono.getText().clear();
        txtEmail.getText().clear();
    }

    public void onImgClick(View view) {
      Intent intent =null;
        // verificacamoc las version
        if(Build.VERSION.SDK_INT < 19){
            intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);// acceder a conetcnido de android


        }else{
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);

        }
        intent.setType("image/*");// tipo de contenido
        startActivityForResult(intent,request_code);//para identificar notificaciones
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
