package com.example.todolist.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.databinding.ActivityAddTaskBinding
import com.example.todolist.extensions.format
import com.example.todolist.extensions.text
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class AddTaskActivity : AppCompatActivity(){

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.tilDate.editText?.setOnClickListener{
            val datepicker =  MaterialDatePicker.Builder.datePicker().build()
            datepicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offSet = timeZone.getOffset(Date().time)*-1
                binding.tilDate.text = Date(it + offSet).format()
            }
            datepicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
    }
}
