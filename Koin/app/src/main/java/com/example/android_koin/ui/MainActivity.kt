package com.example.android_koin.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_koin.Post
import com.example.android_koin.R
import com.example.android_koin.UserDataList
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), UserDataList {

    private val presenter: MainPresenter<UserDataList> by inject()

    val mainAdapter by lazy { MainAdapter(ArrayList(), this) }

    var items = ArrayList<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.userData = this
        Log.d("main", "ok")

        btn_refresh.setOnClickListener( {
            Log.d("main", "click")
            showPosts()
        })

        rv_main.apply {
            rv_main.layoutManager = LinearLayoutManager(this@MainActivity)
            rv_main.setHasFixedSize(true)
            rv_main.adapter = mainAdapter
        }
    }

    override fun onDataLoaded(response: ArrayList<Post>) {
        mainAdapter.apply {
            items.clear()
            items.addAll(response)
            Log.d("Activity", response[1].body)
            notifyDataSetChanged()
        }
    }

    override fun onDataFailed() {
        mainAdapter.apply {
            items.clear()
            notifyDataSetChanged()
        }
    }

    override fun showPosts() {
        presenter.getJsonPosts(items)
    }
}
