package com.example.neuronexus.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neuronexus.databinding.ItemHistoryConsultationBinding
import com.example.neuronexus.models.HistoryConsultationItem

class PatientHistoryConsultationAdapter(
    private val consultationList: List<HistoryConsultationItem>,
    private val onPrescriptionClick: (HistoryConsultationItem) -> Unit
) : RecyclerView.Adapter<PatientHistoryConsultationAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: ItemHistoryConsultationBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryConsultationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = consultationList[position]

        holder.binding.tvDoctorName.text = item.doctorName
        holder.binding.tvSpecialty.text = item.specialty
        holder.binding.tvDate.text = item.date
        holder.binding.tvTime.text = item.time
        holder.binding.imgDoctor.setImageResource(item.imageResId)

        holder.binding.chipStatus.text = item.status

        holder.binding.btnViewPrescription.visibility = android.view.View.VISIBLE
        holder.binding.divider.visibility = android.view.View.VISIBLE

        if (item.status == "Cancelled") {
            // 1. Red Status Pill
            holder.binding.chipStatus.setTextColor(Color.parseColor("#C62828"))
            holder.binding.chipStatus.background.setTint(Color.parseColor("#FFEBEE"))

            // 2. DISABLE the Prescription Button
            holder.binding.btnViewPrescription.isEnabled = false
            holder.binding.btnViewPrescription.setTextColor(Color.parseColor("#BDBDBD")) // Gray Color
            holder.binding.btnViewPrescription.setOnClickListener(null) // Remove click action

        } else {
            // 1. Green Status Pill (Default)
            holder.binding.chipStatus.setTextColor(Color.parseColor("#2E7D32"))
            holder.binding.chipStatus.background.setTint(Color.parseColor("#E8F5E9"))

            // 2. ENABLE the Prescription Button
            holder.binding.btnViewPrescription.isEnabled = true
            holder.binding.btnViewPrescription.setTextColor(holder.itemView.context.getColor(com.example.neuronexus.R.color.primary_blue)) // Reset to Blue

            holder.binding.btnViewPrescription.setOnClickListener {
                onPrescriptionClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return consultationList.size
    }
}