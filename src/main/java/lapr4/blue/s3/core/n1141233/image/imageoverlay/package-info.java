/**
 * Technical documentation regarding the user story CORE06.2: Overlay Image Window.
 *
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * </p>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 * </p>
 *
 *
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * -Notes about the sprint's work.-
 * <br>
 * -In this section you should register important notes regarding your work
 * during the sprint. For instance, if you spend significant time helping a
 * colleague or if you work in more than one feature.-
 * <br>
 * <br>
 * -Someone messed with my documentation and code and that caused me quite some
 * delay in my work and a lot of wasted time.
 * </p>
 *
 *
 *
 * <h2>2. Requirement</h2>
 *
 * <p>
 * Cleansheets should display a small icon in the corner of cells that have
 * associated images.
 * <br>
 * When the mouse is hovering such cells a modeless window (i.e., an overlay
 * window) should appear to display the associated images (this is independent
 * from the sidebar window).
 * <br>
 * The window should always appear next to the cell. This window should have
 * buttons to browse over all the images.
 * <br>
 * When the mouse focus leaves the cell the window should automatically close.
 * <br>
 * The images should also be persisted with (i.e., inside) the workbook.
 * </p>
 *
 *
 *
 * <h2>3. Analysis</h2>
 *
 *
 * <h3>3.1 User Stories</h3>
 *
 * <p>
 * <b>US1.</b> As a User I want to be able view the cell's associated images in
 * an overlay window when i hover the mouse over a cell that contains images.
 * <br>
 * </p>
 *
 *
 * <h3>3.2 Use Cases (Scenarios)</h3>
 *
 * <p>
 * <b>UC1 Open Overlay Window(from US1)</b>
 * <br>
 * <img src="ipc04.2_analysis1.png" alt="analysis">
 * <br>
 * Alternative and Exception Scenarios
 * <br>
 * Exception 1: No cells with images available.
 * <br>
 * </p>
 *
 *
 *
 * <h2>4. Design</h2>
 *
 *
 * <h3>4.1. Tests</h3>
 *
 * <h4>4.1.1 Functional/Integration Tests</h4>
 *
 * <p>
 * <b>Open Overlay Window file Test:</b>
 * 1. The user should start the CleanSheets Application<br>
 * 2. He moves the mouse pointer over a cell that contains images<br>
 * 3. The overlay window opens allowing him to navigate through the images in
 * the cell using the buttons in the window<br>
 * 4. The user presses the buttons previous or next to navigate through the
 * images<br>
 * 5. The user moves the mouse outside the overlay window to close it<br>
 * 6. No error should occur<br>
 * </p>
 *
 * <h4>4.1.2 Unit Tests</h4>
 *
 * The unit testing coverage is very low because even though the images are now
 * persisted inside de workbook, they must come from a file, which means that
 * it's not possible to create an image without a file, therefore it's not
 * possible to cover most of the code with unit tests.
 *
 * <h4>4.1.3 Acceptance Tests</h4>
 *
 * <b>Exception 1</b>
 * <br>
 * <pre>
 * {@code
 * Given
 *   No cells with images available
 * Then
 *   User inserts images
 * }
 * </pre>
 *
 *
 * <h3>4.2 UC Realization</h3>
 *
 *
 * <h4>4.2.1 Sequence Diagrams</h4>
 *
 * <p>
 * <br>
 * <b>UC1</b>
 * <br>
 * <img src="core06.2_designuc1.png" alt="uc1">
 * <br>
 * </p>
 *
 *
 * <h3>4.3. Classes</h3>
 *
 * <h4>4.3.1 Class Diagram</h4>
 *
 * <img src="core06.2_class.png" alt="class diagram">
 *
 *
 * <h3>4.4. Design Patterns and Best Practices</h3>
 *
 * <p>
 * -nothing-
 * </p>
 *
 *
 *
 * <h2>5. Implementation</h2>
 *
 * <p>
 * {@link lapr4.blue.s3.core.n1141233.image.insertimage.ImagesExtension}
 * <br>
 * {@link lapr4.blue.s3.core.n1141233.image.insertimage.ImmagenableCellListener}
 * <br> {@link lapr4.blue.s3.core.n1141233.image.insertimage.ImmagenableCell}
 * <br> {@link lapr4.blue.s3.core.n1141233.image.insertimage.Images}
 * <br>
 * {@link lapr4.blue.s3.core.n1141233.image.insertimage.ui.UIExtensionImages}
 * <br> {@link lapr4.blue.s3.core.n1141233.image.insertimage.ui.ImageController}
 * <br> {@link lapr4.blue.s3.core.n1141233.image.insertimage.ui.ImagesPanel}
 * <br>
 * {@link lapr4.blue.s3.core.n1141233.image.insertimage.ui.ImagedCellDecorator}
 * <br>
 * {@link lapr4.blue.s3.core.n1141233.image.imageoverlay.OverlayMouseMotionListener}
 * <br>
 * {@link lapr4.blue.s3.core.n1141233.image.imageoverlay.OverlayTableDecorator}
 * <br> {@link lapr4.blue.s3.core.n1141233.image.imageoverlay.ui.ImageOverlayUI}
 * <br>
 * {@link lapr4.blue.s3.core.n1141233.image.imageoverlay.controller.ImageOverlayController}
 * <br>
 * This is a small code snippet showing how the mouse motion listener detects a
 * cell with images and opens the overlay window<br>
 * <pre>
 * Code snippet:
 * {@code
 *     if (active)
 *       {
 *           SpreadsheetTable table = (SpreadsheetTable) e.getSource();
 *           int row = table.rowAtPoint(e.getPoint());
 *           int column = table.columnAtPoint(e.getPoint());
 *           Cell cell = table.getSpreadsheet().getCell(column, row);
 *
 *           ImagenableCell choosedCell = (ImagenableCell) cell.getExtension(ImagesExtension.NAME);
 *
 *           if (choosedCell.hasImages())
 *            {
 *                // stop all other overlay listeners
 *                active = false;
 *
 *               Point point = MouseInfo.getPointerInfo().getLocation();
 *               ImageOverlayUI ui = new ImageOverlayUI(choosedCell, point);
 *               ui.addMouseListener(new MouseAdapter()
 *               {
 *                   @Override
 *                   public void mouseEntered(MouseEvent e)
 *                   {
 *                       Point mousePos = MouseInfo.getPointerInfo().getLocation();
 *                       Rectangle bounds = ui.getBounds();
 *                       bounds.setLocation(ui.getLocationOnScreen());
 *                   }
 *
 *                   @Override
 *                   public void mouseExited(MouseEvent e)
 *                   {
 *                       Point mousePos = MouseInfo.getPointerInfo().getLocation();
 *                        Rectangle bounds = ui.getBounds();
 *                        bounds.setLocation(ui.getLocationOnScreen());
 *
 *                       if (!bounds.contains(mousePos))
 *                       {
 *                           ui.dispose();
 *                           // reactivate the overlay listeners
 *                           OverlayMouseMotionListener.setActive();
 *                       }
 *                   }
 *               });
 *           }
 *       }
 * }
 * </pre>
 * <br>
 * </p>
 *
 *
 * <h2>6. Integration/Demonstration</h2>
 *
 * <p>
 * All tests were run and no anomaly was detected. The planned demonstration is
 * to run the functional tests as an user and demonstrate the correct
 * implementation.
 * </p>
 *
 *
 *
 * <h2>7. Final Remarks</h2>
 *
 * <p>
 * TODO
 * </p>
 *
 *
 *
 * <h2>8. Work Log</h2>
 *
 * <p>
 * Please also check Jira issue LAPR4E17DL-19 for time logging.
 * <br>
 *
 * Work notes/log: S3 13-06-2017 (terça)
 * <br>
 * - During the morning we had a meeting with the client.
 * <br>
 * - We also had the daily scrum meeting, where each chose a use case from core.
 * <br>
 * - Sprint 2 was closed with the sprint review meeting.
 * <br>
 * - Sprint 3 was initiated and we created the associated Jira tasks.
 * <br>
 * - Analysis was initiated.
 * <br>
 *
 * <br>
 * Work notes/log: S3 14-06-2017 (quarta)
 * <br>
 * - Analysis was conluded.
 * <br>
 * - Design and implementation was initiated.
 * <br>
 *
 * <br>
 * Work notes/log: S3 15-06-2017 (quinta)
 * <br>
 * - Design was conluded.
 * <br>
 * - Implementation was continued.
 * <br>
 * - Testing was started.
 * <br>
 *
 * <br>
 * Work notes/log: S3 16-06-2017 (sexta)
 * <br>
 * - Implementation and testing was continued.
 * <br>
 *
 * <br>
 * Work notes/log: S3 17-06-2017 (sábado)
 * <br>
 * - Implementation was concluded.
 * <br>
 * - Design was updated.
 * <br>
 *
 * <br>
 * Work notes/log: S3 18-06-2017 (domingo)
 * <br>
 * - Testing was concluded.
 * <br>
 * - Analysis and Design were updated (and restored after being tempered with).
 * <br>
 * </p>
 *
 *
 *
 * <h2>9. Self Assessment</h2>
 *
 * <p>
 * Self-assessment of the work during this sprint regarding Rubrics R3, R6 and
 * R7.
 * </p>
 *
 *
 * <h3>R3. Rubric Requirements Fulfillment: 3</h3>
 *
 * <p>
 * 4- correct. The student did fulfil the requirements, justified the options
 * and also presented a critical analysis of the requirements and options that
 * is an evidence of his understanding of the problem domain.
 * </p>
 *
 *
 * <h3>R6. Rubric Requirements Analysis: 3 </h3>
 *
 * <p>
 * 3- some defects. There is a robust analisys of the problem with well chosen
 * technical artifacts (diagrams, grammars, etc.) for its documentation although
 * some may have erros, such as referencing inexistent artifacts or having small
 * notation errors.
 * </p>
 *
 *
 * <h3>R7. Rubric Design and Implement: 3</h3>
 *
 * <p>
 * 3- some defects. Unit tests do cover a significant amount of functionalities
 * (e.g., more than 80%) and there are some evidences of a test first approach.
 * The code does not "break" the design options of the original project code and
 * the code follows the good practices of the technical area (e.g.,
 * synchronization for IPC, design patterns, grammar design for Lang). Also, the
 * technical documentation (e.g., diagrams) is very complete and without
 * significant errors.
 * </p>
 *
 *
 *
 * @author Rafael Vieira
 */
package lapr4.blue.s3.core.n1141233.image.imageoverlay;
