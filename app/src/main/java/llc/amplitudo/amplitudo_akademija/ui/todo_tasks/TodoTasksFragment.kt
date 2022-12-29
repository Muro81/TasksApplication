package llc.amplitudo.amplitudo_akademija.ui.todo_tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.R
import llc.amplitudo.amplitudo_akademija.databinding.FragmentTodoTasksBinding
import llc.amplitudo.amplitudo_akademija.ui.adapters.TaskAdapter
import timber.log.Timber

class TodoTasksFragment : Fragment() {

    private var _binding: FragmentTodoTasksBinding? = null
    private val binding: FragmentTodoTasksBinding get() = _binding!!

    private lateinit var tasksRecyclerView: RecyclerView
    private val viewModel: TodoTasksViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTaskRecycler()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

    /**
     * [See reason](https://stackoverflow.com/questions/66119231/is-it-necessary-to-set-viewbinding-to-null-in-fragments-ondestroy)
     */
    private fun clearBinding() {
        _binding = null
    }

    private fun initTaskRecycler() {
        val taskAdapter = TaskAdapter(tasks = viewModel.todoTasksList) { task ->
            Timber.d("Detected click!")
            val position = viewModel.todoTasksList.indexOf(task)
            viewModel.todoTasksList.remove(task)
            tasksRecyclerView.adapter?.notifyItemRemoved(position)
            Toast.makeText(
                this@TodoTasksFragment.context,
                getString(R.string.removed_task, task.id.toString()),
                Toast.LENGTH_SHORT
            ).show()
        }
        tasksRecyclerView = binding.tasksRecyclerView
        tasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TodoTasksFragment.context)
            adapter = taskAdapter
        }
    }
}