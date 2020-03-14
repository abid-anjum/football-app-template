package com.abid.footballapp.ui.teams

import com.abid.footballapp.model.LeagueResponse
import com.abid.footballapp.model.Team

interface TeamView {
    fun showLoading()
    fun hideLoading()
    fun showLeagues(data: LeagueResponse)
    fun showTeams(data: List<Team>)
    fun errorLoading(e: String?)
}