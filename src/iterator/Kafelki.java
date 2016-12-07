/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author A5US
 */
public class Kafelki extends JPanel implements Iterable<Tile> {

    private Tile[][] matrix;
    private int tilesize;
    // kafelek podświetlony (myszką)
    private int hx = -1, hy = -1;

    // inicjalizacja macierzy
    public Kafelki(int cols, int rows, int tilesize) {
        this.setPreferredSize(new Dimension(cols * tilesize, rows * tilesize));
        this.tilesize = tilesize;
        matrix = new Tile[rows][cols];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = new Tile();
            }
        }
    }

    // rysowanie macierzy (oraz jednego podświetlonego)
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (i == hy && j == hx) {
                    g.setColor(matrix[i][j].getColor().brighter());
                } else {
                    g.setColor(matrix[i][j].getColor());
                }
                g.fillRect(j * tilesize, i * tilesize + 1, tilesize - 1, tilesize - 1);
            }
        }
    }

    // podświetl
    public void highlight(int x, int y) {
        hx = x;
        hy = y;
        repaint();
    }

//    // trzy poniższe metody znikną w finalnej wersji
//    public int getRows() {
//        return matrix.length;
//    }
//
//    public int getCols() {
//        return matrix[0].length;
//    }
//
//    public Tile getAt(int row, int col) {
//        return matrix[row][col];
//    }

    // za to pojawi się metoda pobierająca iterator
    // public Iterator<Tile> iterator( ...
    @Override
    public Iterator<Tile> iterator() {
        return new Iterator<Tile>() {
            
            private int przed_x = hx;
            private int przed_y = hy;

            @Override
            public boolean hasNext() {
                return przed_y < matrix.length-1 ? true : przed_x < matrix[0].length;
                //takie same^ działanie zapisane inaczej:
//                if ( przed_y < matrix.length-1 ) {      // Wszystkie wiersze bez ostataniego posiadaja nastepny element
//                    return true;
//                } else {
//                    return przed_x < matrix[0].length;  // W ostatni wierszu zwraca true dopóki nie stanie za ostatnim elementem
//                }
            }

            @Override
            public Tile next() {
                if( przed_x >= matrix[0].length ){      // Jeśli to byla ostatnia kolumna to wroc do kolumnuy"0" w nastepnym wierszu
                    przed_x = 0;
                    przed_y++;
                }
                return matrix[przed_y][przed_x++];
            }
        };
    }
}
