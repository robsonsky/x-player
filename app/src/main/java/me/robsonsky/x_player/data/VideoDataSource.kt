package me.robsonsky.x_player.data

import com.google.firebase.database.*

class VideoDataSource(): VideoContract {

    override fun listAll(success: (List<Video>) -> Unit, failure: (String) -> Unit) {

        var database: DatabaseReference = FirebaseDatabase
            .getInstance()
            .getReference("/videos");

        var listener = object: ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                if(dataSnapshot.exists()) {

                    val list = mutableListOf<Video>()

                    for(snapshot in dataSnapshot.children) {

                        snapshot.getValue(Video::class.java)?.also { video ->
                            list.add(video)
                        }
                    }

                    success(list)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                failure(databaseError.message)
            }
        }

        database.addValueEventListener(listener)
    }

}