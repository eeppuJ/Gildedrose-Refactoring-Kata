package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String = "$name, $sellIn, $quality"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item

        if (name != other.name) return false
        if (sellIn != other.sellIn) return false
        if (quality != other.quality) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + sellIn
        result = 31 * result + quality
        return result
    }

    fun updateQuality() {
        decrementQuality()
        decrementSellIn()

        if (sellIn < 0) {
            decrementQuality()
        }
    }

    fun incrementQuality() {
        if (quality < 50) {
            quality++
        }
    }

    fun decrementQuality() {
        if (quality > 0) {
            quality--
        }
    }

    fun decrementSellIn() {
        sellIn--
    }

}

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality)
class Cheese(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality)
class Legendary(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality)