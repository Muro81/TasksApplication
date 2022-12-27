package llc.amplitudo.amplitudo_akademija.ui.recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.data.local.models.User
import llc.amplitudo.amplitudo_akademija.databinding.FragmentRecyclerViewBinding
import llc.amplitudo.amplitudo_akademija.ui.dashboard.DashboardViewModel
import timber.log.Timber

class RecyclerViewFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding: FragmentRecyclerViewBinding get() = _binding!!

    private lateinit var userRecyclerView: RecyclerView
    private val viewModel: RecyclerViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
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
        val userAdapter = UserAdapter(users = users) { user ->
            Timber.d("Detected click!")
            val position = users.indexOf(user)
            users.remove(user)
            userRecyclerView.adapter?.notifyItemRemoved(position)
        }
        userRecyclerView = binding.userRecycler
        userRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewFragment.context)
            adapter = userAdapter
        }
    }
}