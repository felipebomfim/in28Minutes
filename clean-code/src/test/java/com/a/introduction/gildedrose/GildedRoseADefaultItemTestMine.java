package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTestMine {

	private final int DEFAULT_QUALITY = 3; 

	private final int NOT_EXPIRED_SELLIN = 15; 
	private final int EXPIRED_SELLIN = -1; 
	private final int DEFAULT_SELLIN = 10; 
	
	private GildedRose createGildedRoseWithOneDefaultItem(int sellIn,int quality){
		Item item = new Item("DEFAULT_ITEM", sellIn, quality);
		Item[] items = new Item[] { item };
		return new GildedRose(items);
	}

	@Test
	public void shouldDecreaseQualityByOne_whenNotExpiredDefaultItem(){
		GildedRose app = createGildedRoseWithOneDefaultItem(NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
		app.updateQuality();
		assertEquals(DEFAULT_QUALITY-1, app.items[0].quality);
	}

	@Test
	public void shouldHaveNameDefaultItem_whenDefaultItem (){
		GildedRose app = createGildedRoseWithOneDefaultItem(DEFAULT_SELLIN, DEFAULT_QUALITY); 
		app.updateQuality();
		assertEquals("DEFAULT_ITEM", app.items[0].name);
		
	}

	@Test
	public void shouldDecreaseSellInByOne (){
		GildedRose app = createGildedRoseWithOneDefaultItem(DEFAULT_SELLIN, DEFAULT_QUALITY); 
		app.updateQuality();
		assertEquals(DEFAULT_SELLIN-1, app.items[0].sellIn);
		
	}
	
	@Test
	public void shouldDecreaseQualityByTwo_whenExpiredItem() {
		GildedRose app = createGildedRoseWithOneDefaultItem(EXPIRED_SELLIN, DEFAULT_QUALITY);
		app.updateQuality();
		assertEquals(DEFAULT_QUALITY-2, app.items[0].quality);
	}
}