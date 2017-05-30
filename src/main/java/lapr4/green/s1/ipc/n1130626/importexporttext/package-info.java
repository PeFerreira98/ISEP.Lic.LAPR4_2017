/**
 * Technical documentation regarding the user story IPC04.1: Import/Export Data.
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * It should be possible to export and import data to/from a text file. Each line in the text file represents
 * a row of data. In each line a special character is used to separate columns. The user should be able to
 * configure this character and also define if the first line of the text file should be treated as containing the
 * header of the columns or as regular row. The user should also enter a range of cells to be used as source
 * (export) or destination (import) for the operation.
 * <p>
 * Notes:
 * <p>
 * If the user selects the import option, he must write a valid text file name
 * <p>
 * If the user selects the export option, the system creates a text file with a name created by the user
 * <p>
 *
 *
 * <b>Analysis</b><p>
 * <img src="ipc04.1_analysis.png" alt="image">
 * <p>
 * <b>Notes:</b><p>
 * In this analysis section, it was created a SSD to simulate a scenario between the system and the user<p>
 * in this respective use case.<p>
 * It is simulating a best case scenario.<p>
 * 
 *
 * <b>Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also
 * use case tests (e.g., like in the TDD approach).
 *
 *
 *
 *
 * <b>Design</b><p>
 *
 * <p>
 *
 * <b>Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.green.s1.ipc.n1130626.importexporttext:
 *
 *
 * @author Pedro Pereira
 */
package lapr4.green.s1.ipc.n1130626.importexporttext;
