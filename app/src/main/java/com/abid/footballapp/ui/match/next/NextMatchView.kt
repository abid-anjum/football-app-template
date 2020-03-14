package com.abid.footballapp.ui.match.next

import com.abid.footballapp.model.LeagueResponse
import com.abid.footballapp.model.Match

interface NextMatchView {
    fun showLoading()
    fun hideLoading()
    fun showLeagues(data: LeagueResponse)
    fun showMatches(data: List<Match>)
    fun errorLoading(e: String?)
}