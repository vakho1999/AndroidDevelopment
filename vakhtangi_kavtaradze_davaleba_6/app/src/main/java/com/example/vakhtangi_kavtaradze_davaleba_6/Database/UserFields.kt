package com.example.vakhtangi_kavtaradze_davaleba_6

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class UserFields(
        @ColumnInfo(name = "image_url")
        val imageUrl: String?,
        @ColumnInfo(name = "first_name")
        var fistName: String?,
        @ColumnInfo(name = "last_name")
        var lastName: String?
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

