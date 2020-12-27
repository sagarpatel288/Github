package com.omniwyse.github.ui.userprofile

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.common.baseconstants.PARCEL
import com.omniwyse.github.R
import com.omniwyse.github.base.BaseActivity
import com.omniwyse.github.databinding.UserDetailBinding
import com.omniwyse.github.viewmodel.SingleUserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<UserDetailBinding, SingleUserViewModel>(R.layout.user_detail) {

    override val viewModel: SingleUserViewModel by viewModel()
    private lateinit var dataBinding: UserDetailBinding

    override fun dataBinding(dataBinding: ViewDataBinding) {
        this.dataBinding = dataBinding as UserDetailBinding
    }

    override fun beforeObserver() {

    }

    override fun setObservers() {
        intent?.let {
            val userName: String = intent?.getStringExtra(PARCEL) ?: ""
            viewModel.getUserInfoByUsername(userName)
        }

        viewModel.pageUrl.observe(this, Observer {
            openInBrowser(it)
        })
    }

    private fun openInBrowser(pageUrl: String?) {
        pageUrl?.let {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
        }
    }

    object BindingLayoutUtils {
        @JvmStatic
        @BindingAdapter("avatar")
        fun loadAvatar(view: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(view.context)
                    .load(it).apply(RequestOptions().circleCrop())
                    .into(view)
            }
        }
    }
}