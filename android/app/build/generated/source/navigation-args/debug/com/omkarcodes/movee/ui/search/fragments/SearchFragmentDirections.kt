package com.omkarcodes.movee.ui.search.fragments

import android.os.Bundle
import androidx.navigation.NavDirections
import com.omkarcodes.movee.R
import kotlin.Int
import kotlin.String

public class SearchFragmentDirections private constructor() {
  private data class ActionSearchFragmentToDetailFragment(
    public val posterUrl: String? = null,
    public val id: Int = 0,
    public val type: String = "movie",
    public val title: String? = null,
    public val backdropUrl: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_searchFragment_to_detailFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("posterUrl", this.posterUrl)
        result.putInt("id", this.id)
        result.putString("type", this.type)
        result.putString("title", this.title)
        result.putString("backdropUrl", this.backdropUrl)
        return result
      }
  }

  public companion object {
    public fun actionSearchFragmentToDetailFragment(
      posterUrl: String? = null,
      id: Int = 0,
      type: String = "movie",
      title: String? = null,
      backdropUrl: String? = null
    ): NavDirections = ActionSearchFragmentToDetailFragment(posterUrl, id, type, title, backdropUrl)
  }
}
