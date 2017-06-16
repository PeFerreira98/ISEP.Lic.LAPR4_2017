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
 * <b>US1.</b> As a User I want to be able to add images to cell's
 * <br>
 * <b>US2.</b> As a User I want to be able to remove images from cell's
 * <br>
 * <b>US1.</b> As a User I want to be able view the cell's associated images in
 * an overlay window when i hover the mouse over a cell that contains images
 * <br>
 * </p>
 *
 *
 * <h3>3.2 Domain Model</h3>
 *
 * <p>
 * <img src="core06.2_dm.png" alt="domain model">
 * </p>
 *
 *
 * <h3>3.3 Use Cases (Scenarios)</h3>
 *
 * <p>
 * <b>UC1 (from US1)</b>
 * <br>
 * <img src="ipc04.2_analysis1.png" alt="analysis">
 * <br>
 * Alternative and Exception Scenarios
 * <br>
 * Exception 1:
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
 * <b>Import data link from a text file Test:</b>
 * 1. The user should start the CleanSheets Application<br>
 * 2. Selects the first cell he wants to be used for
 * </p>
 *
 * <h4>4.1.2 Unit Tests</h4>
 *
 * TODO.
 *
 * <h4>4.1.3 Acceptance Tests</h4>
 *
 * <b>Exception 1</b>
 * <br>
 * <pre>
 * {@code
 * Given
 *   File already exists
 * Then
 *   System throws Exception
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
 * <p>
 * TODO
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
 * Please also check Jira issue LAPR4E17DL-85 for time logging.
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
 *
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
 * TODO
 * </p>
 *
 *
 * <h3>R6. Rubric Requirements Analysis: 3 </h3>
 *
 * <p>
 * TODO
 * </p>
 *
 *
 * <h3>R7. Rubric Design and Implement: 3</h3>
 *
 * <p>
 * TODO
 * </p>
 *
 *
 *
 * @author Rafael Vieira
 */
package lapr4.blue.s3.core.n1141233.image.imageoverlay;
