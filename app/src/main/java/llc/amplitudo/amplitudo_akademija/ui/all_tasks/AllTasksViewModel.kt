package llc.amplitudo.amplitudo_akademija.ui.all_tasks

import androidx.lifecycle.ViewModel
import llc.amplitudo.amplitudo_akademija.data.local.models.Task
import llc.amplitudo.amplitudo_akademija.data.local.repos.TaskRepository

class AllTasksViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    var tasksList: ArrayList<Task> = arrayListOf()
    private fun getTasks() {
        val retrievedTasks = taskRepository.getTasks()
        retrievedTasks.forEach { task ->
            tasksList.add(task)
        }
    }

    init {
        getTasks()
    }
}