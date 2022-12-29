package llc.amplitudo.amplitudo_akademija.ui.todo_tasks

import androidx.lifecycle.ViewModel
import llc.amplitudo.amplitudo_akademija.data.local.models.Task
import llc.amplitudo.amplitudo_akademija.data.local.repos.TaskRepository

class TodoTasksViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    var todoTasksList: ArrayList<Task> = arrayListOf()
    private fun getTodosList() {
        val retrievedTasks = taskRepository.getTasks().filter { task -> !task.isDone }
        retrievedTasks.forEach { task ->
            todoTasksList.add(task)
        }
    }

    init {
        getTodosList()
    }

}