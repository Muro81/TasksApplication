package llc.amplitudo.amplitudo_akademija.ui.get_started

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import llc.amplitudo.amplitudo_akademija.databinding.FragmentGetStartedBinding
import llc.amplitudo.amplitudo_akademija.ui.dashboard.DashboardViewModel

class GetStartedFragment : Fragment() {

    private var _binding: FragmentGetStartedBinding? = null
    private val binding: FragmentGetStartedBinding get() = _binding!!

    private val viewModel: GetStartedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGetStartedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedButton.setOnClickListener { navigateToDashboardFragment() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }

    private fun navigateToDashboardFragment() {
        val action =
            GetStartedFragmentDirections.actionGetStartedFragmentToDashboardFragment(testArgument = 10)
        findNavController().navigate(action)
    }

    /**
     * [See reason](https://stackoverflow.com/questions/66119231/is-it-necessary-to-set-viewbinding-to-null-in-fragments-ondestroy)
     */
    private fun clearBinding() {
        _binding = null
    }
}