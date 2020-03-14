package com.abid.footballapp.ui.match.search

import android.view.Menu
import android.view.MenuInflater
import com.abid.footballapp.model.Match

interface MatchSearchView {
    fun showLoading()
    fun hideLoading()
    fun showSearchResult(data: List<Match>)
    fun errorLoading(e: String?)
    fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?)
}