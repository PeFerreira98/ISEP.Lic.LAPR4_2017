/**
 * CRM01.1) Contact Edition (team member 4567890, Jane Doe, during sprint1). 
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the sprint's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the sprint.
 * For instance, if you spend significant time helping a colleague or if you work in more than one feature.-
 *
 * <h2>2. Feature: CRM01.1 - Contact Edition</h2>
 * 
 * A sidebar window that provides functionalities for creating, editing and removing contacts. Each contact should have a full name (unique), first and last name and also a photograph. Each contact should also have one agenda in which events related to the contact should be displayed. For the moment, events have only a due date (i.e., timestamp) and a textual description. It should be possible to create, edit and remove events. The agenda may be displayed in a different sidebar. This sidebar should display a list of all events: past, present and future. One of the contacts should be the user of the session in the computer where Cleansheets is running. If this user has events then, when their due date arrives, Cleansheets should display a popup window notifying the user about the events. This popup window should automatically disappear after a small time interval (e.g., 5 seconds).
 *
 * <h2>3. Analysis</h2>
 *
 * <h3>3.1 User Stories</h3>
 * 
 * <b>US1.</b> As a CRM User I want to be able to manage Contacts.<br>
 *     Story Acceptance Criteria 1: No contact name duplicates<br>
 *     Story Acceptance Criteria 2: No deletion of contacts with events<br>
 * <b>US2.</b> As a CRM User I want to add events to the agenda of Contacts.<br>
 * <b>US3.</b> As a CRM User I want to be notified when the due date of an event occurs.<br>
 * 
 * <h3>3.2 Domain Model</h3>
 * <p>
 * <img src="contacts_domain_model.png" alt="image"> 
 * <p>
 * 
 * <h3>3.3 Use Cases (Scenarios)</h3>
 *
 * <b>UC1.1 Create Contact (from US1)</b>
 * <p>
 * <img src="uc_create_contact.png" alt="image"> 
 * <p>
 * Alternative and Exception Scenarios<br>
 * Exception 1: There is already a user with the same Name. Repeat use case. 
 * 
 * <h3>3.4 Acceptance Tests</h3>
 * 
 * <b>Exception 1</b><br>
 * <pre>
 * {@code
 * Given
 *   Contact with Name "John Doe"
 * When
 *   CRM User adds Contact with Name "John Doe"
 * Then
 *   System throws Exception
 * }
 * </pre>
 * @author alexandrebraganca
 */
package lapr4.white.s1.core.n4567890.contacts;

