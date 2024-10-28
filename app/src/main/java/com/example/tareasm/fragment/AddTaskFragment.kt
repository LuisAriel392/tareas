package com.example.tareasm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.tareasm.MainActivity
import com.example.tareasm.model.TaskManager
import com.example.tareasm.R

class AddTaskFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)

        val buttonAddTask = view.findViewById<Button>(R.id.buttonAddTask)
        val editTextTitle = view.findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = view.findViewById<EditText>(R.id.editTextDescription)

        buttonAddTask.setOnClickListener {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                TaskManager.addTask(title, description)
                (activity as MainActivity).updateUI()
                dismiss()
            } else {
                Toast.makeText(context, "Por favor ingrese el título y la descripción", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
