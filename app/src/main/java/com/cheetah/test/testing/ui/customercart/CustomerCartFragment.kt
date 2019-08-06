package com.cheetah.test.testing.ui.customercart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProviders
import com.cheetah.test.testing.AppExecutors
import com.cheetah.test.testing.R
import com.cheetah.test.testing.databinding.CustomerCartFragmentBinding
import com.cheetah.test.testing.databinding.FragmentDataBindingComponent
import com.cheetah.test.testing.koin.CustomerCartViewModelFactory
import com.cheetah.test.testing.ui.adapter.OrderedItemsListAdapter
import com.cheetah.test.testing.vo.Status
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.customer_cart_fragment.*
import org.koin.android.ext.android.inject


/**
 * This class is responsible for displaying information to user.
 */

class CustomerCartFragment : Fragment() , View.OnClickListener{

    companion object {
        fun newInstance() = CustomerCartFragment()
    }

    private  lateinit var myViewModel: CustomerCartViewModel

    private lateinit var binding: CustomerCartFragmentBinding

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    lateinit var adapter : OrderedItemsListAdapter

    private lateinit var  rvAdapter:OrderedItemsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater ,R.layout.customer_cart_fragment,container , false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val customerCartVMInst : CustomerCartViewModelFactory by inject()
        myViewModel = ViewModelProviders.of(this, customerCartVMInst).get(CustomerCartViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner

        setListeners()

        initRecyclerView()

       getInfo()
    }

    override fun onClick(v: View?) {
        when(v){
            searchBtn, loading_Failed_Btn->getInfo()
        }
    }

    private fun setListeners(){
        searchBtn.setOnClickListener(this)
        loading_Failed_Btn.setOnClickListener(this)
    }

    private fun getInfo() {

        myViewModel.getCustomerCart().observe(this, Observer {
            binding.loadingState = it.status

            //display snack bar on error
            if(it.status==Status.ERROR) {
                Snackbar.make(
                    binding.root, // Parent view
                    it.message?:"", // Message to show
                    Snackbar.LENGTH_LONG
                ).show()
            }
            binding.customerCart = it?.data

            //filtering should really be on sql queries, but due to the ways are done, and shrtage of time, this also achieves
            //the purpose, (but surely not recomended)
            val k =  it.data?.orderItemsInformation?.filter {
                it.product?.name?.toLowerCase()!!.contains(search_et.text.toString())
            }
            myViewModel.getOrderedItems().observe(this, Observer {
                Log.d("PRINT_LENGTH", it?.size.toString()?:"random message")

            })

            rvAdapter.submitList(k)
        })
    }


    private fun initRecyclerView() {
        val appExecutors : AppExecutors by inject()
        rvAdapter = OrderedItemsListAdapter(
            dataBindingComponent = dataBindingComponent,
            appExecutors = appExecutors
        )

        binding.orderedItemList.adapter = rvAdapter
        adapter = rvAdapter

    }

}
