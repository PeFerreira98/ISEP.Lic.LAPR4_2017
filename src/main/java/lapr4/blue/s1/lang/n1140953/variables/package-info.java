/**
 * Technical documentation regarding the user story Lang02.1: Temporary Variables. 
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! </b><p>
 *
 * <b>Requirement</b><p>
 * Add support for temporary variables. 
 * The name of temporary variables must start with the "_" sign. 
 * When a variable is referred in a formula for the ﬁrst time it is created. 
 * To set the value of a variable it must be used on the left of the assign operator (":="). 
 * Temporary variables are variables that only exist in the context of the execution of a formula. 
 * Therefore, it is possible for several formulas to use temporary variables with the same name and they will be different instances. 
 * Example: "= {_Counter:=1; WhileDo(Eval( "A"&_Counter)> 0; {C1:=C1+Eval("B"&_Counter); _Counter:=_Counter+1 }) }” . 
 * In this example, the cell C1 will get the sum of all the values of column B in that the corresponding values in column A are greater than zero. 
 * 
 * <b>Attention:</b><p> 
 *
 * <b>Analysis</b><p>
 * 
 * <b>Notes</b><p>
 *
 * <b>storeContent</b><p>
 *
 * <b>Tests</b><p>
 * 
 * <b>Design</b><p>
 *
 * <b>Code</b><p>
 * 
 * @author pedroferreira(1140953)
 */
package lapr4.blue.s1.lang.n1140953.variables;
