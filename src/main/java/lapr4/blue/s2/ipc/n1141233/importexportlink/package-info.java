/**
 * Technical documentation regarding the user story IPC04.2: Import/Export Text Link.
 *
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * </p>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
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
 * - Minor contributions/suggestions in some colleagues work.
 * <br>
 * - Fixed the include cell's header feature from previous sprint (it's working
 * now).
 * </p>
 *
 *
 *
 * <h2>2. Requirement</h2>
 *
 * <p>
 * The process of creating a link is simular to the one described in IPC04.1 but
 * the import or export should be always active (until it is removed by the
 * user).
 * <br>
 * Being active means that the process will be repeated automatically when the
 * source of the data is updated.
 * <br>
 * This should happen for imports and exports
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
 * <b>US1.</b> As a User I want to be able to export cells' content to a text
 * file and keep the file updated as the cells' content is changed.
 * <br>
 * <b>US2.</b> As a User I want to be able to import the content from a text
 * file to the cells and keep the cells' content updated as the file's content
 * is changed.
 * <br>
 * <b>US3.</b> As a User I want to be able to stop any active imports or
 * exports.
 * </p>
 *
 *
 * <h3>3.2 Domain Model</h3>
 *
 * <p>
 * <img src="ipc04_2_dm.png" alt="domain model">
 * </p>
 *
 *
 * <h3>3.3 Use Cases (Scenarios)</h3>
 *
 * <p>
 * <b>UC1 Export Link (from US1)</b>
 * <br>
 * <img src="ipc04_2_analysis1.png" alt="analysis">
 * <br>
 * Alternative and Exception Scenarios
 * <br>
 * Exception 1: File already exists.
 * <br>
 * Exception 2: File name is empty.
 * <br>
 * Exception 3: special character is invalid.
 * <br>
 * </p>
 *
 * <p>
 * <b>UC2 Import Link (from US2)</b>
 * <br>
 * <img src="ipc04_2_analysis2.png" alt="analysis">
 * <br>
 * Alternative and Exception Scenarios
 * <br>
 * Exception 1: File name is empty.
 * <br>
 * Exception 2: File wasn't found.
 * <br>
 * </p>
 *
 * <p>
 * <b>UC3 Remove Active Link (from US4)</b>
 * <br>
 * <img src="ipc04_2_analysis3.png" alt="analysis">
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
 * 2. Selects the first cell he wants to be used for the import<br>
 * 3. Selects the option Extensions<br>
 * 4. Selects the option Import/Export Data<br>
 * 5. Presses the "Import data link from a text file" option to open the
 * feature<br>
 * 6. A window named "Import data link from a text file" should appear with data
 * to be filled by the user<br>
 * 7. Presses the "Find" button to search a text file to import from<br>
 * 8. Presses the "Import" button to import the data<br>
 * 9. The cells selected by the user should have the data from the imported text
 * file and should be automatically updated every time the file is modified<br>
 * 10. No error should occur<br>
 * </p>
 *
 * <p>
 * <b>Export data link to a text file Test:</b>
 * 1. The user should start the CleanSheets Application<br>
 * 2. Selects the range of cells he wants to be used<br>
 * 3. Selects the option Extensions<br>
 * 4. Selects the option Import/Export Data<br>
 * 5. Presses the "Export data link to a text file" option to open the
 * feature<br>
 * 6. A window named "Export data link from a text file" should appear with data
 * to be filled by the user<br>
 * 7. Writes the name of the text file to be exported<br>
 * 8. The user writes in the text box located at the right side of the label,
 * which says "Special character", the character which will be used to separate
 * columns<br>
 * 9. Checks/Unchecks the option to include the cell's header at the beginning
 * of the file<br>
 * 10. Presses the "Export" button to export the data<br>
 * 11. The exported text file should have the data from the cells selected by
 * the user and should be automatically updated every time one of the selected
 * cells content is modified<br>
 * 12. No error should occur
 * </p>
 *
 * <p>
 * <b>Remove active link Test:</b>
 * 1. The user should start the CleanSheets Application<br>
 * 3. Selects the option Extensions<br>
 * 4. Selects the option Import/Export Data<br>
 * 5. Presses the "Remove active link" option to open the feature<br>
 * 6. A window named "Remove active link" should appear with a list of all the
 * active links<br>
 * 7. Selects all the links he wishes to remove<br>
 * 8. Presses the "Remove" button to deactivate the links and remove them<br>
 * 9. The cells content should no longer be connected to the file<br>
 * 10. No error should occur<br>
 * </p>
 *
 * <h4>4.1.2 Unit Tests</h4>
 *
 * Due to the nature of this feature the coverage is very low because it's all
 * related to files and synchronization interactions.
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
 * <b>Exception 2</b>
 * <br>
 * <pre>
 * {@code
 * Given
 *   File name is empty
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 * <b>Exception 3</b>
 * <br>
 * <pre>
 * {@code
 * Given
 *   Special character is invalid
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 * <b>Exception 3</b>
 * <br>
 * <pre>
 * {@code
 * Given
 *   File wasn't found
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
 * This section will be divided by parts, to show in a more easy way the process
 * of this use case
 * <br>
 *
 * <b>Part 1:</b>
 * <br>
 * A portion of a sequence diagram is shown here in part 1 to know how the
 * extension is load by the ExtensionManager
 * <br>
 * <img src="ipc04_2_design_part1.png" alt="part 1">
 * <br>
 *
 * <b>Part 2:</b>
 * <br>
 * Another portion of a sequence diagram is shown here in part 2 to know how the
 * UI (User interface) of the extension is created
 * <br>
 * <img src="ipc04_2_design_part2.png" alt="part 2">
 * <br>
 *
 * <b>Part 3:</b>
 * <br>
 * This portion of a sequence diagram is shown here in part 3 to know how the
 * menu of the extension is created
 * <br>
 * <img src="ipc04_2_design_part3.png" alt="part 3">
 * </p>
 *
 * <p>
 * <br>
 * <b>Export Link</b>
 * <br>
 * <img src="ipc04_2_designuc1.png" alt="uc1">
 * <br>
 * <b>Import Link</b>
 * <br>
 * <img src="ipc04_2_designuc2.png" alt="uc2">
 * <br>
 * <b>Remove Active Link</b>
 * <br>
 * <img src="ipc04_2_designuc3.png" alt="uc3">
 * <br>
 * </p>
 *
 *
 * <h3>4.3. Classes</h3>
 *
 * <h4>4.3.1 Class Diagram</h4>
 *
 * <img src="ipc04_2_cd.png" alt="class diagram">
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
 * {@link lapr4.blue.s2.ipc.n1141233.importexportlink.controller.ImportExportTextLinkController}
 * <br> {@link lapr4.blue.s2.ipc.n1141233.importexportlink.ExportLinkListener}
 * <br> {@link lapr4.blue.s2.ipc.n1141233.importexportlink.ImportLinkRunnable}
 * <br> {@link lapr4.blue.s2.ipc.n1141233.importexportlink.LinkStorage}
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
 * Please check Jira issue LAPR4E17DL-85 for time logging.
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
package lapr4.blue.s2.ipc.n1141233.importexportlink;
