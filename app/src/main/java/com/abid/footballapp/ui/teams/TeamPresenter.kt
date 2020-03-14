package com.abid.footballapp.ui.teams

import com.google.gson.Gson
import com.abid.footballapp.api.ApiRepository
import com.abid.footballapp.api.TheSportDBApi
import com.abid.footballapp.model.LeagueResponse
import com.abid.footballapp.model.TeamResponse
import com.abid.footballapp.util.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TeamPresenter(private val view: TeamView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson,
                    private val coroutinesCtx: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getLeagues() = GlobalScope.launch(coroutinesCtx.main) {
        view.showLoading()

        val data = GlobalScope.async {
            gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLeague()),
                    LeagueResponse::class.java)
        }

        try {
            view.showLeagues(data.await())
        } catch (e: Throwable) {
            view.errorLoading(e.localizedMessage)
        }

        view.hideLoading()
    }

    fun getTeams(league: String?) = GlobalScope.launch(coroutinesCtx.main) {
        view.showLoading()

        val data = makeRequest(TheSportDBApi.getTeams(league))

        try {
            view.showTeams(data.await().teams)
        } catch (e: Throwable) {
            view.errorLoading(e.localizedMessage)
            e.printStackTrace()
        }

        view.hideLoading()
    }

    private fun makeRequest(url: String) = GlobalScope.async(coroutinesCtx.io) {
        gson.fromJson(apiRepository.doRequest(url),
                TeamResponse::class.java)

    }
}