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
 * If the user selects the import option, he must select a location of the text file he wants to import
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
 * 7. On the label "Special character" the user writes in the textbox located at the right side of the label, the character that will be used to separate columns<p>
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
 * The design section will be divided by parts, to show in a more easy way the process of this use case<p>
 * 
 * <p>
 * 
 * <b>Part 1:</b><p>
 * A class diagram is shown here in part 1 to know how the extension of this use case is created:<p>
 * <img src="ipc04.1_design_part1.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 2:</b><p>
 * A portion of a sequence diagram is shown here in part 2 to know how the extension is load by the ExtensionManager<p>
 * <img src="ipc04.1_design_part2.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 3:</b><p>
 * Another portion of a sequence diagram is shown here in part 3 to know how the UI (User interface) of the extension is created<p>
 * <img src="ipc04.1_design_part3.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 4:</b><p>
 * This portion of a sequence diagram is shown here in part 4 to know how the menu of the extension is created<p>
 * <img src="ipc04.1_design_part4.png" alt="image">
 * 
 * <p>
 * 
 * <b>These parts (1 to 4) were focused about the creation of the extension, the next parts are focused about the use cases</b><p>
 * 
 * <p>
 *
 * <b>Part 5 - Use case: Import Data</b><p>
 * This is a sequence diagram about the respective use case<p>
 * <img src="ipc04.1_design_part5_import.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 6 - Use case: Export Data</b><p>
 * This is a sequence diagram about the respective use case<p>
 * <img src="ipc04.1_design_part6_export.png" alt="image">
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
