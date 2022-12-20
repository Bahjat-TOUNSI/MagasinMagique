package com.magasin;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void testItemDoesNotExist() throws IOException {
        Item[] items = new Item[] { new Item("Gwendal", 3, 50) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        assertEquals("Gwendal", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 3 and now is: " + app.items[0].sellIn + ", Quality was 50 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_gwendal.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemDoesNotExist2() throws IOException {
        Item[] items = new Item[] { new Item("Bahjat", -2, 2) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        assertEquals("Bahjat", app.items[0].name);
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was -2 and now is: " + app.items[0].sellIn + ", Quality was 2 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_bahjat.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemComteNormalCondition() throws IOException {
        Item[] items = new Item[] { new Item("Comté", 2, 5) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 2 and now is: " + app.items[0].sellIn + ", Quality was 5 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_comte.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemComteSellInIsNegativeCondition() throws IOException {
        Item[] items = new Item[] { new Item("Comté", 1, 5) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        app.updateQuality();
        assertEquals("Comté", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 1 and now is: " + app.items[0].sellIn + ", Quality was 5 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_comte_sellin_is_negative.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }


    @Test
    void testItemKryptoniteNothingChanges() throws IOException {
        Item[] items = new Item[] { new Item("Kryptonite", 5, 80) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("Kryptonite", app.items[0].name);
        assertEquals(5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 5 and now is: " + app.items[0].sellIn + ", Quality was 80 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_kryponite.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemPassVIPConcert() throws IOException {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 20, 1) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(19, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 20 and now is: " + app.items[0].sellIn + ", Quality was 1 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_pass_vip_concert.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemPassVIPConcertQualityAdd2() throws IOException {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 10, 1) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 10 and now is: " + app.items[0].sellIn + ", Quality was 1 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_pass_vip_concert_add_2.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemPassVIPConcertQualityAdd3() throws IOException {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 5, 1) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 5 and now is: " + app.items[0].sellIn + ", Quality was 1 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_pass_vip_concert_add_3.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemPassVIPConcertQualityIs0() throws IOException {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 1, 40) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 1 and now is: " + app.items[0].sellIn + ", Quality was 40 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_pass_vip_concert_quality_is_0.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }

    @Test
    void testItemPassVIPConcertQualityIsNotOver50() throws IOException {
        Item[] items = new Item[] { new Item("Pass VIP Concert", 4, 48) };
        Magasin app = new Magasin(items);
        System.out.println(app.items[0]);
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        assertEquals("Pass VIP Concert", app.items[0].name);
        assertEquals(0, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
        String string = ("Item name: " + app.items[0].name + " SellIn was 4 and now is: " + app.items[0].sellIn + ", Quality was 48 and now is: " + app.items[0].quality);

        Path fileName = Path.of("C:\\Users\\bahjat.tounsi\\Documents\\Tests\\test_output\\test_pass_vip_concert_quality_is_not_over_50.txt");
        Files.writeString(fileName, string);
        String file_content = Files.readString(fileName);
        System.out.println(file_content);
    }


}
