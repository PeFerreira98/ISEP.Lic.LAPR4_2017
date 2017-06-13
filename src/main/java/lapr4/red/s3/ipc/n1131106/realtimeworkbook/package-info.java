/**
 * Technical documentation regarding the user story IPC02.3: Multiple Realtime Workbook Search.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 *
 * <p>
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-80">IPC02.3-
 * Multiple Realtime Workbook Search</a>
 *
 *
 * <h2>2. Requirement</h2>
 * It should be possible to define one or more folders to be read on a regular
 * basis to identify cleansheets files and put them in the "list" window.
 *
 * <h2>3. Analysis</h2>
 *
 * To this use case, it´s necessary to create a new GUI that allows the user to
 * select different folders to search workbooks. This interface will have
 * buttons to add and delete folders. After the user selects all the folders
 * that he want, presses the "Search" button and the existing Workbooks will
 * appear in a list. Note that the selected folders by the user will have
 * periodic research in order to discover new instances of Workbooks, updating
 * the list mentioned above. In this use case, the sidebar is already
 * implemented, we only need to create one button that forwards to the created
 * GUI. To see this sidebar the user need to go to: "View" , open the "Side
 * Bars" and select "Find Workbooks". In the sidebar, the user selects "Realtime
 * Search!" and a new window will be shown, this window will have one list that
 * in the begin will be empty, and tree buttons: "Add", "Delete" and "Search".
 * If the user in the selected folders insert a new cleansheets file,
 * automatically the application will update the main window with the new file.
 * The same happens if the user deletes a workbook from one of the folders he
 * previously selected.
 *
 * <img src="" alt="image">
 *
 * <h2>4. Design</h2>
 *
 * <img src="" alt="image">
 *
 *
 * <h3>4.1. Functional Tests</h3>
 *
 *
 *
 * <h3>4.2. Classes</h3>
 * <img src="" alt="image">
 *
 *
 * <h2>8. Work Log</h2>
 *
 * <p>
 * <b>Monday:</b>
 * </p>
 * <p>
 * 1. Apresentation the Sprint 2
 * </p>
 *
 * <p>
 * <b>Tuesday:</b>
 * </p>
 * <p>
 * 1. Start the analysis of my UC
 * </p>
 *
 * <p>
 * <b>Wednesday:</b>
 * </p>
 * <p>
 * 1.
 * </p>
 *
 * <p>
 * <b>Thursday:</b>
 * </p>
 * <p>
 * 1. 
 * </p>
 *
 * <p>
 * <b>Friday:</b>
 * </p>
 * <p>
 * 1. 
 * </p>
 *
 * <p>
 * <b>Saturday:</b>
 * </p>
 * <p>
 * 1.
 * </p>
 *
 * @author Nuno Costa 1131106
 */
package lapr4.red.s3.ipc.n1131106.realtimeworkbook;
