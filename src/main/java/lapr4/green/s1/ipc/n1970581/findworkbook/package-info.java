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
 * Work notes/log: S1 30-05-2017 (terca) <br>
 * During the morning we had a meeting with the client. <br>
 * In the afternoon we has scrumm meeting, where each chose a use case. <br>
 * Today I chose the IPC02.1 Find Workbooks feature case. <br>
 * Created the Jira Issues related to my use case. <br>
 * Started the Analysis of the case. <br>
 * Analisys: use case and SSD done. <br>
 *  <br>
 ** Work notes/log: S1 31-05-2017 (quarta) <br>
 * Analysis: rough Class diagram <br>
 * Continuation of analysis. Created a class diagram and a description of how the code should be roughtly extruturated. <br>
 * DailyScrum: 15 min <br>
 * Helping team-mate to create package, package javadoc and Jira subtasks. <br>
 * Test: Thinking of tests and Design of Main Functional Test <br>
 *  <br>
 ** Work notes/log: S1 01-06-2017 (quinta) <br>
 *  Daily Scrum: 15 min <br>
 *  Team meeting to share info about Functional Tests <br>
 *  Helping teammate with design decision  <br>
 *  Design started: Class diagram, SD <br>
 *  Implementation started: Draft of UI , implemented an empty Jpanel for the UI. <br>
 *  Class implementation: FileContainer FileDTO FileFinder FilenameFilterBasic.
 *   <br>
 *  Work notes/log: S1 02-06-2017 (sexta) <br>
 * Unit Test: FileContainer FileDTO FileFinder FilenameFilterBasic
 * <p>
 * -In this section you should register important notes regarding your work during the sprint. <br>
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature. <br>
 *
 * <h2>2. Requirement</h2>
 * The extension should add a new window (sidebar) to search for workbook files in the local file system. <br>
 * The user should be able to enter the name of a directory of the file system to be used as the root of the search. <br>
 * The search should include this directory and all its contents (including subdirectories).  <br>
 * The results of the search should appear in a list (updating as files are found). <br>
 * It should be possible for the user to open a workbook from this list by double clicking in it.  <br>
 * The search can be based solely on the file name extension. <br>
 * For instance, find the files with .cls extension.  <br>
 * 
 * <p>
 * <b>Use Case "Find Workbooks":</b><p>
 * The user select the use case to run. A new sidebar appears on the worksheet. <br>
 * The user indicates the root search directory  and activates the search for cleansheet workbook files. <br>
 * The sidebar shows a list of found workbooks. The user selects one of them (double-clicks on it). <br>
 * The system opens the selected workbook and makes it active. <br>
 * <p>
 * <b> SSD </b><p>
 * 
 * <img src="s1_ipc_findworkbook_analysis_01.png" alt="image">
 * 
 * <h2>3. Analysis</h2>
 * Since we shall need a new sidewindow or sidebar we have started to research how to integrate one. We know that all of this is done by classes that extend from the Extension class. <br>
 * That they have a name, and that the our <i>Extention</i> shall have an UI that will extend UIExtension. <i>Our UIExtension</i> should have some method (getSideBar) to return our sidebar as a JPanel. <br>
 * <p>
 * We will need a class to do parallel file search, FileSearch (as a new thread). This class will search the files, from some directory root location that it must be informed of. <br>
 * It shall create some FileDTO object for each file it finds, and place it inside a shared container. <br>
 * The shared container should be also shared by the controller. <br>
 * The addition of a new FileDTO to the container should warn the UI, perhaps through an event. <br>
 * The UI pannel should have a list to show to the user, and this list should be updated automaticaly, through some sort of event, each time a FileDTO is added to the container. <br>
 * When the user selects to open a workbook, the UI should pass to the controller, a reference or the FileDTO for opening. <br>
 * 
 * <h3>First "Analysis" class diagram</h3>
 * <img src="s1_ipc_findworkbook_analysis_02.png" alt="image">
 *  
 * <h3> Draft of what the user should see in the sidebar</h3>
 * <img src="UI.png" alt="image">
 * <p>
 * <img src=" data:image/png;base64,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" alt="image">
 * 
 * 
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Testing </h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to search and show a list of workbooks. <br>
 * Then allowing one of them to be opened. <br>
 * <p>
 * What should we test: <br> 
 * <ul>
 * <li> That we can indicate a filename and a root directory. That a file is found, that it doesn't breaks if no file is found.</li> 
 * <li> That the files are found correctly. </li> 
 * <li> That once a file is found it shows up in the list shown to the User.</li> 
 * <li> That we can open a workbook file.</li> 
 * <li> That double clicking on the filename opens the workbook.</li> 
 * </ul>
 * 
 * Blockages: <br>
 *  We can't code a unit test using the file structure due to Jenkings / the way the project is veryfied uppon commit. But we can do manual tests. <br>
 *  We can't code a test for the double clicking, but we can use the functional test with the user to test this. <br>
 *  
 * <h3>4.1.1 Main Functional Test </h3>
 * 
 *  This test represent a user following the use case. It describes the user actions and the expected outcome.<p>
 *  
 *  <b>Pre conditions:</b><p>
 *  There should be several workbooks with the ".cls" extension in the disk. These can be created by saving workbooks in the main program. <br>
 *  These workbooks should not be in the same directory.<p>
 * 
 *  <b>Test:</b>
 *  <ul>
 *  <li>The user opens the Cleansheets program and select the View Menu item at the top.</li>
 *  <li>Them inside the View menu select the Sidebars option.</li>
 *  <li>A new sidebar should appear in the right most side of the worksheet.</li>
 *  <li>The user should select a root directory to the search by pressing the root button.</li>
 *  <li>Then the user should press the search button to initiate the search.</li>
 *  <li>The list in the side bar should gradually show several workbook names that were found.</li>
 *  <li>The user next double clicks in one of the workbooks name in the list.</li>
 *  <li>A new workbook should be opened and made active.</li>
 *  </ul>
 * 
 * <h3>4.1.2 Unit Tests </h3>
 * 
 *  Unit Test: <br>
 *   The smallest amount of testable code. Often a single method/function, sans the use of other methods or classes. Fast! Thousands of unit tests can run in ten seconds or less! A unit test NEVER uses:
 * <ul>
 *  <li>a database
 *  <li>an app server (or server of any kind)
 *  <li>file/network I/O or file system;
 *  <li>another application;
 *  <li>the console (System.out, System.err, etc.)
 *  <li>logging
 *  <li>most other classes (exceptions include DTO's, String, Integer, mocks and maybe a few others). 
 * </ul>
 *  from: <a href="http://www.javaranch.com/unit-testing.jsp">http://www.javaranch.com/unit-testing.jsp</a> <br>
 * 
 * Since we can't create instances of File objects we are very limited on our unit tests, and so there are only unit tests for FileContainer FileDTO a FilenameFilterBasic. 
 * FileFinder could not be unit tested, but was tested outside the project. And is validated by manual tests.
 * FilenameFilterBasic was fully tested, as it doesn't depends on a File object. The others were partially tested.
 * 
 * <h2>4.2 UC Realization</h2>
 * 
 * <h3>4.2.1 Class Diagram</h3>
 * <img src="s1_ipc_findworkbook_design_01.png" alt="image">
 * 
 * <h3>4.2.2 Sequence Diagram</h3>
 * <img src="s1_ipc_findworkbook_design_02.png" alt="image">
 * 
 * 
 * 
 * @author Hugo Bento 1970581
 */
package lapr4.green.s1.ipc.n1970581.findworkbook;
