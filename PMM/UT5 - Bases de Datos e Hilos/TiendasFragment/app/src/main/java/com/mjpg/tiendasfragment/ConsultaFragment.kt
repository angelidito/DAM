package com.mjpg.tiendasfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mjpg.tiendasfragment.databinding.ConsultaBinding


class ConsultaFragment : Fragment() {

    private lateinit var mBinding: ConsultaBinding


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            mBinding = ConsultaBinding.inflate(inflater, container, false)
            return mBinding.root
        }
    }


