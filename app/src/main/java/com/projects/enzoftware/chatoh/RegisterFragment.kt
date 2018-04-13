package com.projects.enzoftware.chatoh

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by enzoftware on 4/12/18.
 */

class RegisterFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val viewRoot: View = inflater!!.inflate(R.layout.register,container,false)
        return viewRoot
    }
}