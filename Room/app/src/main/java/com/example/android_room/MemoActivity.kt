package com.example.android_room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.android_room.db.AppDatabase
import com.example.android_room.db.entity.MemoEntity
import kotlinx.android.synthetic.main.activity_memo.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import java.util.*

class MemoActivity : AppCompatActivity() {

    private var appDb: AppDatabase? = null

    val calendar = GregorianCalendar(Locale.KOREA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        appDb = AppDatabase.getInstance(this)

        val addRunnable = Runnable {
            val newMemo = MemoEntity()
            newMemo.title = memo_title_et.text.toString()
            newMemo.content = memo_content_et.text.toString()

            newMemo.date = "${calendar.get(GregorianCalendar.YEAR)}.${calendar.get(GregorianCalendar.MONTH)}.${calendar.get(GregorianCalendar.DATE)}"
            appDb?.MemoDao()?.insertAll(newMemo)
            Log.d("memo", "run")
        }

        memo_save_btn.onClick {
            val addThread = Thread(addRunnable)
            addThread.start()
            startActivity<MainActivity>()
            finish()
        }
    }
}
