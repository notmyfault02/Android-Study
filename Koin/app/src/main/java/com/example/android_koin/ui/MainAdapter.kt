package com.example.android_koin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_koin.Post
import com.example.android_koin.R
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter(val items: ArrayList<Post>, var context: Context?): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.run {
            items[position].let {
                bind(it)
            }
        }
    }

    override fun getItemCount() = items.size

    inner class MainViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(item: Post) {
            with(view) {
                tv_post_userId.text = item.userId.toString()
                tv_post_title.text = item.title
                tv_post_body.text = item.body
            }
        }
    }
}