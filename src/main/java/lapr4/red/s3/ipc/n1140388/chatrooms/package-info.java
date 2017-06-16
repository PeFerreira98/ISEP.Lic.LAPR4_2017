/**
 *  Technical documentation regarding the user story IPC.05.3: Chat Rooms
 *  and the work of the team member (1140388) Alexandra Ferreira during week3.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
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
 *
 * <p>
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-89">LAPR4E17DL-89</a>
 *
 * <h2>2. Requirement</h2>
 * The chat extension should now support the concept of chat room.
 * <p>
 * A chat room can have several participants.
 * <p>
 * Messages in a chat room are broadcasted to all its members. The user that
 * creates a chat room becomes its owner.
 * <p>
 * There are 2 types of rooms: private rooms and public rooms. Public rooms are
 * announced to all instances of Cleansheets and each user is free to become a
 * member of a public room. A private room is not announced in the network.
 * <p>
 * The owner should send invites to other users to participate on the room. Each
 * user is free to accept or reject the invitation. The sidebar should now
 * display also the chat rooms.
 *
 *
 *
 *
 * <h2>3. Analysis</h2>
 * <p>
 * This use case is intended to the users of cleansheets application, so they
 * can trade messages in chat rooms (private/public rooms).
 * <p>
 * To accomplish that objective, this use case will be split in 3
 * areas/functionalities: create a chat room and join a chat room and
 * communicate in a chat room.
 * <p>
 * Therefore for the first functionality (create a chat room) a new
 * sub-extension will be created with the objective of create a chat room, which
 * will display the necessary options to create a chat room, like chat room
 * name, type(public or private) and invitations to others users, if is a
 * private room.
 * <p>
 * The second funcionality (join a chat room), will also have a new
 * sub-extension, where you could see all avaiable rooms to join. Distinguishing
 * the public rooms from the private rooms, where only show the rooms where you
 * were invited.
 * <p>
 * Finally, the third funcionality (communicate in a chat room), the user select
 * the chat room he wants to communicate from the sidebar. Then the user can
 * send and receive messages with several others users at the same time on the
 * respective chat room.
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
 * <img src="analysis_ipc05.3.png" alt="image">
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
 * <b>US1.</b> As a User I want to be able to create a chat room.<br>
 * Story Acceptance Criteria 1: Should not have duplicates names<br>
 * <b>US2.</b> As a User I want to be able to join a room.<br>
 * <b>US3.</b> As a User I want to be able to communicate in a chat room.<br>
 *
 *
 *
 *
 *
 * <h2>4. Design</h2>
 *
 * <h3>4.1. Functional Tests</h3>
 * <p>
 * Basically, from requirements and also my analysis, I see that the core
 * functionality of this use case is to be able to create a chat room, and trade
 * message with others users. Following this approach I need to test this use
 * case, to do that I will create an private chat room, and invite others users,
 * and try to send and receive message with them by using the chat room.</p>
 *
 *
 *
 * <p>
 * Alternative and Exception Scenarios<br>
 * <p>
 * Exception 1: The name of the room should be unique.
 *
 *
 * <h3>Acceptance Tests</h3>
 *
 * <b>Exception 1</b><br>
 * <pre>
 * {@code
 * Given
 *   Existing name on list of rooms
 * Then
 *   System throws Exception
 * }
 * </pre>
 *
 *
 *
 *
 *
 * <h3>4.2. UC Realization</h3>
 * <p>
 * To realize this user story, a new subclass of UIExtenstion as well as a new
 * classe of Extension will have to be created. Each participant in the sidebar
 * has a MouseListener that opens the respective chat room, where the user can
 * communicate with others users.
 *
 *
 * <h3>Create Chat Room</h3>
 * <p>
 * <img src="design_createChatRoom_ipc05.3.png" alt="image">
 * </p>
 *
 *
 * <h3>Join Chat Room</h3>
 * <p>
 * <img src="design_joinChatRoom_ipc05.3.png" alt="image">
 * </p>
 *
 * <h3>Communicate in a Chat Room</h3>
 * <p>
 * <img src="design_communicateChatRoom_ipc05.3.png" alt="image">
 * </p>
 *
 *
 *
 *
 * <h3>4.3. Classes</h3>
 *
 * <img src="domain_model_formulas.png" alt="image">
 *
 *
 * <h3>4.4. Design Patterns and Best Practices</h3>
 *
 * -nothing-
 *
 *
 *
 * <h2>5. Implementation</h2>
 *
 *
 *
 * {@link lapr4.red.s2.lang.n1140388.formula.compiler.CurrencyEvalVisitor}
 * <p>
 * {@link lapr4.red.s2.lang.n1140388.formula.compiler.MonetaryExpressionCompiler}
 * <p>
 * {@link lapr4.red.s2.lang.n1140388.formula.MoneyRate}
 * <p>
 * {@link lapr4.red.s2.lang.n1140388.formula.ui.MoneyRateUI}
 *
 *
 *
 * <h2>6. Integration/Demonstration</h2>
 *
 *
 *
 *
 * <h2>7. Final Remarks</h2>
 *
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
 * 1. Analysis of the use case.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 *
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis of the use case.
 * <p>
 * 2. Design of the first use case.
 * <p>
 * 3. Implementation of the first use case.
 * <p>
 * Today
 * <p>
 * 1. Meeting with our supervisor and decided who were the Area Leaders as well
 * who was going to be Scrum Master.
 * <p>
 * 2. Confirm the chosen issue to deal.
 * <p>
 * 3. Created sub-tasks to that issue.
 * <p>
 * 4. Analysis, design and implementation.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 *
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis, design and implementation.
 * <p>
 * Today
 * <p>
 * 1. Analysis, design, implementation and tests.
 * <p>
 * Blocking:
 * <p>
 * -nothing-
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis, design, implementation and tests.
 * <p>
 * Today
 * <p>
 * 1. Implementation.
 * <p>
 * Blocking:
 * <p>
 * 1. I can't run the program on other computer, so I don't have all the
 * possibilities to test what I am doing.
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Implementation
 * <p>
 * Today
 * <p>
 * 1. Unit test.
 * <p>
 * Blocking:
 * <p>
 * <b>Saturday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Implementation and Unit test
 * <p>
 * Today
 * <p>
 * 1. -nothing-
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 *
 *
 * <h2>9. Self Assessment</h2>
 *
 * This sprint was very thight in time. He had to design our solution, implement
 * it and deal with swing design (UI).
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
 * <h3>R7. Rubric Design and Implement: 3</h3>
 *
 * 3- some defects. Unit tests do cover a significant amount of functionalities
 * (e.g., more than 80%) and there are some evidences of a test first approach.
 * The code does not "break" the design options of the original project code and
 * the code follows the good practices of the technical area (e.g.,
 * synchronization for IPC, design patterns, grammar design for Lang). Also, the
 * technical documentation (e.g., diagrams) is very complete and without
 * significant errors.
 *
 *
 *
 * @author Alexandra Ferreira 1140388@isep.ipp.pt
 */
package lapr4.red.s3.ipc.n1140388.chatrooms;
