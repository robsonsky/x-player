package me.robsonsky.x_player.mediaPlayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.ui.PlayerView
import me.robsonsky.x_player.R

class MediaPlayerFragment : Fragment() {

    lateinit var viewModel: MediaPlayerViewModel
    private lateinit var playerView: PlayerView

    companion object {
        fun newInstance(viewModel: MediaPlayerViewModel): MediaPlayerFragment {
            val fragment = MediaPlayerFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_media_player, container, false)
        playerView = view.findViewById(R.id.ep_player_view)
        playerView.player = viewModel.exoPlayer
        return view
    }

    override fun onStart() {
        super.onStart()
        viewModel.play()
    }

    override fun onStop() {
        super.onStop()
        viewModel.release()
    }

}
