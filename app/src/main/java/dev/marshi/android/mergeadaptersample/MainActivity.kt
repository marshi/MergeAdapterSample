package dev.marshi.android.mergeadaptersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.MergeAdapter
import dev.marshi.android.mergeadaptersample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val myAdapter = MyAdapter().apply {
            submitList(listOf(
                    Item("1aaaaaaaaaaaaa"),
                    Item("2aaaaaaaaaaaaa"),
                    Item("3aaaaaaaaaaaaa"),
                    Item("4aaaaaaaaaaaaa")
            ))
        }
        val myAdapter2 = MyAdapter2().apply {
            addAll(listOf(
                    Item2("1aaaaaaaaaaaaa"),
                    Item2("2aaaaaaaaaaaaa"),
                    Item2("3aaaaaaaaaaaaa"),
                    Item2("4aaaaaaaaaaaaa")
            ))
        }
        val mergeAdapter = MergeAdapter(myAdapter, myAdapter2)
        binding.recyclerView.adapter = mergeAdapter
    }
}
