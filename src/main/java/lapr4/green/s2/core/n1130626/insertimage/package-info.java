/**
 * Technical documentation regarding the user story Core06.1: Insert Image.
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * The extension should include an option to insert an image. The inserted image should become associated
 * with the active/selected cell. It should also exist a new sidebar window to display the images that are
 * associated with the current cell (in a manner similar to how comments work). A cell can have several
 * associated images. The sidebar should have an option (button) to remove/delete images. The workbook
 * should only save links to the files that contain the images.
 * <p>
 * Notes:
 * <p>
 * If the user selects the import option, he must select a location of the text file he wants to import
 *
 *
 * <b>Analysis</b><p>
 * <img src="core06.1_analysis.png" alt="image">
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
 * 7. On the label "Special character" the user writes in the textbox located at the right side of the label, the character that will be used to separate columns<p>
 * 8. Check/Uncheck the option if the first line of the text should be treated as containing the header of the columns<p>
 * 9. Press the "Import" button to import the data<p>
 * 10. The cells selected by the user should have the data from the imported text file<p>
 * 11. No error should occur<p>
 * 
 * 
 * <p>
 *
 * <b>Design</b><p>
 * The design section will be divided by parts, to show in a more easy way the process of this use case<p>
 * 
 * <p>
 * 
 * <b>Part 1:</b><p>
 * The delegation design pattern is used in the cell extension mechanism of cleansheets. The following class diagram depicts the relations between classes in the "Cell" hierarchy.<p>
 * 
 * <img src="core06_01_cell_delegate.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 2:</b><p>
 * A portion of a sequence diagram is shown here in part 2 to know how the extension is load by the ExtensionManager<p>
 * 
 * 
 * <p>
 * 
 * <b>Part 3:</b><p>
 * Another portion of a sequence diagram is shown here in part 3 to know how the UI (User interface) of the extension is created<p>
 * 
 * 
 * <p>
 * 
 * <b>Part 4:</b><p>
 * This portion of a sequence diagram is shown here in part 4 to know how the menu of the extension is created<p>
 * 
 * 
 * <p>
 * 
 * <b>These parts (1 to 4) were focused about the creation of the extension, the next parts are focused about the use cases</b><p>
 * 
 * <p>
 *
 * <b>Part 5 - Use case: Import Data</b><p>
 * This is a sequence diagram about the respective use case<p>
 * 
 * 
 * <p>
 * 
 * <b>Part 6 - Use case: Export Data</b><p>
 * This is a sequence diagram about the respective use case<p>
 * 
 * 
 * <p>
 * 
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.green.s2.core.n1130626.insertimage:
 *
 *
 * @author Pedro Pereira
 */
package lapr4.green.s2.core.n1130626.insertimage;
