package com.projects.enzoftware.keddit

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        if(savedInstanceState == null){

        }
    }

    fun changeFragment(f : Fragment, cleanStack : Boolean = false){
        val ft = supportFragmentManager.beginTransaction()
        if(cleanStack){
            clearBackStack()
        }
        ft.apply {
            setCustomAnimations(R.anim.abc_fade_in,R.anim.abc_fade_out, R.anim.abc_popup_enter, R.anim.abc_popup_exit)
            replace(R.id.activity_base_content, f)
            addToBackStack(null)
            commit()
        }
    }

    private fun clearBackStack() {
        val manager = supportFragmentManager
        if(manager.backStackEntryCount > 0){
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if(fragmentManager.backStackEntryCount > 1){
            fragmentManager.popBackStack()
        }else{
            finish()
        }
    }
}
