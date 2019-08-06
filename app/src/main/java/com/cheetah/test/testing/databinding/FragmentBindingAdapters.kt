package com.cheetah.test.testing.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cheetah.test.testing.R
import com.cheetah.test.testing.ui.adapter.OrderedItemsListAdapter
import com.cheetah.test.testing.vo.OrderItemsInformation


/**
 * This class is responsible for providing the required action for the view.
 *
 * @param fragment may be used for its context when binding info.
 */

class FragmentBindingAdapters constructor(private val fragment: Fragment) {


    @BindingAdapter("data")
    fun  setRecyclerViewProperties(recyclerView: RecyclerView, items: List<OrderItemsInformation>) {
            (recyclerView.adapter as OrderedItemsListAdapter).submitList(items)
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
