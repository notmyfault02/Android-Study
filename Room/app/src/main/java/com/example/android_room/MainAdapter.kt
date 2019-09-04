package com.example.android_room

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_room.db.entity.MemoEntity
import kotlinx.android.synthetic.main.item_memo.view.*

class MainAdapter(val context: Context, var items: List<MemoEntity>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_memo, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }
    }

    inner class MainViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(memo: MemoEntity) {
            Log.d("adapter", "bind")
            with(view) {
                Log.d("adapter","${memo.title}")
                item_title_tv.text = memo.title
                item_date_tv.text = memo.date
            }
        }
    }
}