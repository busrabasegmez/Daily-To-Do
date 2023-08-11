package com.example.dailytodo

import Adapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import com.example.dailytodo.databinding.ActivityEditTextBinding
import com.example.dailytodo.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var noteList = mutableListOf<Note>()

        val adapter = Adapter(this, R.layout.row_item, noteList)
        binding.itemsList.adapter = adapter
        var database = FirebaseDatabase.getInstance().reference.child("notes")

        val addButton = findViewById<FloatingActionButton>(R.id.add_fab)
        addButton.setOnClickListener {
            val intent = Intent(this, EditTextActivity::class.java)
            startActivity(intent)
        }

        val getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                noteList.clear()
                for (i in snapshot.children) {
                    val title = i.child("noteTitle").getValue(String::class.java) ?: ""
                    val date = i.child("dueDate").getValue(String::class.java) ?: ""
                    val details = i.child("noteDetail").getValue(String::class.java) ?: ""
                    val isDone = i.child("isDone").getValue(Boolean::class.java) ?: false

                    noteList.add(Note(title, date, details, isDone))
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
            }
        }

        database.addValueEventListener(getData)
    }
}
