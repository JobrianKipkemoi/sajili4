package com.example.sajili3.adapters

import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sajili3.R
import com.example.sajili3.models.CourseUnit

class CourseUnitAdapter(private val courseUnits: List<CourseUnit>) : RecyclerView.Adapter<CourseUnitAdapter.CourseUnitViewHolder>() {

    class CourseUnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val unitCodeTextView: TextView = itemView.findViewById(R.id.txtUnitCode)
        val unitTitleTextView: TextView = itemView.findViewById(R.id.txtUnitTitle)
        val lecturerTextView: TextView = itemView.findViewById(R.id.txtLecturer)
        val availabilityTextView: TextView = itemView.findViewById(R.id.txtAvailable)
        val linearMainLayout: LinearLayout = itemView.findViewById(R.id.linearMain)
        val buttonSelect: ImageButton = itemView.findViewById(R.id.btnSelect)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseUnitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_unit_view, parent, false)
        return CourseUnitViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseUnitViewHolder, position: Int) {
        val currentUnit = courseUnits[position]
        holder.unitCodeTextView.text = currentUnit.UnitCode
        holder.unitTitleTextView.text = currentUnit.UnitTitle
        holder.lecturerTextView.text = currentUnit.Lecturer
        holder.availabilityTextView.text = if (currentUnit.IsAvailable) "Available" else "Not Available"

        if (currentUnit.isSelected) {
            holder.linearMainLayout.setBackgroundResource(R.drawable.selected_item_bg)
            holder.buttonSelect.setImageResource(R.drawable.baseline_check_circle_outline_24)
        } else {
            holder.linearMainLayout.setBackgroundResource(R.drawable.window_bg)
            holder.buttonSelect.setImageResource(R.drawable.baseline_add_circle_outline_24) // Unselected icon
        }

        holder.itemView.setOnClickListener {
            currentUnit.isSelected = !currentUnit.isSelected

            if (currentUnit.isSelected) {
                holder.linearMainLayout.setBackgroundResource(R.drawable.selected_item_bg)
                holder.buttonSelect.setImageResource(R.drawable.baseline_check_circle_outline_24)
            } else {
                holder.linearMainLayout.setBackgroundResource(R.drawable.window_bg)
                holder.buttonSelect.setImageResource(R.drawable.baseline_add_circle_outline_24)
            }
        }

    }

    override fun getItemCount(): Int {
        return courseUnits.size
    }


}
