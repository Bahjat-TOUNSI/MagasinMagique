package com.magasin;

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
                if (!item.name.equals("Kryptonite")) {
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
                    item.quality = 0;
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
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
        }
    }
}


//    public void updateItems() {
//        for (Item item : items) {
//            if (item.name.equals("Kryptonite")) continue;
//            item.sellIn--;
//            switch (item.name) {
//                case "Comté":
//                    item.quality++;
//                    break;
//                case "Pass VIP Concert":
//                    if (item.sellIn <= 0) item.quality = 0;
//                    else if (item.sellIn <= 5) item.quality += 3;
//                    else if (item.sellIn <= 10) item.quality += 2;
//                    else item.quality++;
//                    break;
//                case "Pouvoirs magiques":
//                    item.quality -= (item.sellIn <= 0) ? 4 : 2;
//                    break;
//                default:
//                    item.quality -= (item.sellIn <= 0) ? 2 : 1;
//                    break;
//            }
//            if (item.quality < 0) item.quality = 0;
//            if (item.quality > 50) item.quality = 50;
//        }
//    }
//}
