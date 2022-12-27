package llc.amplitudo.amplitudo_akademija.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import llc.amplitudo.amplitudo_akademija.R
import llc.amplitudo.amplitudo_akademija.data.local.models.User
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
            binding.apply {
                username.text = user.username
                Timber.d("URL of users image is: ${user.imageUrl}")
                Glide.with(binding.root.context)
                    .load(user.imageUrl)
                    .into(userImage)
                    .onLoadStarted(
                        ContextCompat.getDrawable(
                            binding.root.context,
                            R.drawable.user_placeholder
                        )
                    )
                root.setOnClickListener {
                    onUserClick(user)
                }
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