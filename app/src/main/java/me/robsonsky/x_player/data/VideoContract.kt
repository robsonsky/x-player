package me.robsonsky.x_player.data

interface VideoContract {
    fun listAll(success: (List<Video>) -> Unit, failure: (String) -> Unit)
}