package com.cheetah.test.testing.databinding

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cheetah.test.testing.R
import com.cheetah.test.testing.vo.PackagingTypes


/**
 * This class is responsible for providing the required action for the view.
 */

//@OpenForTesting
class FragmentBindingAdapters constructor(val fragment: Fragment) {

    @BindingAdapter(value = ["imageUrl"], requireAll = false)
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(fragment.context!!).load(url).into(imageView)
    }

    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
        val option = RequestOptions()
            .placeholder(R.drawable.loading_image)
            .error(R.drawable.error_image)
        Glide.with(view.context).setDefaultRequestOptions(option)
            .load(url).into(view)
    }





}
