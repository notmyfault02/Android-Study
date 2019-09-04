package com.example.android_room

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    val mainAdapter by lazy { MainAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(main_rv) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        main_memo_btn.onClick {
            Log.d("main", "click")
            goMemo()
        }
    }

    fun goMemo() {
        val intent = Intent(this, MemoActivity::class.java)
        startActivity(intent)
    }
}
