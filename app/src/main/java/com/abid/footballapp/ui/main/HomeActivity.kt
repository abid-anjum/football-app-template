package com.abid.footballapp.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abid.footballapp.R
import com.abid.footballapp.R.layout.activity_home
import com.abid.footballapp.ui.favorite.FavoriteFragment
import com.abid.footballapp.ui.match.MatchFragment
import com.abid.footballapp.ui.teams.TeamFragment
import com.abid.footballapp.util.FragmentTransaction.Companion.pushFragments
import com.abid.footballapp.util.KeyValue.Companion.TAG_FAVORITE
import com.abid.footballapp.util.KeyValue.Companion.TAG_MATCH
import com.abid.footballapp.util.KeyValue.Companion.TAG_TEAM
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        pushFragments(this, TAG_MATCH, MatchFragment())
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                bottom_navigation.selectedItemId -> return@setOnNavigationItemSelectedListener false
                R.id.matches -> {
                    pushFragments(this, TAG_MATCH, MatchFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.teams -> {
                    pushFragments(this, TAG_TEAM, TeamFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favorites -> {
                    pushFragments(this, TAG_FAVORITE, FavoriteFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }

        bottom_navigation.selectedItemId = R.id.matches
    }
}