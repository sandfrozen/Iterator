/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.awt.Color;

/**
 *
 * @author A5US
 */
public class Tile {
    // schowek na wartość logiczną
    private boolean value = false;
    // kolory
    private static final Color on = new Color(0xffd700),
            off = new Color(0x1e90ff);

    // odczyt koloru
    public Color getColor() {
        return value ? on : off;
    }

    //zmiana koloru
    public void flip() {
        value = !value;
    }
}
