/**
 * Technical documentation regarding the user story Core10.1.3: Contacts with Tags.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Notes</h2>
 * This use case is a continuation of use case "Core10.1.2: Company Contact". 
 * The previous use case is pourly implemented so to implement this one it is 
 * necessery a better implementation of the previous one in addiction to 
 * completing this one.
 * 
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-32">
 * Issue on JIRA - Core10.1.3- Contacts with Tags</a> 
 *
 * <h2>2. Requirement</h2>
 * It should be possible to associated tags to contacts (individual or company 
 * contacts). A tag is simple an alphanumeric word. Cleansheets should have a
 * window to search contacts based on tags. The search should be based on 
 * regular expressions related to tags. Cleansheets should display the search
 * results in a list. The user may click on an item of the list to edit the
 * corresponding contact. There should also be a window with a list of tags that
 * is automatically sorted (descending) based on the frequency of the tag 
 * utilization. The list should display in each line the tag and its frequency.
 *
 * <h2>3. Analysis</h2>
 * To associate a tag to a contact first we need to know if it is a individual 
 * or a company contact. Company tags should differ from individual tags. The 
 * best way to complete this use case is to build a UI capable of receiving an
 * inserted tag and, with a contact selected from a list, associate them. This 
 * UI must also have a windown that can search a tag and display the results on
 * a list with an option to open Contact edition upon clicking it. In addition
 * the UI must update in a certain time the tags stored in the database, so the 
 * user can know which tags are already taken and its usage. There cannot be 
 * duplicated tags.
 *
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagrams depicts a proposal for the realization of the
 * previously described use case. We call these diagrams an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).
 * 
 * <p>
 * <img src="core10.1.3_analysis_AssociateTags.png" alt="image">
 * <p>
 * <b>Use Case "Contacts with Tags (Associate Tag)": </b>
 * 1. The user searches for available contacts. 
 * 2. The system returns a list of contacts. 
 * 3. The user selects a contact and inserts a tag. 
 * 4. The system ssks confirmation.
 * 5. The user confirms.
 * 6. The system associates selected contact to inserted tag.
 * 
 * <p>
 * <img src="core10.1.3_analysis_SearchTags.png" alt="image">
 * <p>
 * <b>Use Case "Contacts with Tags (Search Tags)": </b>
 * 1. The user insert a tag to search. 
 * 2. The system returns a list of tags with associated contacts. 
 * 3. The user selects a contact out of the list and clicks on it. 
 * 4. The system returns editable contact.
 * 5. The user edits contact.
 * 6. The system saves edited contact.
 *
 * <h2>4. Design</h2>
 * <p>
 * <img src="core10.1.3_design_AssociateTags.png" alt="image">
 * <p> 
 * 
 * <h2>5. Implementation</h2>
 * <p>
 * {@link lapr4.blue.s3.core.n1140948.contactstag}
 * <br> {@link lapr4.blue.s3.core.n1140948.contactstag.controller}
 * <br> {@link lapr4.blue.s3.core.n1140948.contactstag.domain}
 * <br> {@link lapr4.blue.s3.core.n1140948.contactstag.ui}
 * <br> {@link lapr4.blue.s3.core.n1140948.contactstag.persistance}
 * <br> {@link lapr4.blue.s3.core.n1140948.contactstag.persistance.jpa}
 *  
 *
 * <h2>Work Log</h2>
 * <b>Daily Log (Monday 12/06/2017) - </b>
 * <p> 
 *      TEAM BLUE	
 *              <p>
 *		1. Finalizacao da Sprint 2 (IPC02.2)
 * 
 * <p>
 * <b>Daily Log (Tuesday 13/06/2017) - </b>
 * <p>
 *      TEAM BLUE	
 *              <p>
 *		1. Apresentacao da Sprint 2 (IPC02.2)
 *              <p>
 *              2. Inicio da sprint 3
 *              <p>
 *              3. Distribuicao dos use cases da sprint 3
 * 
 * <p>
 * <b>Daily Log (Wednesday 14/06/2017) - </b>
 * <p>
 *      TEAM BLUE	
 *              <p>
 *		1. Apresentacao da Sprint 2 (Melhoria)
 *              <p>
 *              2. Inicio da analise Core10.1.3
 * 
 * <p>
 * <b>Daily Log (Thursday 15/06/2017) - </b>
 * <p>
 *      TEAM BLUE	
 *              <p>
 *		1. Finalizacao da analise 
 *              <p>
 *              2. Inicio da implementacao
 *              <p>
 *              3. Melhoramento do caso de uso anterior necessario para este 
 *              caso de uso (Core10.1.2).
 * 
 * <p>
 * <b>Daily Log (Friday 16/06/2017) - </b>
 * <p>
 * 
 * <b>Daily Log (Monday 19/06/2017) - </b>
 * <p>
 * 
 * @author Tiago Silvestre
 */
package lapr4.blue.s3.core.n1140948.contactstag;
