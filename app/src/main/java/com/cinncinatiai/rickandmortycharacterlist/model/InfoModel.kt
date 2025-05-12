package com.cinncinatiai.rickandmortycharacterlist.model

data class InfoModel(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)
