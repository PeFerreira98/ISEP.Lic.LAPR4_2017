/**
 * Technical documentation regarding the user story IPC02.2: Advanced Workbook Search.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * This use case is a continuation of the use case "IPC01.1: Find Workbooks". 
 * This searches cleansheets with the .cls extension, and adds the found files
 * to the active cleensheet.
 * <p>
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-79">
 * Issue on JIRA - IPC02.2</a> 
 * <p>
 * At the end of the implementation the use case only open the preview if the 
 * workbook is open. This is due to a call on the openFile in the 
 * PreviewWorkbookController that returns the Active Workbook. This must be 
 * fixed, changing the method to openWorkbook from SearchWorkbookController.
 *
 * <h2>2. Requirement</h2>
 * The sidebar window that displays the results of the search should now include
 * an area to display a preview of the contents of a workbook when the user 
 * selects it (i.e., clicks on it). The preview should be based on the values of
 * the first non-empty cells of the workbook. This preview should be produced 
 * without open the worksheet (at least without the worksheet been opened in the
 * user interface). The search should now be based on a pattern and not only on 
 * the file name extension.
 *
 * <p>
 * <b>Use Case "Advanced Workbook Search": </b>
 * The user selects to find existing workbook. 
 * The system finds the workbook. 
 * The user selects to preview the selected workbook. 
 * The system shows the workbook preview.
 * The user selects to open the selected preview or close the preview windown.
 *
 * <h2>3. Analysis</h2>
 * To run a wizard we need to build a GUI with Jframe capable of reading a list
 * of available functions and display them to the user. When a function is 
 * highlighted the wizard must provide the necessary help on how to use the 
 * highlighted function and display its name and parameteres. If the user wants
 * to apply one or more functions, the GUI must write them on the formula bar
 * provided in the cleansheet.
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).
 * <p>
 * <img src="ipc02.2_analysis.png" alt="image">
 * <p>
 *
 * <h2>4. Design</h2>
 * The following sequence diagram represents this use case:
 * <p>
 * <img src="ipc02.2_design.png" alt="image">
 * <p>
 *
 * <h3>4.1. Functional Tests</h3>
 * 
 * * To test this user story, the user should follow these steps:
 * <p>
 * 1- run cleansheets;
 * <p>
 * 2- click on the View menu and select sidebars. There must appear a list of
 * menu options containning one option for the sidebars "Search WorkBooks";
 * <p>
 * 3- Enable option "Search WorkBooks";
 * <p>
 * 4- Click "Root" and select folder to search
 * <p>
 * 5- Click "Seach" and wait for the files to show up 
 * <p>
 * 6- Select a file and click "Preview".
 * <p>
 *
 * <h3>4.2. UC Realization</h3>
 * To realize this user story we will need to create a UI for the presentation
 * of the previewed workbook and add a button on the Find Workbook side bar for
 * that purpose. 
 * 
 * <h3>4.3. Classes</h3> * 
 * Here we can se the class diagram developed for this use case: 
 * <p>
 * <img src="ipc02.2_classDiagram.png" alt="image">
 * <p>
 * Note: In lightgray we have the already existing classes and in white we have
 * the newly created classes. C means class and I means interface.
 * <p>
 * 
 * <h2>5. Implementation</h2>
 * 
 * Preview Button code: 
 * <pre>
 * {@code 
 *      FileDTO file = (FileDTO) jListWorkbooks.getSelectedValue();
 *       try {
 *           this.descWorkbook = new DescodificadorWorkbook(uiController.getActiveWorkbook(), file, myselfPanel);
 *       } catch (IOException ex) {
 *           Logger.getLogger(SearchWorkbookPanel.class.getName()).log(Level.SEVERE, null, ex);
 *       } catch (ClassNotFoundException ex) {
 *           Logger.getLogger(SearchWorkbookPanel.class.getName()).log(Level.SEVERE, null, ex);
 *       }
 *       this.previewController = new PreviewWorkbookController(this, uiController);
 *       if (jListWorkbooks.getSelectedValue() != null) {  
 *           try {   
 *               previewController.previewFile(previewController.openFile(file), file);
 *           } catch (IOException ex) {
 *               Logger.getLogger(SearchWorkbookPanel.class.getName()).log(Level.SEVERE, null, ex);
 *           } catch (ClassNotFoundException ex) {
 *               Logger.getLogger(SearchWorkbookPanel.class.getName()).log(Level.SEVERE, null, ex);
 *           }
 *       }
 * }
 * </pre>
 *
 * <h2>6. Work Log</h2> *
 * <p>
 * <b>Daily Log (Tuesday 06/06/2017)</b>
 * <p>
 *	TEAM BLUE
 *	
 *              <p>
 *		• Início da Sprint 2
 *              <p>
 *		• Eleição de um novo Team Leader (Tiago)
 *              <p>
 *		• Distribuição dos user cases pelos elementos do grupo
 *              <p>
 *		• Início da análise dos use case
 *               <p>
 *		• Atribuicao das tarefas no JIRA
 *              <p>
 *		• Cricao de sub-tasks dos use cases [Analysis, Design, Implementation, Testing]
 * 
 * <p>
 * <b>Daily Log (Wednesday 07/06/2017)</b>
 * <p>
 *  *	TEAM BLUE
 *	
 *              <p>
 *		• Continuacao da analise dos use cases
 *              <p>
 *		• Inicio do design
 *              <p>
 *		• Update do Daily Scrum
 * 
 * <p>
 * <b>Daily Log (Thurday 08/06/2017)</b>
 * <p>
 *  *	TEAM BLUE
 *	
 *              <p>
 *		• Finalizacao da analise e de design
 *              <p>
 *		• Inicio do implementacao
 *              <p>
 *		• Update do Daily Scrum
 * 
 * <p>
 * <b>Daily Log (Sunday 11/06/2017)</b>
 * <p>
 *  *	TEAM BLUE
 *	
 *              <p>
 *		• Finalizacao implementacao
 *              <p>
 *		• Inicio e finalizacao dos testes unitarios
 *              <p>
 * 
 * @author Tiago Silvestre
 */
package lapr4.blue.s2.ipc.n1140948.advancedworkbooksearch;
