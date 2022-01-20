package com.mjpg.tiendasfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjpg.tiendasfragment.databinding.EditarBinding


class EditarFragment : Fragment() {

    private lateinit var mBinding:EditarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = EditarBinding.inflate(inflater, container, false)
        return mBinding.root
    }


}