package com.omkarcodes.movee.ui.detail.models.video

import android.os.Parcel
import android.os.Parcelable

data class Result(
    val id: String?,
    val iso_3166_1: String?,
    val iso_639_1: String?,
    val key: String?,
    val name: String?,
    val official: Boolean,
    val published_at: String?,
    val site: String?,
    val size: Int,
    val type: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(iso_3166_1)
        parcel.writeString(iso_639_1)
        parcel.writeString(key)
        parcel.writeString(name)
        parcel.writeByte(if (official) 1 else 0)
        parcel.writeString(published_at)
        parcel.writeString(site)
        parcel.writeInt(size)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}