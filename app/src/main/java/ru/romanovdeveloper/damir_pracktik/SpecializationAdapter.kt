package ru.romanovdeveloper.damir_pracktik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SpecializationAdapter(private val specialization: List<Specialization>, private val onItemClick: (Specialization, Int) -> Unit) :
RecyclerView.Adapter<SpecializationAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.textViewSpecializationName)
        val tvCode: TextView = itemView.findViewById(R.id.textViewSpecializationCode)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.specialization_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val specialization = specialization.get(position)
        holder.tvName.append("${specialization.name}")
        holder.tvCode.append("${specialization.code}")
        holder.itemView.setOnClickListener{onItemClick(specialization, position)
        }
    }

    override fun getItemCount(): Int {
        return  specialization.count()
    }
}