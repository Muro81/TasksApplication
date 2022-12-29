package llc.amplitudo.amplitudo_akademija.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import llc.amplitudo.amplitudo_akademija.databinding.FragmentAllTasksBinding

class AllTasksFragment : Fragment() {


    private var _binding: FragmentAllTasksBinding? = null
    private val binding: FragmentAllTasksBinding get() = _binding!!

    private val viewModel: AllTasksViewModel by viewModels()

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
}