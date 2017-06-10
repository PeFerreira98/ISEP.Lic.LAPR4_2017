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
 * Add an image on the selected cell Functional/Integration Test:<p>
 * 1. Selects the view option<p>
 * 2. Selects the cell decorators option<p>
 * 3. Checks the image option<p>
 * 4. Selects the view option again<p>
 * 5. Selects the side bar features<p>
 * 6. Checks the images extension<p>
 * 7. Selects one cell of the worksheet<p>
 * 8. Goes to the sidebar to select the image extension<p>
 * 9. Press the add image button<p>
 * 10. A file chooser window appears<p>
 * 11. Selects the image he wants to insert<p>
 * 12. Press the ok button<p>
 * 13. The link (location of the image) appears on the list<p>
 * 14. The cell selected is marked with a red *<p>
 * 15. The user click on the link<p>
 * 16. The image appears below the list<p>
 * 17. No error should occur<p>
 * 
 * 
 * <p>
 *
 * Remove an image on the selected cell Functional/Integration Test:<p>
 * Let's consider there is only one image inserted on the selected cell for this test
 * and the side bar and cell decorator are already enabled<p>
 * 1. Selects the cell of the worksheet that contains the inserted image<p>
 * 2. Goes to the sidebar to select the image extension<p>
 * 3. Select the link of the image on the list<p>
 * 4. Press the remove image button<p>
 * 5. The link and image is removed<p>
 * 6. The red * marked on the selected cell disappears<p>
 * 7. No error should occur<p>
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
 * 
 * <b>These parts (1 to 3) were focused about the creation of the extension and prototypes, the next part is focused about the use case</b><p>
 * 
 * <p>
 *
 * <b>Part 4 - Use case: Insert image</b><p>
 * This is a full sequence diagram about the respective use case<p>
 * 
 * <img src="core06_01_design_part4.png" alt="image">
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
