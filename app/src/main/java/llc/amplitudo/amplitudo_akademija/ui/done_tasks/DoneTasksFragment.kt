package llc.amplitudo.amplitudo_akademija.ui.done_tasks

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
import llc.amplitudo.amplitudo_akademija.databinding.FragmentDoneTasksBinding
import llc.amplitudo.amplitudo_akademija.ui.adapters.TaskAdapter
import timber.log.Timber

class DoneTasksFragment : Fragment() {

    private var _binding: FragmentDoneTasksBinding? = null
    private val binding: FragmentDoneTasksBinding get() = _binding!!

    private val viewModel: DoneTasksViewModel by viewModels()
    private lateinit var tasksRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneTasksBinding.inflate(inflater, container, false)
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
        val taskAdapter = TaskAdapter(tasks = viewModel.doneTasksList)
        tasksRecyclerView = binding.tasksRecyclerView
        tasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@DoneTasksFragment.context)
            adapter = taskAdapter
        }
    }
}