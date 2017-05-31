/**
 * Technical documentation regarding the user story IPC04.1: Import/Export Data.
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * It should be possible to export and import data to/from a text file. Each line in the text file represents
 * a row of data. In each line a special character is used to separate columns. The user should be able to
 * configure this character and also define if the first line of the text file should be treated as containing the
 * header of the columns or as regular row. The user should also enter a range of cells to be used as source
 * (export) or destination (import) for the operation.
 * <p>
 * Notes:
 * <p>
 * If the user selects the import option, he must write a valid text file name
 * <p>
 * If the user selects the export option, the system creates a text file with a name created by the user
 * <p>
 *
 *
 * <b>Analysis</b><p>
 * <img src="ipc04.1_analysis.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * In this analysis section, it was created a SSD to simulate a scenario between the system and the user<p>
 * in this respective use case.<p>
 * It is simulating a scenario without errors.<p>
 * 
 *
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also
 * use case tests (e.g., like in the TDD approach).<p>
 *
 * Import data from a text file Functional/Integration Test:<p>
 * 1. The user should start the CleanSheets Application<p>
 * 2. Selects the range of cells he wants to be used<p>
 * 2. Selects the option Extensions<p>
 * 3. Selects the option Import/Export Data<p>
 * 4. Press the "Import from a text file" option to open the feature<p>
 * 5. A window named "Import from a text file" should appear with data to be filled by the user<p>
 * 6. Press the "Find" button to search a text file to import from<p>
 * 7. On the label "Special character" the user writes in the textbox located at the right side of the label, the character which will be used to separate columns<p>
 * 8. Check/Uncheck the option if the first line of the text should be treated as containing the header of the columns<p>
 * 9. Press the "Import" button to import the data<p>
 * 10. The cells selected by the user should have the data from the imported text file<p>
 * 11. No error should occur<p>
 * 
 * <p>
 *
 * Export data to a text file Functional/Integration Test:<p>
 * 1. The user should start the CleanSheets Application<p>
 * 2. Selects the range of cells he wants to be used<p>
 * 3. Selects the option Extensions<p>
 * 4. Selects the option Import/Export Data<p>
 * 5. Press the "Export from a text file" option to open the feature<p>
 * 6. A window named "Export from a text file" should appear with data to be filled by the user<p>
 * 7. Writes the name of the exported text file<p>
 * 8. On the label "Special character" the user writes in the textbox located at the right side of the label, the character which will be used to separate columns<p>
 * 9. Press the "Export" button to import the data<p>
 * 10. The exported text file should have the data from the cells selected by the user<p>
 * 11. No error should occur<p>
 * 
 * <p>
 *
 * <b>Design</b><p>
 *
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.green.s1.ipc.n1130626.importexporttext:
 *
 *
 * @author Pedro Pereira
 */
package lapr4.green.s1.ipc.n1130626.importexporttext;
