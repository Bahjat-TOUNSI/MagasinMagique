package com.magasin;

//class Magasin {
//    Item[] items;
//
//    public Magasin(Item[] items) {
//        this.items = items;
//    }
//
//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Comté")
//                    && !items[i].name.equals("Pass VIP Concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Kryptonite")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Pass VIP Concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Kryptonite")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Comté")) {
//                    if (!items[i].name.equals("Pass VIP Concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Kryptonite")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }
//}


class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    private void updateQuality(Item item){
        if (item.name.equals("Comté") || item.name.equals("Pass VIP Concert")) {
            increaseOrDecreaseQuality("increase",item);
            if (item.name.equals("Pass VIP Concert")) {
                updatePassVIPConcertQuality(item);
            }
        } else {
            increaseOrDecreaseQuality("decrease",item);
        }
    }

    private void updatePassVIPConcertQuality(Item passVIP){
        if (passVIP.sellIn < 11) {
            increaseOrDecreaseQuality("increase",passVIP);
        }
        if (passVIP.sellIn < 6) {
            increaseOrDecreaseQuality("increase",passVIP);
        }
    }

    private void increaseOrDecreaseQuality(String action, Item item){
        if(action.equals("increase")){
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
        if(action.equals("decrease")){
            if (item.quality > 0) {
                if (item.name.equals("Kryptonite")) {
                } else {
                    item.quality = item.quality - 1;
                }
                if(item.name.equals("Pouvoirs magiques")){
                    item.quality = item.quality - 1;
                }
            }
        }
    }

    private void decreaseSellIn(Item item){
        if (item.name.equals("Kryptonite")) {
            return;
        }
        item.sellIn = item.sellIn - 1;
    }

    private void updateSellIn(Item item){
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            if (item.name.equals("Comté")) {
                increaseOrDecreaseQuality("increase",item);
            }
            else {
                if (item.name.equals("Pass VIP Concert")) {
                    item.quality = item.quality - item.quality;
                }
                else {
                    if (item.quality > 0) {
                        if (item.name.equals("Kryptonite")) {
                            return;
                        }
                        item.quality = item.quality - 1;
                    }
                }
            }
        }
    }

    public void updateItems() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
            updateSellIn(items[i]);
        }
    }
}
