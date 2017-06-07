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
 * Work notes/log: S2 6-05-2017 (terca) <br>
 * During the morning we had a meeting with the client. <br>
 * We also had the daily scrum meeting, where each chose a use case of core. <br>
 * During the afternoon we did our IPC presentation of Sprint 1
 * We closed sprint 1 with the sprint review meeting.
 * Sprint 2 was initiated. We created Jira tasks.
 * Analysis was initiated.
 * 
 * <h2>2. Requirement</h2>
 * 
 * <h3>2.1 Client requirements</h3>
 * Core01.2 Auto-description of Extensions <br> 
 * Extensions should have associated metadata. Particularly, extensions should have a version number, a name and a description.
 * Cleansheets should display to the user the metadata of the extensions before loading them.
 * The user should be able to cancel the loading of an extension and also to select the version of the extension to be loaded (if there are more than one). <br>
 * Difficulty: Hard. <br>
 * Mandatory: Yes. <br>
 * 
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
 *  * <h3>3.1 First "Analysis" class diagram</h3>
 * <img src="core01_2_02_analysis.png" alt="image">
 * 
 * 
 * 
 * @author Hugo Bento 1970581
 */
package lapr4.green.s2.core.n1970581.autodescriptionextensions;
