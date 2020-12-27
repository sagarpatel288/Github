package com.omniwyse.github.ui.githubuserlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.omniwyse.github.R
import com.omniwyse.github.pojos.GitHubUser

class UsersListAdapter(private val listener: UsersListAdapterInteraction) :
    PagedListAdapter<GitHubUser, UsersListAdapter.UsersListViewHolder>(usersDiffCallback) {

    lateinit var context: Context

    interface UsersListAdapterInteraction {
        fun onUserItemClick(gitHubUser: GitHubUser)
    }

    inner class UsersListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userItem: ConstraintLayout = itemView.findViewById(R.id.v_lay_cl_content_container)
        val userImage: ImageView = itemView.findViewById(R.id.v_civ)
        val userName: AppCompatTextView = itemView.findViewById(R.id.v_tv_title)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        val gitHubUser = getItem(position)
        gitHubUser?.let {
            Glide.with(context)
                .load(it.avatarUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.userImage)

            holder.userName.text = it.login

            holder.userItem.setOnClickListener {
                listener.onUserItemClick(gitHubUser)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.item_iv_title, parent, false)
        return UsersListViewHolder(view)
    }

    companion object {
        val usersDiffCallback = object : DiffUtil.ItemCallback<GitHubUser>() {
            override fun areItemsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: GitHubUser, newItem: GitHubUser): Boolean {
                return oldItem == newItem
            }
        }
    }
}