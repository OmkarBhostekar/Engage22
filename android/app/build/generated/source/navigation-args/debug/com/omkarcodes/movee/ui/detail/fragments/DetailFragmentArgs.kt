package com.omkarcodes.movee.ui.detail.fragments

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val posterUrl: String? = null,
  public val id: Int = 0,
  public val type: String = "movie",
  public val title: String? = null,
  public val backdropUrl: String? = null
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("posterUrl", this.posterUrl)
    result.putInt("id", this.id)
    result.putString("type", this.type)
    result.putString("title", this.title)
    result.putString("backdropUrl", this.backdropUrl)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("posterUrl", this.posterUrl)
    result.set("id", this.id)
    result.set("type", this.type)
    result.set("title", this.title)
    result.set("backdropUrl", this.backdropUrl)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __posterUrl : String?
      if (bundle.containsKey("posterUrl")) {
        __posterUrl = bundle.getString("posterUrl")
      } else {
        __posterUrl = null
      }
      val __id : Int
      if (bundle.containsKey("id")) {
        __id = bundle.getInt("id")
      } else {
        __id = 0
      }
      val __type : String?
      if (bundle.containsKey("type")) {
        __type = bundle.getString("type")
        if (__type == null) {
          throw IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value.")
        }
      } else {
        __type = "movie"
      }
      val __title : String?
      if (bundle.containsKey("title")) {
        __title = bundle.getString("title")
      } else {
        __title = null
      }
      val __backdropUrl : String?
      if (bundle.containsKey("backdropUrl")) {
        __backdropUrl = bundle.getString("backdropUrl")
      } else {
        __backdropUrl = null
      }
      return DetailFragmentArgs(__posterUrl, __id, __type, __title, __backdropUrl)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
      val __posterUrl : String?
      if (savedStateHandle.contains("posterUrl")) {
        __posterUrl = savedStateHandle["posterUrl"]
      } else {
        __posterUrl = null
      }
      val __id : Int?
      if (savedStateHandle.contains("id")) {
        __id = savedStateHandle["id"]
        if (__id == null) {
          throw IllegalArgumentException("Argument \"id\" of type integer does not support null values")
        }
      } else {
        __id = 0
      }
      val __type : String?
      if (savedStateHandle.contains("type")) {
        __type = savedStateHandle["type"]
        if (__type == null) {
          throw IllegalArgumentException("Argument \"type\" is marked as non-null but was passed a null value")
        }
      } else {
        __type = "movie"
      }
      val __title : String?
      if (savedStateHandle.contains("title")) {
        __title = savedStateHandle["title"]
      } else {
        __title = null
      }
      val __backdropUrl : String?
      if (savedStateHandle.contains("backdropUrl")) {
        __backdropUrl = savedStateHandle["backdropUrl"]
      } else {
        __backdropUrl = null
      }
      return DetailFragmentArgs(__posterUrl, __id, __type, __title, __backdropUrl)
    }
  }
}
