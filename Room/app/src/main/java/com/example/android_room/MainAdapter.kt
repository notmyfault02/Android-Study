package com.example.android_room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_room.db.entity.MemoEntity
import kotlinx.android.synthetic.main.item_memo.view.*

class MainAdapter(val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var items = ArrayList<MemoEntity>()

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
            with(view) {
                item_title_tv.text = memo.title
                item_content_tv.text = memo.content
                item_date_tv.text = memo.date
            }
        }
    }
}