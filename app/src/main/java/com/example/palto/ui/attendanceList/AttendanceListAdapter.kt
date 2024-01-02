package com.example.palto.ui.attendanceList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.palto.databinding.FragmentAttendanceItemBinding
import com.example.palto.model.Card

/**
 *
 */
class AttendanceListAdapter :
    ListAdapter<Card, AttendanceListAdapter.ViewHolder>(CardDiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        return ViewHolder(
            FragmentAttendanceItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.cardId.text = item.uid.toHexString()
        //holder.contentView.text = item.content
    }

    inner class ViewHolder(
        binding: FragmentAttendanceItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val cardId: TextView = binding.cardId
        override fun toString(): String {
            return super.toString() + " '" + cardId.text + "'"
        }
    }
}

object CardDiffCallback : DiffUtil.ItemCallback<Card>() {
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }
}