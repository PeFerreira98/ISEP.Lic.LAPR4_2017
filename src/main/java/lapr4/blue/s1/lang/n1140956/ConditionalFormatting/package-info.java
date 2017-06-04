/**
 * Technical documentation regarding the user story Lang03.1: Conditional Formatting of Cells.
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! </b><p>
 *
 * <b>Requirement</b><p>
 * Update the "style" extension so that it can be used for the conditional formatting of cells based on the
result of the execution of formulas. For the style of a cell to be conditional it must have an associated
formula and two formatting styles. One of the styles is applied when the formula evaluates to true and
the other when it evaluates to false. The editing of these settings should be done in a sidebar window.

 * <b>Attention:</b><p> 
 * 
 * <b>Analysis</b><p>
 * This tool is located on "style" extension. After opening the "style" extension we choose the "Conditional Formating" option
 * When the tool is running the user needs to provide the expression he wants and the associated two formatting styles.
 * In the end, one of the styles will be applied. This could be done on the sidebar window too.
 * 
 * <b>Notes</b><p>
 *
 * <b>storeContent</b><p>
 *
 * <b>Tests</b><p>
 * <b>Test2:</b> CondFormattingControllerTest<p>
 * Test if the listener was added correctly to the cell<p>
 * See Package lapr4.blue.s1.lang.n1140956.ConditionalFormatting:<p>
 * CondFormattingControllerTest<p>
 * 
 * <b>Design</b><p>
 *<img src="lang03.1_design.png" alt="image"> 
 * <p>
 * 
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.blue.s1.lang.n1140956.ConditionalFormatting:<p>
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.CondFormattingController}
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.FormattingExtension}
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.CondFormattingListener}
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.CondFormattingAction}
 * 
 * <p>
 * Package lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui:<p>
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui.CondFormDialog}
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui.FormatingPanel}
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui.FormattingCells}
 * {@link lapr4.blue.s1.lang.n1140956.ConditionalFormatting.ui.UIExtensionFormattingCells}
 * 
 * @author Marcos Dourado (1140956)
 */
package lapr4.blue.s1.lang.n1140956.ConditionalFormatting;
