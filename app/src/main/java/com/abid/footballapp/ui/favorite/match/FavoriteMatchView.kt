package com.abid.footballapp.ui.favorite.match

import com.abid.footballapp.model.Match

interface FavoriteMatchView {
    fun showLoading()
    fun hideLoading()
    fun showFavorite(favorites: List<Match>)
    fun errorLoading(e: String?)
}