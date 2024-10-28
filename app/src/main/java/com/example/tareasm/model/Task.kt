
package com.example.tareasm.model

data class Task(
    val id: Int,
    var title: String,
    var description: String,
    var completed: Boolean = false
)

object TaskManager {
    private val tasks = mutableListOf<Task>()
    private var idCounter = 0



    fun addTask(title: String, description: String): Task {
        val newTask = Task(idCounter++, title, description)
        tasks.add(newTask)
        return newTask
    }

    fun getTasks(): List<Task> {
        return tasks
    }

    fun completeTask(task: Task) {
        task.completed = true
    }

    fun deleteTask(task: Task) {
        tasks.remove(task)
    }
}