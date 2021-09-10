package com.example.todolist.model

data class Task(
    val title: String,
    val hour: String,
    val date: String,
    var id: Int = 0
)
