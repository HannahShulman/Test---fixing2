package com.cheetah.test.testing.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.cheetah.test.testing.AppExecutors
import com.cheetah.test.testing.R
import com.cheetah.test.testing.databinding.SingleOrederedItemInformationLayoutBinding
import com.cheetah.test.testing.vo.OrderItemsInformation
import com.cheetah.test.testing.vo.PackagingTypes

/**
 * This class is responsible for implementing [DataBoundListAdapter] with specific types, used for the OrderItem
 */
class OrderedItemsListAdapter(
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors
) : DataBoundListAdapter<OrderItemsInformation, SingleOrederedItemInformationLayoutBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<OrderItemsInformation>() {
        override fun areItemsTheSame(oldItem: OrderItemsInformation, newItem: OrderItemsInformation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderItemsInformation, newItem: OrderItemsInformation): Boolean {
            return oldItem == newItem
        }
    }
) {

    override fun createBinding(parent: ViewGroup): SingleOrederedItemInformationLayoutBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.single_oredered_item_information_layout,
        parent,
        false,
        dataBindingComponent
    )

    override fun bind(binding: SingleOrederedItemInformationLayoutBinding, item: OrderItemsInformation) {
        binding.itemInfo = item
        binding.singlePrice =when(item.packagingType){
            PackagingTypes.CASE.packageType->  item.product?.casePrice
            PackagingTypes.UNIT.packageType-> item.product?.unitPrice
            PackagingTypes.WEIGHT.packageType-> item.product?.weightPrice
            else-> item.product?.weightPrice
        }

        binding.imageUrl =when(item.packagingType){
            PackagingTypes.CASE.packageType->  item.product?.packPhotoFile
            PackagingTypes.UNIT.packageType-> item.product?.unitPhotoFilename
            PackagingTypes.WEIGHT.packageType-> item.product?.weightPhotoFilename
            else-> item.product?.unitPhotoFilename
        }
    }
}
