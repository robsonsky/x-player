package me.robsonsky.x_player.videoDetail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

import me.robsonsky.x_player.R
import me.robsonsky.x_player.videoList.VideoListViewModel

class VideoDetailFragment: Fragment() {


    lateinit var viewModel: VideoDetailViewModel

    companion object {
        fun newInstance(viewModel: VideoDetailViewModel): VideoDetailFragment {
            val fragment = VideoDetailFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_video_detail, container, false)

        val context = view.context

        val icon = ContextCompat.getDrawable(context, R.drawable.ic_arrow_back_black_24dp)

        val toolbar = view.findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.navigationIcon = icon
        toolbar.setNavigationOnClickListener { activity?.also { activity -> activity.onBackPressed() }}

        return view
    }


}
