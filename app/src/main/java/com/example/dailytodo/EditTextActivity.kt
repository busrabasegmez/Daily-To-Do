package com.example.dailytodo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dailytodo.databinding.ActivityEditTextBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EditTextActivity : AppCompatActivity() {

    lateinit var binding:ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var database = FirebaseDatabase.getInstance().reference

        binding.createNoteButton.setOnClickListener {
            var noteTitle = binding.noteTitleEditView.text.toString()
            var dueDate = binding.dateEditText.text.toString()
            var noteDetails = binding.noteDetailsEditText.text.toString()

//            database.setValue(Note(noteTitle,dueDate,noteDetails))
            database.child(noteTitle.toString()).setValue(Note(noteTitle,dueDate,noteDetails))
        }




    }
}