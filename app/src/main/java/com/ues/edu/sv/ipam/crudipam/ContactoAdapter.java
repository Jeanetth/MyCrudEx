package com.ues.edu.sv.ipam.crudipam;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ues.edu.sv.ipam.crudipam.sqlLite.Contactos;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {
    private List<Contactos> contactosList;

    public ContactoAdapter(List<Contactos> contactosList) {
        this.contactosList = contactosList;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contactos contacto = contactosList.get(position);
        holder.nombreTextView.setText(contacto.getNombre());

        holder.modificarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes obtener el objeto Contactos correspondiente a este elemento de la lista
                Contactos contactoSeleccionado = contactosList.get(holder.getAdapterPosition());


                // Aquí puedes crear un Intent para abrir la nueva actividad (layout) y pasar los datos del contacto
                Intent intent = new Intent(v.getContext(), ModificarContactos.class);

                intent.putExtra("contactoSeleccionado", contactoSeleccionado);
                // Puedes agregar más datos del contacto si es necesario

                v.getContext().startActivity(intent); // Inicia la nueva actividad
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactosList.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        Button modificarButton;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            modificarButton = itemView.findViewById(R.id.modificar_button);
        }
    }
}
