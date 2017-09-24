package com.alvaropedrajas.agendaejercicio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ALTA = 100;
    private static final int BAJA = 200;
    private static final int LISTAR = 300;

    private List<Contacto> listaContactos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnDel = (Button) findViewById(R.id.btnDel);
        Button btnList = (Button) findViewById(R.id.btnList);
        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case ALTA:
                if (resultCode == Activity.RESULT_OK) {
                    if (data.hasExtra("contacto")){
                        listaContactos.add((Contacto)data.getSerializableExtra("contacto"));
                        Toast.makeText(this, listaContactos.get(listaContactos.size()-1).getNombre() + " ha sido guardado", Toast.LENGTH_LONG).show();
                    }
                } else if(resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(this, "No se ha guardado ningún contacto", Toast.LENGTH_LONG).show();
                }
                break;
            case BAJA:
                if (resultCode == Activity.RESULT_OK) {
                    if (data.hasExtra("contacto")){
                        Contacto c = (Contacto) data.getSerializableExtra("contacto");
                        Toast.makeText(this,listaContactos.remove(c) ? c.getNombre()+ " ha sido eliminado": c.getNombre() + " no puede ser borrado. No existe." , Toast.LENGTH_LONG).show();
                    }
                } else if(resultCode == Activity.RESULT_CANCELED) {
                    Toast.makeText(this, "No se ha borrado ningún contacto", Toast.LENGTH_LONG).show();
                }
                break;
            case LISTAR:

                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                Intent intAdd = new Intent(this, AddActivity.class);
                this.startActivityForResult(intAdd, ALTA);
                break;
            case R.id.btnDel:
                Intent intDel = new Intent(this, DeleteActivity.class);
                this.startActivityForResult(intDel, BAJA);
                break;
            case R.id.btnList:

                break;

        }

    }
}
