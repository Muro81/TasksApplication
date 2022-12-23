package llc.amplitudo.amplitudo_akademija

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.databinding.FragmentGetStartedBinding
import llc.amplitudo.amplitudo_akademija.databinding.FragmentRecyclerViewBinding
import timber.log.Timber

class RecyclerViewFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding: FragmentRecyclerViewBinding get() = _binding!!

    private lateinit var userRecyclerView: RecyclerView
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
                "dzenan__"
            ),
            User(
                "danilo__"
            ),
            User(
                "mirza__"
            ),
            User(
                "luka__"
            ),
            User(
                "milos__"
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