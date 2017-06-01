/**
 * Technical documentation regarding the user story IPC05.1: Chat Send Message.
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * Add an option that can be used to send text messages to another instance of
 * Cleansheets. The message should be displayed in a popup window in the other
 * instance of Cleansheets. The popup should disappear after some short period.
 * Cleansheets should have have a new sidebar window to display all the
 * messages. The sidebar should be based on a tree control that shows the
 * messages grouped by thread of conversation. It should be possible to reply to
 * a message by double clicking on it in the tree.
 * <p>
 * Notes:
 * <p>
 * The same TCP connection should be shared by all the communication
 * functionalities of the Cleansheets application.
 * <p>
 * There should be a specific port to respond to UDP datagrams broadcasted by
 * clients to discover instances of Cleansheets in the local network.
 * <p>
 *
 *
 * <b>Analysis</b><p>
 *
 * <p>
 * <b>Notes:</b><p>
 * Class CommWorker: This class is a thread that has the responsibility of
 * communicating with the client.<p>
 *
 * For this to work we could use the already existent class commWorker so we can
 * find other users in the same network, just need to change the data type
 * sending to send messages to pup-up on other user.
 * <p>
 *
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also
 * use case tests (e.g., like in the TDD approach).
 *
 *
 *
 *
 * <b>Design</b><p>
 *
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.green.s1.ipc.n1140618:
 *
 *
 * @author alexandrebraganca
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication;
