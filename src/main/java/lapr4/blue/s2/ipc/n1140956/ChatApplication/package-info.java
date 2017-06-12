/**
 * Technical documentation regarding the user story Lang03.1: Conditional Formatting of Cells.
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! </b><p>
 *
 * <b>Requirement</b><p>
 * Cleansheets should now use the user name of the system as the basis for the user profile of the chat.
The end user should be able to add an icon or a photo to its profile as well as a nickname. Each user
should have have a status (i.e., online or offline). Cleansheets should automatically discover all users in
the local network. The sidebar window should now have the conversations organized by user. The window
should also display the status of the users and their icon and nickname. When a user state is offline it will
not receive any messages from other instances of Cleansheets. Profile configuration and message history
should be persistent.
 * 
 * <b>Analysis</b><p>
 * On the sidebar window there is a chat where we can chat with other persons who is online. There's an setting's option too where the user can change their nickname and perfil photo.
 * 
 * <img src="ipc05.2_analysis.png" alt="image"> 
 * 
 * <b>Notes</b><p>
 *
 * <b>storeContent</b><p>
 *
 * <b>Tests</b><p>
 * <b>Test1:</b>ConversationStorageTest<p> -
 * See Package lapr4.blue.s2.ipc.n1140956.ChatApplication:<p>
 * ConversationStorageTest<p>
 * <b>Test1:</b>ChatUsersStorageTest<p> -
 * See Package lapr4.blue.s2.ipc.n1140956.ChatApplication:<p>
 * ChatUsersStorageTest<p>
 * 
 * <b>Design</b><p> * 
 *<img src="ipc05.2_design(getUsers).png" alt="image"> 
 *<img src="ipc05.2_design(userSettings).png" alt="image"> 
 * 
 * <p>
 * 
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.blue.s2.ipc.n1140956.ChatApplication:<p>
 * {@link lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser}
 * {@link lapr4.blue.s2.ipc.n1140956.ChatApplication.Conversation}
 * 
 * <p>
 * Package @link lapr4.blue.s2.ipc.n1140956.ChatApplication.ui:<p>
 * {@link lapr4.blue.s2.ipc.n1140956.ChatApplication.ui.ChatUserSettingsUI}
 * 
 * @author Marcos Dourado (1140956)
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;
