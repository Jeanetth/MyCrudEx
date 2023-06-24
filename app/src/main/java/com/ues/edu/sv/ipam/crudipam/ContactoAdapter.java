package com.ues.edu.sv.ipam.crudipam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        holder.telefonoTextView.setText(contacto.getTelefono());
    }

    @Override
    public int getItemCount() {
        return contactosList.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView telefonoTextView;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            telefonoTextView = itemView.findViewById(R.id.telefonoTextView);
        }
    }
}
