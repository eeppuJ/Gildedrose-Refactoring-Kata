package com.gildedrose

class BackstagePasses(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {

    private val qualityBonuses = QualityBonuses(
        QualityBonus(bonus = 3, days = 5),
        QualityBonus(bonus = 2, days = 10),
    )

    override fun updateQuality() {
        increaseQuality()
        decreaseSellIn()
        if (hasExpired) {
            dropQualityToMinimum()
        }
    }

    override fun increaseQuality() {
        repeat(qualityBonus()) { super.increaseQuality() }
    }

    private fun qualityBonus() = qualityBonuses.findBonus { days -> sellIn <= days }

    private fun dropQualityToMinimum() {
        quality = Quality.MINIMUM
    }
}
