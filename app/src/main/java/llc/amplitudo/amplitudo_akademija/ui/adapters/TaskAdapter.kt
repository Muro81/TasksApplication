package llc.amplitudo.amplitudo_akademija.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import llc.amplitudo.amplitudo_akademija.data.local.models.User
import llc.amplitudo.amplitudo_akademija.databinding.TodoItemBinding
import timber.log.Timber

class TaskAdapter(
    private val users: ArrayList<User>,
    private val onUserClick: (position: User) -> Unit
) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: TodoItemBinding,
        val onUserClick: (position: User) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.apply {
                Timber.d("URL of users image is: ${user.imageUrl}")
//                Glide.with(binding.root.context)
//                    .load(user.imageUrl)
//                    .into(userImage)
//                    .onLoadStarted(
//                        ContextCompat.getDrawable(
//                            binding.root.context,
//                            R.drawable.user_placeholder
//                        )
//                    )
                root.setOnClickListener {
                    onUserClick(user)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TodoItemBinding.inflate(
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