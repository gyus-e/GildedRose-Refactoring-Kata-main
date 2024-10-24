package model;

public class GildedRose {
    Item[] items;
	ItemForSale[] itemsForSale;

    public GildedRose(Item[] items) {
    	this.items=items;
    	this.itemsForSale=new ItemForSale[items.length];
    	
        for (int i = 0; i < items.length; i++) {
            itemsForSale[i]=(ItemFactory.getItemForSale(items[i].name, items[i].sellIn, items[i].quality));
        }
    }

    public void updateQuality() {
        for (int i = 0; i < itemsForSale.length; i++) {
            itemsForSale[i].updateQuality();
            items[i].sellIn=itemsForSale[i].sellIn;
            items[i].quality=itemsForSale[i].quality;
        }
    }
}
