package com.abid.footballapp.ui.match.last

import com.google.gson.Gson
import com.abid.footballapp.api.ApiRepository
import com.abid.footballapp.api.TheSportDBApi
import com.abid.footballapp.model.LeagueResponse
import com.abid.footballapp.model.MatchResponse
import com.abid.footballapp.util.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LastMatchPresenter(private val view: LastMatchView,
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

    fun getMatches(id: String?) = GlobalScope.launch(coroutinesCtx.main) {
        view.showLoading()

        val data = makeRequest( TheSportDBApi.getLastMatch(id) )

        try {
            view.showMatches(data.await().events)
        } catch (e: Throwable) {
            view.errorLoading(e.localizedMessage)
        }

        view.hideLoading()
    }

    private fun makeRequest(url: String) = GlobalScope.async(coroutinesCtx.io) {
        gson.fromJson(apiRepository.doRequest(url),
                MatchResponse::class.java)

    }
}
