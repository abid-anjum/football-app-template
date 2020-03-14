package com.abid.footballapp.ui.match.last

import com.abid.footballapp.model.LeagueResponse
import com.abid.footballapp.model.Match

interface LastMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLeagues(data: LeagueResponse)
    fun showMatches(data: List<Match>)
    fun errorLoading(e: String?)
}