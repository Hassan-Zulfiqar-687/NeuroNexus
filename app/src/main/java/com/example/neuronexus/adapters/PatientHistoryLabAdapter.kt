package com.example.neuronexus.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neuronexus.R
import com.example.neuronexus.databinding.ItemHistoryLabBinding
import com.example.neuronexus.models.HistoryLabItem

class PatientHistoryLabAdapter(
    private val labList: List<HistoryLabItem>,
    private val onReportClick: (HistoryLabItem) -> Unit
) : RecyclerView.Adapter<PatientHistoryLabAdapter.LabViewHolder>() {

    class LabViewHolder(val binding: ItemHistoryLabBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabViewHolder {
        val binding = ItemHistoryLabBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LabViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LabViewHolder, position: Int) {
        val item = labList[position]

        holder.binding.tvTestName.text = item.testName
        holder.binding.tvLabName.text = item.labName
        holder.binding.tvDate.text = item.date

        holder.binding.btnViewReport.visibility = android.view.View.VISIBLE
        holder.binding.divider.visibility = android.view.View.VISIBLE

        holder.binding.chipStatus.text = item.status

        if (item.status == "Cancelled") {
            // 1. Red Style
            holder.binding.chipStatus.setTextColor(Color.parseColor("#C62828")) // Dark Red
            holder.binding.chipStatus.background.setTint(Color.parseColor("#FFEBEE")) // Light Red

            // 2. DISABLE Button (Gray out)
            holder.binding.btnViewReport.isEnabled = false
            holder.binding.btnViewReport.setTextColor(Color.parseColor("#BDBDBD")) // Gray
            holder.binding.btnViewReport.setOnClickListener(null)

        } else {
            // 1. Green Style
            holder.binding.chipStatus.setTextColor(Color.parseColor("#2E7D32")) // Dark Green
            holder.binding.chipStatus.background.setTint(Color.parseColor("#E8F5E9")) // Light Green

            // 2. ENABLE Button (Blue)
            holder.binding.btnViewReport.isEnabled = true
            holder.binding.btnViewReport.setTextColor(holder.itemView.context.getColor(R.color.primary_blue))

            holder.binding.btnViewReport.setOnClickListener {
                onReportClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return labList.size
    }
}