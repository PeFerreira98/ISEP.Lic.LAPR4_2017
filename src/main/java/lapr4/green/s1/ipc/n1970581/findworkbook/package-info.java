/**
 * Technical documentation regarding the user story IPC02.1: Find Workbooks Team Green Sprint 1
 * 
 * <p>
 * <b>-Note: this is not a template/example but a real thing.</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * 
 * Work notes/log: S1 30-05-2017 (3ª terça)
 * During the morning we had a meeting with the client.
 * In the afternoon we has scrumm meeting, where each chose a use case.
 * Today I chose the IPC02.1 Find Workbooks feature case.
 * Created the Jira Issues related to my use case.
 * Started the Analysis of the case.
 * Analisys: use case and SSD done.
 *
 ** Work notes/log: S1 31-05-2017 (4ª quarta)
 * Analysis: rough Class diagram
 * DailyScrum:
 * 
 * 
 * 
 * -In this section you should register important notes regarding your work during the sprint.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Requirement</h2>
 * The extension should add a new window (sidebar) to search for workbook files in the local file system.
 * The user should be able to enter the name of a directory of the file system to be used as the root of the search.
 * The search should include this directory and all its contents (including subdirectories). 
 * The results of the search should appear in a list (updating as files are found).
 * It should be possible for the user to open a workbook from this list by double clicking in it. 
 * The search can be based solely on the file name extension.
 * For instance, find the files with .cls extension. 
 * 
 * <p>
 * <b>Use Case "Find Workbooks":</b><p>
 * The user select the use case to run. A new sidebar appears on the worksheet.
 * The user indicates the root search directory  and activates the search for cleansheet workbook files.
 * The sidebar shows a list of found workbooks. The user selects one of them (double-clicks on it).
 * The system opens the selected workbook and makes it active.
 * <p>
 * <b> SSD </b><p>
 * <img src="s1_ipc_findworkbook_analysis_01.png" alt="image">
 * 
 * <h2>3. Analysis</h2>
 * Since we shall need a new sidewindow or sidebar we have started to research how to integrate one. We know that all of this is done by classes that extend from the Extension class.
 * That they have a name, and that the our <i>Extention</i> shall have an UI that will extend UIExtension. <i>Our UIExtension</i> should have some method (getSideBar) to return our sidebar as a JPanel.
 * <p>
 * We will need a class to do parallel file search, FileSearch (as a new thread). This class will search the files, from some directory root location that it must be informed of.
 * It shall create some FileDTO object for each file it finds, and place it inside a shared container.
 * The shared container should be also shared by the controller.
 * The addition of a new FileDTO to the container should warn the UI, perhaps through an event.
 * The UI pannel should have a list to show to the user, and this list should be updated automaticaly, through some sort of event, each time a FileDTO is added to the container.
 * When the user selects to open a workbook, the UI should pass to the controller, a reference or the FileDTO for opening.
 * 
 * <h3>First "Analysis" class diagram</h3>
 * <img src="s1_ipc_findworkbook_analysis_02.png" alt="image">
 *  
 * 
 * @author Hugo Bento 1970581
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;
