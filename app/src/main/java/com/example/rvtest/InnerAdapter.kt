package com.example.rvtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class InnerAdapter(private val context: Context, private val list: List<Int>, private val posInMain: Int): RecyclerView.Adapter<InnerAdapter.InnerViewHolder>() {

    companion object {
        private const val TAG = "InnerAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerViewHolder {
        Log.d(TAG, "InnerAdapter OnCreateViewHolder")
       val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_row_inner, parent, false)
       return InnerViewHolder(view)
    }

    override fun onBindViewHolder(holder: InnerViewHolder, position: Int) {
        Log.d(TAG, "InnerAdapter OnBindViewHolder for pos $position")
        holder.textView.text = "${ItemList.list[list[position]]},$posInMain"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onViewAttachedToWindow(holder: InnerViewHolder) {
        Log.d(TAG, "View Attached to Window in InnerAdapter ${holder.adapterPosition} and pos in main is $posInMain")
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: InnerViewHolder) {
        Log.d(TAG, "View Detached to Window in InnerAdapter ${holder.adapterPosition} and pos in main is $posInMain")
        super.onViewDetachedFromWindow(holder)
    }

    override fun onFailedToRecycleView(holder: InnerViewHolder): Boolean {
        Log.d(TAG, "Failed to recycle in InnerAdapter ${holder.adapterPosition} and pos in main is $posInMain")
        return super.onFailedToRecycleView(holder)
    }

    override fun onViewRecycled(holder: InnerViewHolder) {
        Log.d(TAG, "View recycled in InnerAdapter ${holder.adapterPosition} and pos in main is $posInMain")
        super.onViewRecycled(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        Log.d(TAG, "View Detached from RV in InnerAdapter and pos in main is $posInMain")
        super.onDetachedFromRecyclerView(recyclerView)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        Log.d(TAG, "View Detached from RV in InnerAdapter and pos in main is $posInMain")
        super.onAttachedToRecyclerView(recyclerView)
    }


    class InnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)

    }
}