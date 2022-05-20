package gt.edu.galileo.red.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gt.edu.galileo.red.R
import gt.edu.galileo.red.model.Contacto

class ContactoAdapter(val contactos: ArrayList<Contacto>) : RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {
    class ContactoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById<TextView>(R.id.nombre_text)
        val telefono = view.findViewById<TextView>(R.id.telefono_text)
        fun bind(contacto :Contacto) {
            nombre.text = contacto.nombre
            telefono.text = contacto.telefono
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val li = LayoutInflater.from(parent.context)
        return ContactoViewHolder(li.inflate(R.layout.item_contacto_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        holder.bind(contactos[position])
    }

    override fun getItemCount() = contactos.size

    fun loadNewData(newContactos: List<Contacto>) {
        contactos.clear()
        contactos.addAll(newContactos)
        notifyDataSetChanged()
    }
}