package me.robsonsky.x_player.videoDetail


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_video_detail.*

import me.robsonsky.x_player.R
import me.robsonsky.x_player.databinding.FragmentVideoDetailBinding
import me.robsonsky.x_player.mediaPlayer.MediaPlayerActivity
import me.robsonsky.x_player.videoList.VideoListViewModel

class VideoDetailFragment: Fragment(), View.OnClickListener {

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

        var binding: FragmentVideoDetailBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_video_detail,container, false)

        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setBackButton(view.context)
        setImage(viewModel.video.thumb)
        play_button.setOnClickListener(this)
    }

    private fun setBackButton(context: Context) {

        val icon = ContextCompat
            .getDrawable(context, R.drawable.ic_arrow_back_black_24dp)

        icon?.also{ icon ->
            DrawableCompat.setTint(icon, ContextCompat.getColor(context, R.color.colorWhite));
        }

        toolbar.navigationIcon = icon
        toolbar.setNavigationOnClickListener { activity?.also { activity -> activity.onBackPressed() }}
    }

    private fun setImage(url: String) {
        Picasso.get().load(url).into(backdrop)
    }

    override fun onClick(v: View?) {

        v?.also { view ->

            val context = view.context

            val intent = Intent(context, MediaPlayerActivity::class.java)
            intent.putExtra("video", viewModel.video)

            context.startActivity(intent)
        }
    }

}
