/**
 *  Technical documentation regarding the user story Core10.1.1: Contact Edition
 *  and the work of the team member (1140388) Alexandra Ferreira during week1.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the sprint's work.-
 * <p>
 * This week work time was mostly spent on how the base application works, on
 * tuesday we had a meeting with the client and a scrumm meeting, where each one
 * chose a use case. Created the Jira Issues related to my use case. Started the
 * Analysis of the case.
 *
 * <p>
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-30">LAPR4E17DL-30</a>
 *
 * <h2>2. Requirement</h2>
 *
 * Implement a local db using JPA (ORM) so the application user could create
 * {@link lapr4.white.s1.core.n4567890.contacts.domain.Contact} and within each
 * one be able to create
 * {@link lapr4.white.s1.core.n4567890.contacts.domain.Event} on his
 * {@link lapr4.white.s1.core.n4567890.contacts.domain.Agenda}. Besides the
 * ability to create the above entities the user can remove or edit contacts and
 * events. The agenda may be displayed in a different sidebar.
 * <p>
 * If this user has events then, when their due date arrives, Cleansheets should
 * display a popup window notifying the user about the events. This popup window
 * should automatically disappear after a small time interval (e.g., 5 seconds).
 *
 *
 *
 * <p>
 * <b>Use Case "Contact Edition":</b>
 * <p>
 * The user selects the option that will show contacts.
 * <p>
 * The sidebar will show existing contacts and allows the creation, editing and
 * removal of contacts.
 * <p>
 * If the user wants to create or edit a contact, will be opened a window that
 * will ask all data required for a contact.
 * <p>
 * The user enter the data of a contact.
 * <p>
 * The system saves the contact.
 * <p>
 * Also have an option that will allow associate events to the selected contact.
 *
 *
 *
 * <h2>3. Analysis</h2>
 * Since contacts will be supported in a new extension to cleansheets we need to
 * study how extensions are loaded by cleansheets and how they work. The first
 * sequence diagram in the section
 * <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application
 * Startup</a> tells us that extensions must be a subclass of the Extension
 * abstract class and need to be registered in special files. The Extension
 * class has a method called getUIExtension that should be implemented and
 * return an instance of a class that is a subclass of UIExtension. In this
 * subclass of UIExtension there is a method (getSideBar) that returns the
 * sidebar for the extension. A sidebar is a JPanel.
 *
 * <p>
 * After understanding how extensions are created, we proceded to our use case
 * analysis. We decided that our sidebar will cover all the possible features
 * for the user (create/edit/remove contacts and events).
 *
 * The functional area of this use case requires the use of JPA (ORM). To
 * achieve this functionality we use the same framework used in UC EAPLI,
 * allowing the abstraction of persistence layer.
 *
 *
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 *
 * The following diagrams depicts a proposal for the realization of the
 * previously described use case. We call this diagrams an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design.
 *
 * <p>
 * <img src="uc_analysis_contacts.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to create a new contact.
 * Therefore, at this point we just need to create an object and persist it.
 * <p>
 * To edit a contact we need to change the attributes of the object. For
 * changing this news attributes on the object, we just need to set the new
 * attributes and update the contact.
 * <p>
 * To remove a contact we need to remove the object from the persistence.
 *
 * <p>
 * <img src="uc_analysis_events.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to create, edit or remove an
 * event. Therefore, we just need to get the list of all contacts and select
 * one, where we want to manage the events.
 * <p>
 * To create a new event we need to create an event object and persist it.
 * <p>
 * To edit an event we need to change the attributes of the object. For changing
 * this news attributes on the object, we just need to set the new attributes
 * and update the event of the contact.
 * <p>
 * To remove an event we need to remove the object from the agenda of the
 * contact.
 *
 *
 *
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * <p>
 * We don't have core technical problems regarding this issue.
 *
 *
 *
 *
 *
 * <h3>3.1 User Stories</h3>
 *
 * <b>US1.</b> As a CRM User I want to be able to manage Contacts.<br>
 * Story Acceptance Criteria 1: No contact name duplicates<br>
 * Story Acceptance Criteria 2: No deletion of contacts with events<br>
 * <b>US2.</b> As a CRM User I want to add events to the agenda of Contacts.<br>
 * <b>US3.</b> As a CRM User I want to be notified when the due date of an event
 * occurs.<br>
 *
 *
 *
 *
 *
 * <h3>3.2 Domain Model</h3>
 * <p>
 * <img src="lapr4.white.contacts_domain_model.png" alt="image">
 *
 *
 *
 *
 *
 *
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 *
 * <b>Attention: This test should be moved and refactored to Acceptance Tests so
 * that it is in accordance with the 2017 edition guidelines.</b>
 * <p>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to create, edit or remove a
 * contact object and a event object to an agenda.
 * <p>
 * As usual, in a test driven development approach tests normally fail in the
 * beginning. The idea is that the tests will pass in the end.
 *
 * <p>
 * <b>UC1 Create/Edit/Remove Contact (from US1)</b>
 * <p>
 * To create a new contact we have to make sure that a contact object has to
 * have a first name and a last name. So we have created a test that represents
 * this business rule.
 * <p>
 * To edit a contact we need to be able to set and get its values. Following
 * this approach we can start by coding a unit test that puts a new attribute(s)
 * for the event with the corresponding method accessors (set and get). A simple
 * test can be to set this attributes with a simple string and to verify if the
 * get method returns the same string.
 * <p>
 * To remove a contact we have to make sure that a contact that we chose has no
 * events.
 *
 *
 *
 * <p>
 * see: <code>lapr4.red.s1.core.n1140388.contacts.domain.ContactTest</code>
 *
 *
 * <p>
 * Alternative and Exception Scenarios<br>
 * Exception 1: There is already a user with the same Name. Repeat use case.
 * Exception 2: User has events. Repeat use case.
 *
 * <h3>Acceptance Tests</h3>
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
 *
 * <b>Exception 2</b><br>
 * <pre>
 * {@code
 * Given
 *   Contact with Name "John Doe" and Event != null
 * When
 *   CRM User removes Contact with Name "John Doe"
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 *
 *
 *
 * <p>
 * <b>UC2 Create/Edit/Remove Event (from US1)</b>
 * <p>
 * Event must have a time and a description. So we have created a test that
 * represents this business rule.
 *
 * <p>
 * see: <code>lapr4.white.s1.core.n4567890.domain.ContactTest</code>
 * </p>
 *
 *
 *
 * <p>
 * Agenda has no information at this point. From our view of the requirements
 * there is no business rule to apply on this concept.
 * </p>
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * <h3>4.2. UC Realization</h3>
 *
 *
 * <p>
 * To accomplish this user story we will need to create a subclass of Extension.
 * We will also need to create a subclass of UIExtension. For the sidebar we
 * need to implement a JPanel. In the code of the extension
 * <code>csheets.ext.style</code> we can find examples that illustrate how to
 * implement these technical requirements. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 * </p>
 *
 * <b>Note:</b> It is very important that in the final version of this technical
 * documentation the elements depicted in these design diagrams exist in the
 * code!
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when
 * cleansheets is run.
 * <p>
 * <img src="core02_01_design.png" alt="image">
 *
 *
 *
 *
 *
 *
 * <h3>UC1 - User wants to be able to manage contacts</h3>
 * The following diagrams illustrates what happens when the user selects a
 * option to create, edit or remove a contact.
 * <p>
 *
 * <b>UC1.1 Create Contact (from US1)</b>
 * <p>
 * <img src="../../../../lapr4.white.s1.core.n4567890.contacts.uc_create_contact.png" alt="image">
 * <p>
 *
 * <b>UC1.2 Edit Contact (from US1)</b>
 * <p>
 * <img src="uc_edit_contact_design.png" alt="image">
 * <p>
 *
 *
 * <b>UC1.3 Remove Contact (from US1)</b>
 * <p>
 * <img src="uc_remove_contact_design.png" alt="image">
 *
 *
 *
 *
 * <h3>UC2 - User wants to be able to manage events</h3>
 * The following diagram illustrates what happens when the user selects a option
 * to create, edit or remove a event. For that he needs to select a contact
 * where he is going to manage the event.
 * <p>
 *
 * <b>UC2.1 Create Event (from US2)</b>
 * <p>
 * <img src="uc_create_event_design.png" alt="image">
 * <p>
 *
 * <b>UC2.2 Edit Event (from US2)</b>
 * <p>
 * <img src="uc_edit_event_design.png" alt="image">
 * <p>
 *
 * <b>UC2.3 Remove Event (from US2)</b>
 * <p>
 * <img src="uc_remove_event_design.png" alt="image">
 *
 *
 *
 *
 *
 *
 *
 *
 * <h3>4.3. Classes</h3>
 *
 * -Document the implementation with class diagrams illustrating the new and the
 * modified classes-
 *
 * <img src="" alt="image">
 *
 *
 * <h3>4.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance,
 * database models or updates to the domain model-
 *
 *
 * In this issue we used some design patterns: -Persistence layer as an
 * abstraction for the domain or application layer. -Entity, AggregateRoot and
 * value object DDD concepts.
 * </p>
 *
 *
 * <h2>5. Implementation</h2>
 *
 * {@link lapr4.white.s1.core.n4567890.contacts.domain.Contact}
 * {@link lapr4.white.s1.core.n4567890.contacts.domain.Agenda}
 * {@link lapr4.white.s1.core.n4567890.contacts.domain.Event}
 *
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * </p>
 * see:
 * <a href="../../../../csheets/persistence/package-summary.html">csheets.persistence</a>
 *
 *
 *
 *
 *
 * <h2>6. Integration/Demonstration</h2>
 *
 * We are in the first week where the workflow of the project is a little bit
 * different from the rest of the weeks. Our functional area is very independent
 * from the others. The only that we had to talk with our work collegues was
 * related to the extensions part (Core functional area).
 *
 *
 * <h2>7. Final Remarks</h2>
 *
 * -In this section present your views regarding alternatives, extra work and
 * future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if
 * the cell has a comment. This "feature" is not documented in this page.
 *
 *
 * <h2>8. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Analysis of the manual of lapr4.
 * <p>
 * 2. Build teams.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis of the manual of lapr4.
 * <p>
 * Today
 * <p>
 * 1. Meeting with our supervisor and decided who were the Aea Leaders as well
 * who was going to be Scrum Master.
 * <p>
 * 2. Chosen the issue to deal.
 * <p>
 * 3. Created sub-tasks to that issue.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis of the existing javadoc.
 * <p>
 * 2. Started the analysis of core 10.1
 * <p>
 * Today
 * <p>
 * 1. Completed the analysis.
 * <p>
 * 2. Started the design of core 10.1
 * <p>
 * 3. Started the planning of tests implementation.
 * <p>
 * Blocking:
 * <p>
 * 1. We generated the javadoc, but it did not appear in the index, we find out
 * that we have to create an empty class to appeared
 * <p>
 * 2. Know how the evidence analysis works.
 *
 *
 *
 *
 * <h2>9. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint regarding
 * Rubrics R3, R6 and R7.-
 *
 * This sprint was very thight in time. He had to add the persistence framework,
 * design our solution, implement it and deal with swing design (UI) to make
 * things prettier.
 *
 * Overall it was a good sprint because we accomplished our requirements with
 * what we think it was a good solution.
 *
 *
 * <h3>R3. Rubric Requirements Fulfilment: 3</h3>
 *
 * 3- some defects. The student did fulfil all the requirements and also did
 * justify the eventual options related to the interpretation/analysis of the
 * problem.
 *
 * <h3>R6. Rubric Requirements Analysis: 4</h3>
 *
 * 4- correct. There is a robust and very complete analysis of the problem with
 * well chosen technical artifacts (diagrams, grammars, etc.) for its
 * documentation and without errors.
 *
 * <h3>R7. Rubric Design and Implement: 2</h3>
 *
 * 2- many defects. The code follows good practices although some design
 * patterns should have been applied. The technical documentation covers the
 * majority of the solution although it may have some errors. However the
 * appropriate type of technical artifacts for documenting design are present
 * and the ideia behind the solution is understandable. Code does not "goes
 * against" the design options of the original code of the project. Unit tests
 * seem to cover a significant amount of functionalities (e.g., more than 50%)
 * but there was not test first approach.
 *
 *
 *
 *
 * Since it was a feature with a lot of things added to the code I generated a
 * lot of commits. It's easier to check commits from 1140388.
 *
 *
 * @author Alexandra Ferreira 1140388@isep.ipp.pt
 */
package lapr4.red.s1.core.n1140388.contacts;
