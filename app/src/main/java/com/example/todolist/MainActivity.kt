package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var btnDeleteDoneTodos: Button
    private lateinit var etTodoTitle: EditText
    private lateinit var btnAddTodo: Button
    private lateinit var rvTodoItems: RecyclerView
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems = findViewById<RecyclerView>(R.id.rvTodoItems);
        btnAddTodo = findViewById<Button>(R.id.btnAddTodo);
        etTodoTitle = findViewById<EditText>(R.id.etTodoTitle);
        btnDeleteDoneTodos = findViewById<Button>(R.id.btnDeleteDoneTodos);

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }
        btnDeleteDoneTodos.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}