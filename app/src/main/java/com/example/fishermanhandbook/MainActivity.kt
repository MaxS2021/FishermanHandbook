package com.example.fishermanhandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fishermanhandbook.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //bind.navView.setNavigationItemSelectedListener(this)

        bind.apply {
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.idFish -> {Toast.makeText(this@MainActivity, "Fish", Toast.LENGTH_SHORT).show()}
                    R.id.idNazh -> {Toast.makeText(this@MainActivity, "Naxhivki", Toast.LENGTH_SHORT).show()}
                    R.id.idSnasti -> {Toast.makeText(this@MainActivity, "Snasti", Toast.LENGTH_SHORT).show()}
                    R.id.idHist -> {Toast.makeText(this@MainActivity, "Histopy", Toast.LENGTH_SHORT).show()}
                }

                drawer.closeDrawer(GravityCompat.START)
                true
            }

        }

        var list = ArrayList<ListItem>()
        list.add(ListItem(R.drawable.som, "Сом", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))
        list.add(ListItem(R.drawable.shuka, "Щука", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))
        list.add(ListItem(R.drawable.karas, "Карась", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))
        list.add(ListItem(R.drawable.tunec, "Тунец", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))


        val rcV = findViewById<RecyclerView>(R.id.rcView)
        rcV.hasFixedSize()
        rcV.layoutManager = LinearLayoutManager(this)
        rcV.adapter = MyAdepter(list, this)





    }

//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.idFish -> {Toast.makeText(this@MainActivity, "Fish", Toast.LENGTH_SHORT).show()}
//            R.id.idNazh -> {Toast.makeText(this@MainActivity, "Naxhivki", Toast.LENGTH_SHORT).show()}
//            R.id.idSnasti -> {Toast.makeText(this@MainActivity, "Snasti", Toast.LENGTH_SHORT).show()}
//            R.id.idHist -> {Toast.makeText(this@MainActivity, "Histopy", Toast.LENGTH_SHORT).show()}
//        }
//        bind.drawer.closeDrawer(GravityCompat.START)
//
//        return true
//    }


}