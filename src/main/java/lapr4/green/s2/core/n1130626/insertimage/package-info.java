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
 * 1. To be filled<p>
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
 * The following diagram depicts a concept for the realization of the use case. This is a "prototype" diagram because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design.<p>
 * 
 * <img src="image_extension_design_part2.png" alt="image">
 * 
 * <p>
 * 
 * <b>Part 3:</b><p>
 * The following diagram shows the setup of the "images" extension when cleansheets is run.<p>
 * 
 * <img src="core06_01_design_part3.png" alt="image">
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
