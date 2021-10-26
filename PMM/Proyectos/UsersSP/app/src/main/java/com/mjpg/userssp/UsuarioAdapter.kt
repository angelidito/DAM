package com.mjpg.userssp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mjpg.userssp.databinding.ItemUsersAltBinding


class UsuarioAdapter(private val usuarios: List<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemUsersAltBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_users_alt, parent)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = usuarios.get(position)
        holder.binding.tvName.text = usuario.personalizado()
    }

    override fun getItemCount(): Int = usuarios.size

}