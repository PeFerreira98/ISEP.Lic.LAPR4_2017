/**
 * Technical documentation regarding the user story IPC01.1: Cells Sharing - Start Sharing
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * • IPC01.1) Start Sharing ? !
 * It should be possible to establish a connection with other instance of Cleansheets in the local network. It
 * should be possible to send the contents of a range of cells to another instance of Cleansheets. The other
 * instance should display the received contents in the same cell address as the original cells.
 * It should be possible to configure the port to be used for network connections. It should be possible to
 * find other instances of Cleansheets available in the local network. These instances should be listed in a new
 * window (sidebar window). The user should be able to select one of the discovered instances to connect
 * to when establishing the connection to send the contents of the range of cells. At the moment it is only
 * required to send the value of the cells.
 * 
 * <p>
 * Notes:
 * <p>
 * This use case requires the network service to be up and running.
 * <p>
 * The user can activate and deactivate the service.
* <p>
 *
 *
 * <b>Analysis</b><p>
 * <img src="ipc04.1_analysis.png" alt="image">
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
 *      1. The user should start the CleanSheets Application<p>
 * <p>
 *
 * Export data to a text file Functional/Integration Test:<p>
 * <p>
 *
 * <b>Design</b><p>
 *
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.green.s1.ipc.n1151211.StartSharing:
 *
 *
 * @author Fernando Borges
 */
package lapr4.green.s1.ipc.n1151211.StartSharing;

