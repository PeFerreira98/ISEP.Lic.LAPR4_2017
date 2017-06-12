/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140953.sharing;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.ext.style.StylableCell;
import java.awt.Color;
import java.awt.Font;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;

/**
 *
 * @author zero_
 */
public class StylableCellDTO extends CellDTO{
    
    private final Font font;
    private final Color color;
    
    public StylableCellDTO(Address addr, String cont, Font font, Color color) {
        super(addr, cont);
        this.font = font;
        this.color = color;
    }
    
    public static StylableCellDTO createFromCell(Cell aCell) {
        StylableCell stylableCell = (StylableCell) aCell;
        return new StylableCellDTO(aCell.getAddress(), aCell.getContent(), stylableCell.getFont(), stylableCell.getBackgroundColor());
    }

    public Font getFont() {
        return font;
    }

    public Color getColor() {
        return color;
    }
    
}
