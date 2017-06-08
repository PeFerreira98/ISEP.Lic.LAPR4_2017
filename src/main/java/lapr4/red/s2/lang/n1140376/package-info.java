/**
 * Technical documentation regarding the user story Lang03.2: Conditional Formatting of Ranges.
 * <p>
 * 
 * <b>Attention: This feature increment and this documentation are work in progress! </b><p>
 *
 * <b>Requirement</b><p>
 * Enable Cleansheets to apply conditional formatting to a range of cells (also in the style extension). The
idea is that a single formula could applied to all the cells in the range (one at a time) in order to evaluate
what style to apply. For that to be possible it is necessary to add a new special kind of variable to the
formulas that represents the "current" cell. This special variable could be named "_cell". For instance,
the formula could be associated to a range format.  In this case, Cleansheets would
evaluate the formula for each cell in the range and apply the formatting style in accordance with the
result of the formula. In this example, all cell in the range with a value greater or equal to 10 would
receive the style associated with the true result and the others the style associated with the false result.
The window in the sidebar should also be updated so that it is clear if the format is for a single cell or
for a range. Within the sidebar window it should also be possible to remove existing conditional style
formatting.

 * <b>Attention:</b><p> 
 * 
 * <b>Analysis</b><p>
 * This tool is located on "style" extension. After opening the "style" extension we choose the "Conditional Formating" option
 * When the tool is running the user needs to provide the expression he wants and the associated two formatting styles.
 * In the end, one of the styles will be applied. This could be done on the sidebar window too, in addition to the previous version
 * this formatting can now be applied to a range of cells, and there is the option to clean the current formatting of the selected and cells
 * and see if the current formatting is done to one cell or multiple ones.
 * <img src="lang03.2_analysis.png" alt="image"> 
 * 
 * <b>Notes</b><p>
 *
 * <b>storeContent</b><p>
 *
 * <b>Tests</b><p>
 * <b>Test1:</b> CondFormattingControllerTest<p>
 * Test if the listener was added correctly to the cell<p>
 * See Package lapr4.blue.s1.lang.n1140956.ConditionalFormatting:<p>
 * CondFormattingControllerTest<p>
 * 
 * <b>Design</b><p>
 *<img src="lang03.2_design.png" alt="image"> 
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
 * @author Celso Eusébio (1140376)
 */
package lapr4.red.s2.lang.n1140376;
