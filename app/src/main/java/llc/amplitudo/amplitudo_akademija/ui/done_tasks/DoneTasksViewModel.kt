package llc.amplitudo.amplitudo_akademija.ui.done_tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import llc.amplitudo.amplitudo_akademija.core.utils.NetworkResponse
import llc.amplitudo.amplitudo_akademija.data.remote.models.Task
import llc.amplitudo.amplitudo_akademija.data.remote.repos.TaskRepository
import timber.log.Timber

class DoneTasksViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    private val _donetasksSharedFlow = MutableSharedFlow<List<Task>>()

    val donetasksSharedFlow: SharedFlow<List<Task>> = _donetasksSharedFlow

    private val _errorMessageChannel = Channel<String>()
    val errorMessaggeFlow: Flow<String> = _errorMessageChannel.receiveAsFlow()


    fun getDoneTasks() {
        viewModelScope.launch {
            taskRepository.getTasks().collectLatest { networkResponse ->
                val data = networkResponse.data?.filter { task ->
                    task.isCompleted == true
                }
                when (networkResponse) {
                    is NetworkResponse.Success -> {
                        data?.let { tasks ->
                            _donetasksSharedFlow.emit(tasks)
                        }
                    }
                    is NetworkResponse.Error -> {
                        networkResponse.message?.let { message ->
                            _errorMessageChannel.send(message)
                        }
                    }
                    is NetworkResponse.Loading -> {

                        Timber.d("Presenting loader to user...")
                    }

                }
            }
        }
    }
}

