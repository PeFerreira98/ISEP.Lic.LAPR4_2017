/**
 * Technical documentation regarding the user story IPC01.2: Sharing Automatic Update.<p>
 * <p>
 * <b>Attention: This feature increment and this documentation are work in progress! </b><p>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b><p>
 * <b>Area Leader: -(yes/no)- no</b><p>
 * <p>
 * <b>Requirement</b><p>
 * Once a connection is established between two instances of Cleansheets updates 
 * made in one side must be automatically sent to the other side. <p>
 * The data shared must include now also the style of the cells.<p>
 * At the moment It is not necessary to support the sharing of cells with formulas.<p>
 * <p>
 * <b>Design</b><p>
 * The following sequence diagram and class diagram represents this use case:
 * <p>
 * <img src="ipc01.2_classDiagram.png" alt="image">
 * <p>
 * <p>
 * <img src="ipc01.2_sequenceDiagram.png" alt="image">
 * <p>
 * <p>
 * <b>Classes (change)</b><p>
 * Variable<p>
 * Temporary<p>
 * TemporaryStorage<p>
 * TemporaryReference<p>
 * FormulaEvalVisitor (Changed)<p>
 * Formula3.g4 (Changed)<p>
 * AssignmentOperator (Changed)<p>
 * <p>
 * <b>Work Log</b><p>
 * <b>Daily Log (Monday 05/06/2017) - </b>
 * Sprint1 IPC use cases presentation. Closing Sprint1. New Issues Attribution.<p>
 * 
 * <b>Daily Log (Tuesday 06/06/2017) - </b>
 * Use case analysis & study. Documentation Creation.<p>
 * 
 * <b>Daily Log (Wednesday 07/06/2017) - </b>
 * Analysis continuation. Start Design. <p>
 * 
 * <b>Daily Log (Thursday 08/06/2017) - </b><p>
 * <b>Daily Log (Friday 09/06/2017) - </b><p>
 * <b>Daily Log (Monday 12/06/2017) - </b><p>
 * 
 * 
 * @author pedroferreira(1140953)
 */
package lapr4.blue.s2.ipc.n1140953.sharing;
