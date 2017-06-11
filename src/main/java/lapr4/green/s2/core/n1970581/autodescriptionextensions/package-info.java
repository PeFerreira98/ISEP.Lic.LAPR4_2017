/**
 * Technical documentation regarding the user story Core01.2 Auto-description of Extensions Team Green Sprint 2
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
 * Work notes/log: S2 6-06-2017 (terca) <br>
 * During the morning we had a meeting with the client. <br>
 * We also had the daily scrum meeting, where each chose a use case of core. <br>
 * During the afternoon we did our IPC presentation of Sprint 1 <br>
 * We closed sprint 1 with the sprint review meeting. <br>
 * Sprint 2 was initiated. We created Jira tasks. <br>
 * Analysis was initiated. <br>
 * <br>
 * 
 * Work notes/log: S2 7-06-2017 (quarta) <br> 
 * Scrum meeting: check Jira report <br>
 * Checking UC's requirements with team. <br>
 * Asked Core Teacher opinion regarding my analysis. Teacher suggested that I update the existing extensions to use the new Constructor. <br>
 * Started testing documentation and user functionl test. <br>
 * Started Design: Documentation Class diagram, SD new load mechanism, SD new Extension creation process. <br>
 * Design: Documentation SD ExtensionDTO building process <br>
 * Implementation: Name Version Description Metadata MetadataFactory Metadatable (interface) <br>
 * Test: unit tests MetadataFactory , Metadata (bugs found and corrected. Name, version, Description should be ok, since they are used a lot.)<br>
 * <br>
 *  
 * Work notes/log: S2 8-06-2017 (quinta) <br> 
 * Scrum meeting: check Jira report <br>
 * Implementation: of MEtadatable interface in Extension class. Extension now suports Metadata and has a new constructor. <br>
 * Warned class about the new Extension versions. <br>
 * Implementation: ExtensionDTO, and builder in MetadataFactory<br>
 * Test: unit tests of ExtensionDTO, and builder in MetadataFactory. Bug fixing.<br>
 * Implementation of following classes: DescriptionExtensionLoader DescriptionExtensionLoaderController DescriptionExtensionLoaderUI <br>
 * Edits:    CleanSheets inclusinon of call to the new loader (NOT ACTIVE YET, has bypass)   ExtensionManager  new methods. <br>
 * <br>
 * Work notes/log: S2 9-06-2017 (sexta) <br>
 * ONLINE Scrum meeting: check Jira report <br>
 * Implementation DefaultExtensionLoadListBuilder interface and DefaultExtensionLoadListBuilderByLatestVersion (related with creating a auto filled selection of extensions)<br>
 * Test: unit test of DefaultExtensionLoadListBuilderByLatestVersion <BR>
 * Implementation: DescriptionExtensionLoader + Controller + UI interconection. New loader 90% functional. Lack UI work and minor fixes.<br>
 * Implementation/debug Inter-Thread signal implemented using wait() + notifyall() , UI polishing. Clear button. Moving right functional. CleanSheets moving new loader code to another place. <br>
 * <br>
 * Work notes/log: S2 11-06-2017 (domingo) <br>
 * Unit testing. 80% coverage. <br>
 * General testing. <br>
 * Use case Online (set to appear at program startup).<br>
 * Test: Testing testing new extensions ver+desc. Inserted in older extensions version and Description information as sugested by teacher. <br>
 * Analysis: finish documentation, shown the draft of the UI<br>
 * Design: finish documentation and polish diagrams.
 * <br>
 * 
 * <h2>2. Requirement</h2>
 * 
 * <h3>2.1 Client requirements</h3>
 * <b>Core01.2 Auto-description of Extensions </b><br> 
 * Extensions should have associated metadata. Particularly, extensions should have a version number, a name and a description.
 * Cleansheets should display to the user the metadata of the extensions before loading them.
 * The user should be able to cancel the loading of an extension and also to select the version of the extension to be loaded (if there are more than one). <br>
 * Difficulty: Hard. <br>
 * Mandatory: Yes. <br>
 * <br>
 * During the client meeting Mr. Alexandre Braganca said that the canceling could be at application start. 
 * By simply showing a menu and allowing the user to choose the extension to load.
 * When questioned, Mr. Alexandre said that we could use two extensions with the same name, as having diferent versions. <p>
 * 
 * So, we will need a menu to show the user, before the extensions are loaded into the UI. 
 * Pause the main program execution, during the user selection. 
 * The menu UI should have two lists. One with all the extensions available. The second with the selected extensions for loading.
 * We should IF POSSIBLE have the second list auto-selected, or committed to memory somewhere (this is OPTIONAL as is not referenced anywhere).
 * We have to show the name, version number and description (metadata). This could be done in a text box bellow, as one selects an extension on the left.
 * We need a confirmation button to finish the selection. (We may need mandatory extensions, since some are hard coded into the core of the program.)
 * Then we can load all the extensions the user selected. <p>
 * 
 * <b>Core01.2 Auto-description of Extensions:</b><p>
 * The user runs the application. The system shows the available extensions, detailing their name, version and description. It asks the user to select the ones to load. <br>
 * The user indicates the selected extensions. The system validates that each extension is unique and finishes loading the Application. <br>
 * <p>
 * <h3>2.2 SSD</h3>
 * 
 * <img src="core01_2_01_analysis.png" alt="image failed to load">
 * 
 * <h2>3. Analysis</h2>
 * 
 * We need a new menu. This will have to be a JFrame. It will have two lists. 
 * One with all the available extensions. The other with the extensions to load.
 * We will need a DTO for representing this extensions. ExtensionDTO.
 * We will have to show the metadate information of the extensions. 
 * So a final Metadate class which is linked to Name , Version, Description. These should be Value objects.
 * ExtensionDTO toString() should show the Name + Version and be sortable (interface Comparable)
 * We should validate that each extension is unique, we can't load two extensions with diferent versions but the same name.
 * We need to have backwards compatibility, so extensions without Version or Description should have a standard one generated.
 * Standard versions is (unknown).
 * Standard Description is ClassName.
 * We will need a mutex to lock/pause the CleanSheets main while we update the ExtensionManager. No special synchronization needed.
 * Changes to Loading will be as less intrusive in the Core as they can be.
 * We will need a class to interface with the ExtensionManager and the new UI : DescriptionExtensionLoader
 * Constructor should load all extensions Class to a List from the extensions.props file. And then build a map of ExtensionDTO , ExtensionClassName.
 * When the User UI Menu indicates the  ExtensionDTO's to load, we go to the map and load every corresponding ExtensionClassName by the ExtensionManager.
 * The building of the ExtensionDTO is still undefined. We could have the information by using an interface that all new Extensions should implement, or we can create a new properties file with the information.
 * <p>
 * 
 * <h3>3.1 First "Analysis" class diagram</h3>
 * <img src="core01_2_02_analysis.png" alt="image filed to load">
 * 
 * 
 * <h3> Draft of the menu shown to the user</h3>
 *  
 * <img src="data:image/png;base64,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" alt="image filed to load">
 * <br> 
 * This draft show us all the information that the UI should present to the user and how.
 * 
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Testing </h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to select the extensions to load according to their version, before the application fully starts.<br>
 * Then allowing the program to finish fully loading. <br>
 * <p>
 * What should we test: <br> 
 * <ul>
 * <li> The UI.</li> 
 * <li> That in the UI that we can see all the extensions in the properties files and that they display the metadata information. </li> 
 * <li> That we cannot load two versions of the same extension.</li> 
 * <li> That the available extensions are the ones that we selected.</li> 
 * </ul>
 * 
 * Blockages: <br>
 *  We can't code automatic tests for the UI. But we can use Functional tests with a user to test it. <br>
 *
 *  
 * <h3>4.1.1 Main Functional Test </h3>
 * 
 *  This test represent a user following the use case. It describes the user actions and the expected outcome.<p>
 *  
 *  <b>Pre conditions:</b><p>
 *  There should be several extensions in the extensions.prop properties file. Some should have the same name, but diferent versions. <br>
 *  
 * 
 *  <b>Test:</b>
 *  <ul>
 *  <li>The user start the Cleansheets program.</li>
 *  <li>A menu for the selection of extensions shows up.</li>
 *  <li>There should be a preselection of extensions for load on the right loading list.</li>
 *  <li>The user should select an extension on the left , the available list and the metadata information should appear.</li>
 *  <li>Selecting the button add on that extension should add it to the loading list.</li>
 *  <li>Selecting an extension that is already on the loading list should block the add funcionality.</li>
 *  <li>Selecting an extension from the loading list and pressing the remove button should move the extension to the available list.</li>
 *  <li>Pressing the load button should close the menu, and continue the loading of the application.</li>
 *  <li>Once all the application finishes loading, the extensions should be available on  view - sidebar or in extensions list of the menu bar.</li>
 *  </ul>
 * 
 * <h3>4.1.2 Unit Tests </h3>
 * 
 * 
 * 
 * 
 * <h2>4.2 UC Realization</h2>
 * 
 * In this use case the user starts the application but before it is fully loaded we need to stop it so the user can choose the Extensions to load.
 * The following sequence diagrams show this process. The class diagram can also be seen bellow. 
 * As a design principle we tried to be as intrusive as possible in the existing code, building code around the existing structures. 
 * And allowing full backwards compatibility. <p>
 * The ExtensionManager loads as normal, but now it also stores all the extensions it detects.
 * The new DescriptionExtensionLoader retrieves this list, builds an acceptable suggestion and passes this information to the user through the UI.
 * Then waits the user input. The user indicates extensions to load, they are validated and then loaded through the ExtensionManager.
 * The Extension now incorporate a new Metadata object that stores the version and description to show to the user.
 * <p>
 * <h3>4.2.1 Sequence Diagrams </h3>
 * 
 *  <b>SD new loading</b> <p>
 *  <img src="core01_2_04_design.png" alt="image failed to load">
 *  <p>
 * This diagram show the main use case execution. And the controller and UI interactions.
 * <p>
 *  <b>SD metadata building detail </b> <p>
 *  <img src="core01_2_05_design.png" alt="image failed to load">
 *  <p>
 *  This diagram shows the sequence for building the Metadata that now integrates every extension.
 *  <p>
 *   <b>SD ExtensionDTO building detail</b> <p>
 *  <img src="core01_2_06_design.png" alt="image failed to load">
 *  <p>
 *  This diagram show the construction of the ExtensionDTO used to communicate with the UI.
 *  <p>
 * 
 <h2>4.3 Classes</h2>
 * 
 * The following diagram shows the created classes and it's interactions. <br>
 * <h3>4.3.1 Class Diagram</h3>
 * <img src="core01_2_03_design.png" alt="image failed to load">
 * <br>
 * The connection and use of the MetadataFactory by Extension and DescriptionExtensionLoader classes are omitted in order to show a more clear class diagram due to plum limitations. They are visible in the SD's.<p>
 * 
 * <h3>4.4. Design Patterns and Best Practices</h3>
 * 
 * <h4>4.4.1 Strategy </h4>
 * We used this pattern in the DescriptionExtensionLoader, where the method of building the default list of extension to show the user is based in the DefaultExtensionLoadListBuilder interface.
 * We created the DefaultExtensionLoadListBuilderByLatestVersion, that creates this list based on the most recent versions.
 * But we can use any other means of creating this list as long as they implement the interface the DescriptionExtensionLoader uses.
 * <p>
 * 
 * <h4>4.4.2 Factory </h4> 
 * We use a MetadataFactory to concentrate the building of all Metadata related things.<p>
 * 
 * 
 * <h4>4.4.3 Value Object and Aggregate </h4> 
 * Name, Version and Description are all immutable value objects, that are accessed through the Metadata, that acts as an minimalist aggregate root.
 * Even Metadata is an immutable value object. <p>
 * 
 * <h4>4.4.4 DTO</h4>
 * We have a need to send information to the user regarding the Extensions, thus we create an immutable object ExtensionDTO which has the information the user needs to make decisions.
 * Avoiding the sharing of real extensions with the user.<p>
 * 
 * 
 * 
 * 
 * <h2>5. Implementation</h2>
 * 
 * All the implementation commits can be seen by searching for LAPR4E17DL-161 <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/0662792a13ccdff206ca69dd852de18ee777b7e4">Implementation: Name Version Description Metadata MetadataFactory Metadatable (interface)</a> <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/bf5c5fb02cc3a65c451671f129f9336a4fc9a2b6">Implementation: of MEtadatable interface in Extension class. Extension now suports Metadata and has a new constructor.</a> <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/48b8625e14b2d19cb98732c1bf9e5bf7ba2e67d2">Implementation: ExtensionDTO, and builder in MetadataFactory.</a> <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/86cc7d5ec56a6218a9862c3a61c002a21c262548">Implementation of following classes: DescriptionExtensionLoader DescriptionExtensionLoaderController DescriptionExtensionLoaderUI </a> <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/8cbb4d2bddf26015325fabb3f566287ae67cba9d">Implementation DefaultExtensionLoadListBuilder interface and DefaultExtensionLoadListBuilderByLatestVersion (related with creating a auto filled selection of extensions)</a> <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/23d314d2c4a67840abedf7d39bde45b7af0890fc"> Implementation: DescriptionExtensionLoader + Controller + UI interconection. New loader 90% functional. Lack UI work and minor fixes.</a> <br>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2017-2dl/commits/ddb01b7ffa812e218d0deb2c420ea3837db1b73d">Implementation/debug Inter-Thread signal implemented using wait() + notifyall() , UI polishing. Clear button. Moving right functional. CleanSheets moving new loader code to another place.</a> <br>
 * <p>
 * 
 * <h2>6. Integration/Demonstration</h2>
 * 
 * All testes were run and no anomaly was detected. The planned demonstration is to run the functional test as an user and demonstrate the correct implementation.
 * No anomalous interaction with existing code was detected, but special care was taken to prevent them. See final remarks.
 * <p>
 * 
 * <h2>7. Final Remarks</h2>
 * 
 * There were many ways to implement this use case, some better, some worse. <br>
 * For example we could have turned the DescriptionExtensionLoader into a singleton, and had the list building done in the constructor.
 * This wasn't done, because possible interaction during tests, since it needs to contact the ExtensionManager that deals with Files. And we should avoid tests with files.<br>
 * Instead of using a Metadata inside the Extension object, we could have Extension instances implement an interface that provides the information.
 * This would allow greater extension customisation and flexibility at the cost of having a standard for Metadata.<br>
 * We could also have this Metadata information stored in a properties file, reducing the invasiveness of the use case. 
 * But the Information Expert tell us that Extension should know herself the information regarding the metadata.<br>
 * There wasn't detected any saving interference, nor the use case description refers any concerns about this situation.
 * But concerns about this situation linger, and although time and scope didn't allow the fully compreension of it's impact, it is recommended an more through investigation.
 * Perhaps in the form of an following use case for sprint 3, since this use case ends in sprint 2.<br>
 * Great care was taken in maintaining backwards compatibility of extensions, by maintaining support for extensions without metadata information.
 * And in avoiding interference of this use case with colleagues use cases. 
 * Most the new loading procedure can also be bypassed by simply selecting the yellow button in the UI to use the previous configurations.<br>
 * <p>
 * * 
 * <h2>8. Work Log</h2> 
 * 
 * Please check notes at item 2 at the top of this page, or the Jira issues for time logging.
 * 
 * <h2>9. Self Assessment</h2> 
 * 
 * Self-assessment of the work during this sprint regarding Rubrics R3, R6 and R7.
 * 
 * <h3>R3. Rubric Requirements Fulfilment: 3</h3>
 * 
 * 3- some defects. The student did fulfil all the requirements and also did justify the eventual options related to the interpretation/analysis of the problem.
 * 
 * <h3>R6. Rubric Requirements Analysis: 3 </h3>
 * 
 * 3- some defects. There is a robust analisys of the problem with well chosen technical artifacts (diagrams, grammars, etc.) for its documentation although some may have erros, such as referencing inexistent artifacts or having small notation errors. <br>
 * 
 * 
 * <h3>R7. Rubric Design and Implement: 3</h3>
 * 
 * 3- some defects. Unit tests do cover a significant amount of functionalities (e.g., more than 80%) and there are some evidences of a test first approach. The code does not "break" the design options of the original project code and the code follows the good practices of the technical area (e.g., synchronization for IPC, design patterns, grammar design for Lang). Also, the technical documentation (e.g., diagrams) is very complete and without significant errors.
 *  
 * 
 * 
 * 
 * @author Hugo Bento 1970581
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;
