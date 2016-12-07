/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.util.Iterator;

/**
 *
 * @author A5US
 */
public class Watek implements Runnable{

    private Kafelki p;
    private int x, y;
    private Iterator<Tile> it;
    

    // x, y to początkowa pozycja do iteracji
    public Watek(Kafelki k, int x, int y) {
        this.p = k;
        this.x = x;
        this.y = y;
        it = p.iterator();
        
    }

    @Override
    public void run() {
        while (it.hasNext()) {
            // a w środku - obracamy, odświeżamy i czekamy
            it.next().flip(); //tu
            p.repaint();
            try {
                Thread.currentThread().sleep(0,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        // klasyczna podwójna pętla do iteracji
        // tutaj kontrolujemy kolejność odwiedzin
        // zostanie to zastąpione pętlą z użyciem iteratora
//        for (int i = y; i < p.getRows(); ++i) {
//            int j;
//            if (i == y) {
//                j = x;
//            } else {
//                j = 0;
//            }
//            for (; j < p.getCols(); ++j) {
//                // a w środku - obracamy, odświeżamy i czekamy
//                p.getAt(i, j).flip(); //tu
//                p.repaint();
//                try {
//                    Thread.currentThread().sleep(0,1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
    
}
