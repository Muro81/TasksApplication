package llc.amplitudo.amplitudo_akademija.ui.all_tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.R
import llc.amplitudo.amplitudo_akademija.databinding.FragmentAllTasksBinding
import llc.amplitudo.amplitudo_akademija.ui.adapters.TaskAdapter
import timber.log.Timber

class AllTasksFragment : Fragment() {

    private var _binding: FragmentAllTasksBinding? = null
    private val binding: FragmentAllTasksBinding get() = _binding!!

    private val viewModel: AllTasksViewModel by viewModels()
    private lateinit var tasksRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTaskRecycler()
        binding.fab.setOnClickListener {
            navigateToAddTask()
        }
        /**
         * Example how to use Glide!
         */
//        Glide.with(binding.root.context)
//            .load(user.imageUrl)
//            .into(userImage)
//            .onLoadStarted(
//                ContextCompat.getDrawable(
//                    binding.root.context,
//                    R.drawable.user_placeholder
//                )
//            )
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
        val taskAdapter = TaskAdapter(tasks = viewModel.tasksList, isAllTasks = true)
        tasksRecyclerView = binding.tasksRecyclerView
        tasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@AllTasksFragment.context)
            adapter = taskAdapter
        }
    }

    private fun navigateToAddTask() {
        val action = AllTasksFragmentDirections.actionFragmentAllTasksToAddTaskFragment()
        findNavController().navigate(action)
    }
}