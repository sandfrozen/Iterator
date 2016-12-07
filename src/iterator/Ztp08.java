/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author A5US
 */
public class Ztp08 {

    static final int TILESIZE = 40;

    public static void main(String[] args) {

        // konstruowanie okna
        JFrame frame = new JFrame("Iterator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Kafelki kafelki = new Kafelki(16, 9, TILESIZE);
        frame.getContentPane().add(kafelki);
        frame.pack();
        frame.setVisible(true);

        // reakcja na kliknięcie uruchomienie wątku z iteracją
        kafelki.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / TILESIZE;
                int y = e.getY() / TILESIZE;
                new Thread(new Watek(kafelki, x, y)).start();
            }
        });
        // reakcja na ruch - podświetlenie wskazanego kafelka
        kafelki.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX() / TILESIZE;
                int y = e.getY() / TILESIZE;
                kafelki.highlight(x, y);
            }
        });
    }
    
}
