package llc.amplitudo.amplitudo_akademija.ui.todo_tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import llc.amplitudo.amplitudo_akademija.core.utils.NetworkResponse
import llc.amplitudo.amplitudo_akademija.data.remote.models.Task
import llc.amplitudo.amplitudo_akademija.data.remote.repos.TaskRepository
import timber.log.Timber

class TodoTasksViewModel : ViewModel() {

    private val taskRepository = TaskRepository()

    private val _toDoTasksSharedFlow = MutableSharedFlow<List<Task>>()

    val toDoTasksSharedFlow : SharedFlow<List<Task>> = _toDoTasksSharedFlow

    private val _errorMessageChannel = Channel<String>()
    val errorMessageFlow : Flow<String> = _errorMessageChannel.receiveAsFlow()

    private val _loadingMessageChannel = Channel<Boolean>()
    val loadingMessageFlow : Flow<Boolean> = _loadingMessageChannel.receiveAsFlow()

    fun getTodoTasks(){
        viewModelScope.launch {
            taskRepository.getTasks().collectLatest { networkResponse ->
                val data = networkResponse.data
                when (networkResponse){
                    is NetworkResponse.Success -> {
                        data?.filter { task ->
                            task.isCompleted == false
                        }?.let { tasks ->
                            _toDoTasksSharedFlow.emit(tasks)
                        }
                        _loadingMessageChannel.send(false)
                    }
                    is NetworkResponse.Error -> {
                        networkResponse.message?.let { message ->
                            _errorMessageChannel.send(message)
                        }
                        _loadingMessageChannel.send(false)
                    }
                    is NetworkResponse.Loading -> {
                        _loadingMessageChannel.send(true)
                        Timber.d("Presenting loader to user...")
                    }
                }
            }
        }
    }


}