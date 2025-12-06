package com.example.neuronexus.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.neuronexus.R
import com.example.neuronexus.databinding.ItemPatientScheduleAppointmentBinding
import com.example.neuronexus.models.ScheduleAppointment

class ScheduleAppointmentAdapter(private var appointmentList: List<ScheduleAppointment>) :
    RecyclerView.Adapter<ScheduleAppointmentAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(val binding: ItemPatientScheduleAppointmentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ItemPatientScheduleAppointmentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val appointment = appointmentList[position]

        holder.binding.tvName.text = appointment.doctorName
        holder.binding.tvSpec.text = appointment.specialty
        holder.binding.tvScheduleDate.text = "${appointment.time} ${appointment.date}"
        holder.binding.imgDoc.setImageResource(appointment.doctorImageRes)

        if (appointment.status == "UPCOMING") {
            holder.binding.btnCancel.text = "CANCEL"
            holder.binding.btnCancel.setTextColor(Color.parseColor("#FF4848")) // Red

            holder.binding.btnCancel.setOnClickListener {
                Toast.makeText(holder.itemView.context, "Cancelling appointment with ${appointment.doctorName}", Toast.LENGTH_SHORT).show()
            }

        } else {
            holder.binding.btnCancel.text = "RESCHEDULE"
            holder.binding.btnCancel.setTextColor(Color.parseColor("#407BFF")) // Blue (Your primary_blue)

            holder.binding.btnCancel.setOnClickListener {
                Toast.makeText(holder.itemView.context, "Rescheduling ${appointment.doctorName}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = appointmentList.size

    fun updateList(newList: List<ScheduleAppointment>) {
        appointmentList = newList
        notifyDataSetChanged()
    }
}