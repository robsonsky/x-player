package me.robsonsky.x_player.videoList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import me.robsonsky.x_player.R
import me.robsonsky.x_player.databinding.FragmentVideoListBinding

class VideoListFragment : Fragment() {

    lateinit var viewModel: VideoListViewModel

    companion object {
        fun newInstance(viewModel: VideoListViewModel): VideoListFragment {
            val fragment = VideoListFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var binding: FragmentVideoListBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_video_list,container, false)

        binding.viewModel = viewModel
        binding.recyclerView.adapter = VideoListItemAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }


    override fun onStart() {
        super.onStart()
        viewModel.load()
    }
}
