package com.gildedrose

data class Legendary(
    override var name: String,
    override var sellIn: Int,
    override var quality: Int,
) : Item() {

    override fun updateQuality() {}
}