/**
 * Technical documentation regarding the user story Lang02.1: Temporary Variables.<p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! </b><p>
 * 
 * <b>Scrum Master: -(yes/no)- yes</b><p>
 * <b>Area Leader: -(yes/no)- yes</b><p>
 * 
 * <b>Requirement</b><p>
 * Add support for temporary variables. 
 * The name of temporary variables must start with the "_" sign. 
 * When a variable is referred in a formula for the first time it is created. 
 * To set the value of a variable it must be used on the left of the assign operator (":="). 
 * Temporary variables are variables that only exist in the context of the execution of a formula. 
 * Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances.
 * 
 * <b>Design</b><p>
 * The following sequence diagram and class diagram represents this use case:
 * <p>
 * <img src="lang02.1_classDiagram.png" alt="image">
 * <p>
 * <p>
 * <img src="lang02.1_sequenceDiagram.png" alt="image">
 * <p>
 * 
 * <b>Classes</b><p>
 * Variable<p>
 * Temporary<p>
 * TemporaryStorage<p>
 * TemporaryReference<p>
 * FormulaEvalVisitor (Changed)<p>
 * Formula3.g4 (Changed)<p>
 * AssignmentOperator (Changed)<p>
 * 
 * 
 * @author pedroferreira(1140953)
 */
package lapr4.blue.s1.lang.n1140953.variables;
