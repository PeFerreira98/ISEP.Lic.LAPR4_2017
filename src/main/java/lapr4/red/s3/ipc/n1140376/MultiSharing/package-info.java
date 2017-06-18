/**
 * Technical documentation regarding the user story IPC01.3: Multiple Sharing.<p>
 * <p>
 * <b>Attention: This feature is completly implelemnted! </b><p>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b><p>
 * <b>Area Leader: -(yes/no)- no</b><p>
 * <p>
 * <b>Requirement</b><p>
 * It should be possible to have multiple cell shares active at the same time.<p>
 * Each of the shares should have a unique name.<p>
 * The location (i.e., range address) of the share in each instance of Cleansheets may be different.<p>
 * It should be possible to share ranges that include cells with formulas.<p>
 * <p>
 * 
 * <h2>Analysis</h2>
 * <p>
 * This use case is intended to the users of cleansheets application, so they
 * share the cells content between pcs
 * <p>
 * To accomplish that objective, this use case will add on the previous 2 UCs related, and add upon it
 * this app should be able to have multiple cell shares active at the same time and each of the shares should have
 * a unique name, the location (i.e., range address) of the share in each instance of Cleansheets may be different and 
 * it should be possible to share ranges that include cells with formulas.
 * <p>
 * Therefore for the first functionality (multiple cell shares active at the same time) i will
 * add onto the already implemented methods and add an array of peers, to which we will share the cells
 * in question
 * <p>
 * The second funcionality (laction of the share may be different), this function is
 * still in development.
 * <p>
 * Finally, the third funcionality (allow formula), to do this we shall
 * share the content of the cells and no the values whitin, doing this
 * the formulas in the cell can be shared.
 * 
 * 
 * Issue in Jira:
 * <a href="https://jira.dei.isep.ipp.pt:8443/browse/LAPR4E17DL-77">LAPR4E17DL-77</a>
 * 
 * <b>Design</b><p>
 * <h3>First "analysis" sequence diagram</h3>
 * <p>
 * <img src="ipc01.3_analysis.png" alt="image">
 * <p>
 * <h3>First "Design" sequence diagram</h3>
 * <p>
 * <img src="ipc01.3_sequence_diagram.png" alt="image">
 * <p>
 * <p>
 * <b>Classes</b><p>
 * StylableCellDTO<p>
 * SharingAutomaticUpdateCellListener<p>
 * UIStartSharing (Changed)<p>
 * ShareCellsPanel (Changed)<p>
 * <p>
 * <b>Work Log</b><p>
 * <b>Daily Log (Monday 05/06/2017) - </b>
 * Sprint2 LANG use cases presentation. Closing Sprint2. New Issues Attribution.<p>
 * 
 * <b>Daily Log (Tuesday 06/06/2017) - </b>
 * Use case analysis and study.<p>
 * 
 * <b>Daily Log (Wednesday 07/06/2017) - </b>
 * Analysis continuation. Start Implementation.<p>
 * 
 * <b>Daily Log (Thursday 08/06/2017) - </b>
 * Implementation continuation. Start design along implementation.<p>
 * 
 * <b>Daily Log (Friday 09/06/2017) - </b>
 * Implementation end. Design continuation. Starting tests.<p>
 * 
 * <b>Daily Log (Monday 12/06/2017) - </b>
 * Implementation Done.<p>
 * 
 *<h2>Other Points</h2>
 *
 * In this increment all the core functions where already implemented,
 * because of this, doing any additional teste is irrelevant, since all the new methods
 * created were adapted from previous ones, the only difference being, they apply
 * too various peers instead of one.
 * 
 * @author 1140376@isep.ipp.pt(1140376)
 */
package lapr4.red.s3.ipc.n1140376.MultiSharing;
