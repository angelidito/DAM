package com.mjpg.tiendasfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjpg.tiendasfragment.databinding.ConsultaBinding


class ConsultaFragment : Fragment() {

    private lateinit var mBinding: ConsultaBinding
    private  var mActivity: MainActivity?=null

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            mBinding = ConsultaBinding.inflate(inflater, container, false)
            return mBinding.root
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity=activity as MainActivity
        mBinding.fab.setOnClickListener{
            mActivity!!.anadir()
        }
    }



    }


