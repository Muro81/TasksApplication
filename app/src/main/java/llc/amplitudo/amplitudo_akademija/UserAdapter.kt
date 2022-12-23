package llc.amplitudo.amplitudo_akademija

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.databinding.RecyclerItemBinding
import timber.log.Timber

class UserAdapter(
    private val users: ArrayList<User>,
    private val onUserClick: (position: User) -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: RecyclerItemBinding,
        val onUserClick: (position: User) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.username.text = user.username
            binding.root.setOnClickListener {
                onUserClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onUserClick = onUserClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user = users[position])
    }

    override fun getItemCount() = users.size
}