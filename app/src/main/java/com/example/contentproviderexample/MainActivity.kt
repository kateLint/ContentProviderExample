package com.example.contentproviderexample

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var CONTENT_URI: Uri = Uri.parse("content://com.demo.user.provider/users")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClickShowDetails(view: View?){
        var resultView = findViewById<TextView>(R.id.resus)

        // creating a cursor object of the
        // content URI
        // creating a cursor object of the
        // content URI
        val cursor: Cursor? = contentResolver.query(
            Uri.parse(CONTENT_URI.toString()),
            null,
            null,
            null,
            null
        )

        // iteration of the cursor
        // to print whole table
        // iteration of the cursor
        // to print whole table
        if (cursor!!.moveToFirst()) {
            val strBuild = StringBuilder()
            while (!cursor.isAfterLast) {

                var id =cursor.getColumnIndex("id")
                var name = cursor.getColumnIndex("name")

                strBuild.append(
                    """
                
                ${cursor!!.getString(id)}-
                """.trimIndent() + cursor.getString(
                      name
                    )
                )
                cursor.moveToNext()
            }
            resultView.text = strBuild
        } else {
            resultView.text = "No Records Found"
        }


    }
}