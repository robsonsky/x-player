package me.robsonsky.x_player.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Video(
    var title: String,
    var subtitle: String,
    var description: String,
    var thumb: String,
    var url: String
): Parcelable {
    constructor(): this("","","","","")
}