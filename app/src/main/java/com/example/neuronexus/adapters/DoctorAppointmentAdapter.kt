package com.example.neuronexus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neuronexus.databinding.ItemDoctorAppointmentCardBinding
import com.example.neuronexus.models.DoctorAppointmentItem

class DoctorAppointmentAdapter(private val appointmentList: List<DoctorAppointmentItem>) :
    RecyclerView.Adapter<DoctorAppointmentAdapter.AppointmentViewHolder>() {

    class AppointmentViewHolder(val binding: ItemDoctorAppointmentCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val binding = ItemDoctorAppointmentCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AppointmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment = appointmentList[position]

        holder.binding.tvPatientName.text = appointment.patientName

        holder.binding.imgPatient.setImageResource(appointment.imageResId)

        holder.binding.btnAction.text = "Personal Visit - ${appointment.time}"

        holder.itemView.setOnClickListener {
            // logic to open patient details later
        }
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }
}