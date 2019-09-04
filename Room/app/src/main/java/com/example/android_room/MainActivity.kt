package com.example.android_room

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_room.db.AppDatabase
import com.example.android_room.db.entity.MemoEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_memo.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onLongClick

class MainActivity : AppCompatActivity() {

    private var appDB: AppDatabase? = null

    private var memoList = listOf<MemoEntity>()

   lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDB = AppDatabase.getInstance(this)
        mainAdapter = MainAdapter(this, memoList)

        var r = Runnable {
            try {
                memoList = appDB?.MemoDao()?.getAll()!!
                mainAdapter = MainAdapter(this@MainActivity, memoList)
                mainAdapter.notifyDataSetChanged()

                Log.d("main", "run")
                main_rv.adapter = mainAdapter
                main_rv.layoutManager = LinearLayoutManager(this@MainActivity)
                main_rv.setHasFixedSize(true)
            } catch(e: Exception) {
                Log.d("tag", "Error $e")
            }
        }

        var deleteRunnable = Runnable {
            try {
                appDB?.MemoDao()?.deleteAll(memoList)
            } catch (e: Exception) {
                Log.d("main", "error $e")
            }
        }

        val thread = Thread(r)
        thread.start()

        main_memo_btn.onClick {
            Log.d("main", "click")
            goMemo()
        }

        main_delete_btn.onClick {
            val delThread = Thread(deleteRunnable)
            delThread.start()
        }
    }

    fun goMemo() {
        val intent = Intent(this, MemoActivity::class.java)
        startActivity(intent)
    }
}
