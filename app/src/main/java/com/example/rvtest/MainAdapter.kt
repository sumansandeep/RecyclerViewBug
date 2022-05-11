package com.example.rvtest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val list: List<List<Int>>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    
    companion object {
        private const val TAG = "MainAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        Log.d(TAG, "MainAdapter OnCreateViewHolder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_row_main, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        Log.d("", "MainAdapter OnBindViewHolder for pos $position")
        holder.titleText.text = position.toString()
        Log.d(TAG, "Inner adapter at pos $position is ${holder.recyclerView.adapter == null}")
        holder.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = InnerAdapter(context, list[position], position)
            (layoutManager as? LinearLayoutManager)?.recycleChildrenOnDetach = true
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        Log.d(TAG, "View Attached to Window in MainAdapter ${holder.adapterPosition}")
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        Log.d(TAG, "View Detached from Window in MainAdapter ${holder.adapterPosition}")
        super.onViewDetachedFromWindow(holder)
    }

    override fun onFailedToRecycleView(holder: MainViewHolder): Boolean {
        Log.d(TAG, "Failed to recycle view ${holder.adapterPosition}")
        return super.onFailedToRecycleView(holder)
    }

    override fun onViewRecycled(holder: MainViewHolder) {
        Log.d(TAG, "View Recycled ${holder.adapterPosition}")
        super.onViewRecycled(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        Log.d(TAG, "View Detached from RV in MainAdapter")
        super.onDetachedFromRecyclerView(recyclerView)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        Log.d(TAG, "View Attached to RV in Main Adapter")
        super.onAttachedToRecyclerView(recyclerView)
    }

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.title_text)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.inner_rv)

    }
}