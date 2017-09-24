package com.alvaropedrajas.agendaejercicio;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactoAdaptador extends BaseAdapter{

    private Context context;
    private ArrayList<Contacto> contactos;


    public ContactoAdaptador(Context context, ArrayList<Contacto> contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    @Override
    public int getCount() {
        return this.contactos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contactos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_contact, parent, false);
        }

        TextView nombre = (TextView) rowView.findViewById(R.id.tv_name);
        TextView telefono = (TextView) rowView.findViewById(R.id.tv_phone);
        TextView mail = (TextView) rowView.findViewById(R.id.tv_mail);
        ImageView img = (ImageView) rowView.findViewById(R.drawable.ic_action_name);

        Contacto contacto = this.contactos.get(position);
        nombre.setText(contacto.getNombre().toString());
        telefono.setText(contacto.getTelefono().toString());
        mail.setText(contacto.getMail().toString());

        return rowView;
    }


}
