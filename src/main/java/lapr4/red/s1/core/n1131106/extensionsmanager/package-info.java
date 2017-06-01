/**
 * Technical documentation regarding the user story Core01.1: Enable and Disable Extensions.
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the sprint.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 * 
 * <p>
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-4">Core01.1- Enable and Disable Extensions</a>
 *
 * 
 * <h2>2. Requirement</h2>
 * Provide a window to allow enable and disable cleansheets extensions.
 * 
 * <p>
 * <b>Use Case "Enable and Disable Extensions":</b> The user selects the extensions where he/she wants to load. The system load extensions selections.
 * 
 *  
 * <h2>3. Analysis</h2>
 * 
 * Analyze how to associate the extensions to a window, which can be enabled and disabled.
 * How do we enable and disable an extension.
 * This window will also be an extension, it will be a SideBar on the View menu that can be enabled and disabled.
 * This extension will serve as manager of all others.
 * The implementation will pass by creating a subclass of abstract class Extension.
 * 
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case.
 * <p>
 * <img src="core01_01_uc_realization1.png" alt="image"> 
 * <p>
 * From the previous diagram we see that we need to load extensions.
 * 
 * <h2>4. Design</h2>
 * <p>
 * For this problem I have to create a window so that will be added to the sidebar consequently your shortcut will have to be added in view field in toolbars.
 * The application must load all extensions to the window, and integrate the window so that is possible to enable or disable any extension.
 * It is necessary to note that the concept of enabling and disabling is not the same to modify the properties that the extension adds to our work, 
 * just as it indicates if the extension is disabled and stop being linked to Cleansheet or if it is activated and bind to the Cleansheet.
 * Although it is an extension's manager it can also be considered as an extension because it can also be enabled and disabled in the View menu.
 * 
 * <h3>Sequence diagrams:</h3>
 * <p>
 * <img src="core01_01_showSideBar.png" alt="image"> 
 * <p>
 * <img src="core01_01_activeDesactive.png" alt="image"> 
 * 
 *
 * <h3>4.1. Functional Tests</h3>
 * Such as this task is only to enable and disable other extensions using only components of the graphical part we will only test
 * the class ExtensionNavigatorController.
 * 
 * <h3>4.2. Classes</h3>
 *  <img src="core01_01_design_dc.png" alt="image"> 
 * 
 * 
 * <h2>5. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
 * 
 * <h2>6. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * 
 * <h2>7. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if the cell has a comment. This "feature" is not documented in this page.
 * 
 * 
 * <h2>8. Work Log</h2> 
 * 
 * <p>
 * <b>Monday:</b>
 * </p>
 * <p>
 * 1. Team organization and discussion about the project
 * </p>
 * 
 * <p>
 * <b>Tuesday:</b>
 * </p>
 * <p>
 * 1. Start the analysis of my UC
 * 2. Debug the application, and analyze the generated javaDoc
 * </p>
 * <p>
 * <u>Blocking:</u>
 * </p>
 * <p>
 * 1. -nothing-
 * </p>
 * 
 * <p>
 * <b>Wednesday:</b>
 * </p>
 * <p>
 * 1. Completed the analysis.
 * 2. Start the design.
 * </p>
 * 
 * <h2>9. Self Assessment</h2> 
 * 
 * <h3>R3. Rubric Requirements Fulfilment: 3</h3>
 * 
 * 3- some defects. The student did fulfil all the requirements and also did justify the eventual options related to the interpretation/analysis of the problem.
 * 
 * <h3>R6. Rubric Requirements Analysis: 4</h3>
 * 
 * 4- correct. There is a robust and very complete analysis of the problem with well chosen technical artifacts (diagrams, grammars, etc.) for its documentation and without errors.
 * 
 * <h3>R7. Rubric Design and Implement: 2</h3>
 * 
 * 2- many defects. The code follows good practices although some design patterns should have been applied. The technical documentation covers the majority of the solution although it may have some errors. However the appropriate type of technical artifacts for documenting design are present and the ideia behind the solution is understandable. Code does not "goes against" the design options of the original code of the project. Unit tests seem to cover a significant amount of functionalities (e.g., more than 50%) but there was not test first approach.
 * 
 * @author Nuno Costa 1131106
 */
package lapr4.red.s1.core.n1131106.extensionsmanager;
