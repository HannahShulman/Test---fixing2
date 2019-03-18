package com.cheetah.test.testing.databinding

import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

/**
 * This class is responsible for connecting the binding adapters to the requested fragment.
 */

class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {
    private val adapter = FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters() = adapter
}