package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTestMine {
	
	public GildedRose setUpAppWithDefaultItem(int sellIn,int quality){
		Item item = new Item("DEFAULT_ITEM", sellIn, quality);
		Item[] items = new Item[] { item };
		return new GildedRose(items);
	}

	@Test
	public void testUpdateQualityDefault1() {
		GildedRose app = setUpAppWithDefaultItem(15, 3); 
		app.updateQuality();
		assertEquals("DEFAULT_ITEM", app.items[0].name);
		assertEquals(14, app.items[0].sellIn);
		
	}

	@Test
	public void shouldDecreaseQualityByOne(){
		int expectedQuality = 2;
		GildedRose app = setUpAppWithDefaultItem(15, 3);
		app.updateQuality();
		assertEquals(expectedQuality, app.items[0].quality);
	}

	@Test
	public void shouldHaveNameDefaultItem (){
		GildedRose app = setUpAppWithDefaultItem(15, 3); 
		app.updateQuality();
		assertEquals("DEFAULT_ITEM", app.items[0].name);
		
	}

	@Test
	public void shouldDecreaseSellInByOne (){
		GildedRose app = setUpAppWithDefaultItem(15, 3); 
		app.updateQuality();
		int expectedSellIn = 14;
		assertEquals(expectedSellIn, app.items[0].sellIn);
		
	}

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void shouldDecreaseQualityByTwoForExpiredItem() {
		GildedRose app = setUpAppWithDefaultItem(-1, 3);
		app.updateQuality();
		int expectedQuality = 1;
		assertEquals(expectedQuality, app.items[0].quality);
	}
}