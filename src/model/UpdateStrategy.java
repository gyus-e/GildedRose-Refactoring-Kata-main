package model;

class UpdateStrategy {
    static void getUpdateStrategy (Item item) {
        ItemForSale workingItem = ItemFactory.getItemForSale(item.name, item.sellIn, item.quality);
        workingItem.updateQuality();
        item.quality=workingItem.quality;
        item.sellIn=workingItem.sellIn;
    }
}
