package llc.amplitudo.amplitudo_akademija.ui.todo_tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.data.local.models.User
import llc.amplitudo.amplitudo_akademija.databinding.FragmentTodoTasksBinding
import llc.amplitudo.amplitudo_akademija.ui.adapters.TaskAdapter
import timber.log.Timber

class TodoTasksFragment : Fragment() {

    private var _binding: FragmentTodoTasksBinding? = null
    private val binding: FragmentTodoTasksBinding get() = _binding!!

    private lateinit var userRecyclerView: RecyclerView
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
        val users = arrayListOf(
            User(
                username = "dzenan__",
                imageUrl = "https://cdn.pixabay.com/photo/2013/07/13/10/07/man-156584__340.png"
            ),
            User(
                username = "danilo__",
                imageUrl = "https://cdn.pixabay.com/photo/2013/07/13/10/07/man-156584__340.png"
            ),
            User(
                username = "mirza__",
                imageUrl = "https://cdn.pixabay.com/photo/2013/07/13/10/07/man-156584__340.png"
            ),
            User(
                username = "luka__",
                imageUrl = "https://cdn.pixabay.com/photo/2013/07/13/10/07/man-156584__340.png"
            ),
            User(
                username = "milos__",
                imageUrl = "https://cdn.pixabay.com/photo/2013/07/13/10/07/man-156584__340.png"
            )
        )
        val userAdapter = TaskAdapter(users = users) { user ->
            Timber.d("Detected click!")
            val position = users.indexOf(user)
            users.remove(user)
            userRecyclerView.adapter?.notifyItemRemoved(position)
        }
        userRecyclerView = binding.taskRecycler
        userRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TodoTasksFragment.context)
            adapter = userAdapter
        }
    }
}