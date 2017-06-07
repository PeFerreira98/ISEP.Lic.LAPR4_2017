/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1130626.insertimage;

import csheets.core.Cell;
import csheets.ext.Extension;

/**
 *
 * @author Pedro Pereira
 */
public class ImagesExtension extends Extension {
    
        /** The name of the extension */
	public static final String NAME = "Insert images";

        /**
         * Creates a new Image Extension.
         */
        public ImagesExtension() {
            super(NAME);
        }
    
        /**
         * Makes the given cell imagenable.
         * @param cell the cell to accept images
         * @return a imagenable cell
         */
        public ImagenableCell extend(Cell cell){
            return new ImagenableCell(cell);
        }
}
