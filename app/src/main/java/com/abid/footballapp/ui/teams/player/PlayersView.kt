package com.abid.footballapp.ui.teams.player

import com.abid.footballapp.model.Player

interface PlayersView {
    fun showLoading()
    fun hideLoading()
    fun showPlayers(data: List<Player>)
    fun errorLoading(e: String?)
}