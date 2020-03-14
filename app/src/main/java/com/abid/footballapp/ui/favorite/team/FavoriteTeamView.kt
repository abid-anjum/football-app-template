package com.abid.footballapp.ui.favorite.team

import com.abid.footballapp.model.Team

interface FavoriteTeamView {
    fun showLoading()
    fun hideLoading()
    fun showFavorite(favorites: List<Team>)
    fun errorLoading(e: String?)
}