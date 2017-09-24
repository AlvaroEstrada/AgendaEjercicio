package com.alvaropedrajas.agendaejercicio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends Activity implements View.OnClickListener{

    private ListView listView;
    ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        contactos = (ArrayList<Contacto>)getIntent().getSerializableExtra("listaC");
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_list);

        this.listView = (ListView) findViewById(R.id.lv_main);
        this.listView.setAdapter(new ContactoAdaptador(this, contactos));

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
