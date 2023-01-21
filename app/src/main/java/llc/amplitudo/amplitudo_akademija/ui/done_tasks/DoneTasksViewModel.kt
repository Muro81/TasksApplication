package llc.amplitudo.amplitudo_akademija.ui.done_tasks

import androidx.lifecycle.ViewModel
import llc.amplitudo.amplitudo_akademija.data.remote.models.Task
import llc.amplitudo.amplitudo_akademija.data.remote.repos.TaskRepository

class DoneTasksViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    var doneTasksList: ArrayList<Task> = arrayListOf()
    private fun getDoneTasks() {
//        val retrievedTasks = taskRepository.getTasks().filter { task -> task.isDone }
//        retrievedTasks.forEach { task ->
//            doneTasksList.add(task)
//        }
    }

    init {
        getDoneTasks()
    }
}