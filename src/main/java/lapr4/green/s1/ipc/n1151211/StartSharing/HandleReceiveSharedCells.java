/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1151211.StartSharing;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.HandleReceiveCells;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Fernando
 */
public class HandleReceiveSharedCells implements CommHandler2 {

    private Object lastReceivedDTO = null;

    private final UIController uiController;

    public HandleReceiveSharedCells(UIController uic) {
        uiController = uic;
    }

    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        
        System.out.println("HandleReceiveSharedCells:handleDTO");
        Logger.getLogger(HandleReceiveSharedCells.class.getName()).log(Level.INFO, CleanSheets.getString("received_object"), dto.getClass().toString());

        SendSharedCellsDTO shareDTO = (SendSharedCellsDTO) dto;
        lastReceivedDTO = shareDTO;

        String sheetName = shareDTO.getSpreadsheetName();
        Logger.getLogger(HandleReceiveSharedCells.class.getName()).log(Level.INFO, "Spreadsheet destination = {0}", sheetName);

        Spreadsheet dst = null;
        for (Spreadsheet ss : uiController.getActiveWorkbook()) {
            if (sheetName.compareTo(ss.getTitle()) == 0) {
                dst = ss;
            }
        }
        System.out.println("HandleReceiveSharedCells:handleDTO.1");

        ReplySendSharedCellsDTO answer = null;

        if (dst == null) {
         System.out.println("HandleReceiveSharedCells:handleDTO.2");
           answer = new ReplySendSharedCellsDTO("Did not find a Spreadsheet with the name: " + sheetName);
        } else {
          System.out.println("HandleReceiveSharedCells:handleDTO.3");
          // Update the cells
            int count = 0;
            int errors = 0;
            Iterator<CellDTO> itr = shareDTO.getIterator();
            while (itr.hasNext()) {
                CellDTO cellDto = itr.next();
                Cell aCell = dst.getCell(cellDto.getAddress());
                ++count;
                try {
                    aCell.setContent(cellDto.getContent());
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(HandleReceiveCells.class.getName()).log(Level.SEVERE, null, ex);
                    ++errors;
                }
            }
            
            answer = new ReplySendSharedCellsDTO(
                    "Got " + count + " cells, from " +  shareDTO.getAddress1()
                    + " to " + shareDTO.getAddress2() + ", " + errors + " errors"
            );
          System.out.println("HandleReceiveSharedCells:handleDTO.4 " + answer.messageText());
          commWorker.sendDto(answer);
        }
    }

    @Override
    public Object getLastReceivedDTO() {
        return lastReceivedDTO;
    }

}
