package me.robsonsky.x_player.mediaPlayer

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import me.robsonsky.x_player.R

class MediaPlayerViewModel(val context: Context, val exoPlayer: ExoPlayer): MediaPlayerContract {

    override fun play(url: String) {

        val userAgent = Util.getUserAgent(context, context.getString(R.string.app_name))

        val mediaSource = ProgressiveMediaSource
            .Factory(DefaultHttpDataSourceFactory(userAgent), DefaultExtractorsFactory())
            .createMediaSource(Uri.parse(url))

        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = true
    }

}