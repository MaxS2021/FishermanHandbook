package com.example.fishermanhandbook

import android.content.res.TypedArray
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
    var adapter: MyAdepter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        var list = ArrayList<ListItem>()
        list.addAll(fillArrays(resources.getStringArray(R.array.fish),
            resources.getStringArray(R.array.fish_content),
            getImageId(R.array.fish_image_array)))


        val rcV = findViewById<RecyclerView>(R.id.rcView)
        rcV.hasFixedSize()
        rcV.layoutManager = LinearLayoutManager(this)
        adapter = MyAdepter(list, this)
        rcV.adapter = adapter

        bind.apply {
            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.idFish -> {
                        Toast.makeText(this@MainActivity, "Fish", Toast.LENGTH_SHORT).show()
                        adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.fish),
                            resources.getStringArray(R.array.fish_content),
                            getImageId(R.array.fish_image_array)))
                    }
                    R.id.idNazh -> {Toast.makeText(this@MainActivity, "Naxhivki", Toast.LENGTH_SHORT).show()
                        adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.nazhivah),
                            resources.getStringArray(R.array.nazhiva_content),
                            getImageId(R.array.nazhiva_image_array)))
                    }
                    R.id.idSnasti -> {Toast.makeText(this@MainActivity, "Snasti", Toast.LENGTH_SHORT).show()}
                    R.id.idHist -> {Toast.makeText(this@MainActivity, "Histopy", Toast.LENGTH_SHORT).show()}
                }

                drawer.closeDrawer(GravityCompat.START)
                true
            }

        }



//        list.add(ListItem(R.drawable.som, "Сом", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))
//        list.add(ListItem(R.drawable.shuka, "Щука", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))
//        list.add(ListItem(R.drawable.karas, "Карась", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))
//        list.add(ListItem(R.drawable.tunec, "Тунец", "asjhasjdksa asdasdkj aksjdaksdj aksjdkasd  aksjd aksjd askjaskdjkas askjasdjkas dkaksajd kksj h"))




    }

    fun fillArrays(title_ar:Array<String>, conten_ar:Array<String>, image_id:IntArray): List<ListItem> {
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..title_ar.size - 1) {
            var list_item = ListItem(image_id[n], title_ar[n], conten_ar[n])
            listItemArray.add(list_item)
        }
        return listItemArray
    }

    fun getImageId(imageArrId: Int): IntArray {
        var tArry: TypedArray = resources.obtainTypedArray(imageArrId)
        val count = tArry.length()
        val ids = IntArray(count)
        for (i in ids.indices) {
            ids[i] = tArry.getResourceId(i, 0)
        }
        tArry.recycle()
        return ids
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