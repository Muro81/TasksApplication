package llc.amplitudo.amplitudo_akademija.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.data.local.models.Task
import llc.amplitudo.amplitudo_akademija.databinding.TodoItemBinding

class TaskAdapter(
    private val tasks: ArrayList<Task>,
    private val onTaskClick: ((task: Task) -> Unit)? = null
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: TodoItemBinding,
        private val isAllTasks: Boolean = false,
        private val onTaskClick: ((task: Task) -> Unit)? = null
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.apply {
                todoCheckBox.isChecked = task.isDone
                todoCheckBox.text = task.taskDescription
                todoCheckBox.isClickable = !task.isDone
                onTaskClick?.let { taskCallback ->
                    todoCheckBox.setOnClickListener {
                        taskCallback(task)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onTaskClick = onTaskClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(task = tasks[position])
    }

    override fun getItemCount() = tasks.size
}