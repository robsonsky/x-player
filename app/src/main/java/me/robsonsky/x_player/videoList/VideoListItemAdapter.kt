package me.robsonsky.x_player.videoList

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import me.robsonsky.x_player.AdapterItemsContract
import me.robsonsky.x_player.data.Video
import me.robsonsky.x_player.R
import me.robsonsky.x_player.videoDetail.VideoDetailActivity
import me.robsonsky.x_player.databinding.AdapterVideoListItemBinding

class VideoListItemAdapter(var videoList: List<Video>): RecyclerView.Adapter<VideoListItemAdapter.ViewHolder>(), AdapterItemsContract {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterVideoListItemBinding = DataBindingUtil.inflate(inflater, R.layout.adapter_video_list_item,parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.videoList = items as List<Video>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    class ViewHolder(val binding: AdapterVideoListItemBinding): RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun bind(video: Video) {
            setImage(video.thumb)
            binding.video = video
            binding.root.setOnClickListener(this)
            binding.executePendingBindings()
        }

        fun setImage(url: String) {
            val imageView = binding.root.findViewById<ImageView>(R.id.video_image)
            Picasso
                .get()
                .load(url)
                .placeholder(R.drawable.material_flat)
                .into(imageView)
        }

        override fun onClick(v: View?) {

            v?.also { view ->

                val context = view.context

                val intent = Intent(context, VideoDetailActivity::class.java)
                intent.putExtra("video", binding.video)

                context.startActivity(intent)
            }
        }
    }
}