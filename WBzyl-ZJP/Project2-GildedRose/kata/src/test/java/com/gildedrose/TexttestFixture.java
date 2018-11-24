package com.gildedrose;

import com.inamik.text.tables.Cell;
import com.inamik.text.tables.SimpleTable;
import com.inamik.text.tables.grid.Border;
import com.inamik.text.tables.grid.Util;

public class TexttestFixture {
    public static void main(String[] args) {
        final var items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        final var app = new GildedRose(items);

        for (int i = 0; i < 60; i++) {
            SimpleTable s = SimpleTable.of().nextRow()
                .nextCell().addLine("name                      -->    DAY: " + i + "!    <--").applyToCell(Cell.Functions.LEFT_ALIGN.withWidth(50))
                .nextCell().addLine("sellIn").applyToCell(Cell.Functions.HORIZONTAL_CENTER.withWidth(10))
                .nextCell().addLine("quality").applyToCell(Cell.Functions.HORIZONTAL_CENTER.withWidth(10));
            for (final var item : items) {
                s.nextRow()
                        .nextCell().addLine(item.name)
                        .nextCell().addLine(String.valueOf(item.sellIn)).applyToCell(Cell.Functions.HORIZONTAL_CENTER.withWidth(10))
                        .nextCell().addLine(String.valueOf(item.quality)).applyToCell(Cell.Functions.HORIZONTAL_CENTER.withWidth(10));
            }
            Util.print(Border.of(Border.Chars.of('+', '-', '|')).apply(s.toGrid()));
            app.updateQuality();
            System.out.println("\n");
        }
    }

}
