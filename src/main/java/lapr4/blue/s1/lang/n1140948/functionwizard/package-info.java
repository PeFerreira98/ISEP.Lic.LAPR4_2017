/**
 * Technical documentation regarding the user story Lang04.1: Insert Function Basic Wizard.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * TODO: Edit at the end of the sprint
 *
 * <h2>2. Requirement</h2>
 * Cleansheets should have a menu option to launch a wizard to aid the user in
 * calling functions in formulas. This new window should display a list of
 * possible functions. The construction of this list should be made dynamically
 * based on the properties file and self-description of the functions. When a
 * function is selected in the list its syntax should be displayed in a edit
 * box. The 'syntax' should include the name of the functions and its
 * parameters. For example, for the factorial function, that only has one
 * parameter, the following text should be displayed in the edit box '=
 * FACT(Number)'. The window should also contain an area to display a text
 * describing the selected function (i.e., help text). The window should have an
 * 'Apply' and a 'Cancel' button. If the user selects the 'Apply' button the
 * text of the syntax of the function should be written in the formula bar.
 *
 * <p>
 * <b>Use Case "Insert Function Basic Wizard": </b>
 * The user selects the function wizard option. 
 * The system launches function wizard. 
 * The system displays list of possible functions. 
 * The user selects a function.
 * The system shows function syntax in edit box [function name,parameteres].
 * The system shows help text describing selected function. 
 * The user selects 'Apply' button.
 * The system writtes function syntax in the formula bar. 
 * The system closes Function Wizard. 
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
 * <img src="lang04.1_analysis.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to add a new "attribute" to a
 * cell: "comment". Therefore, at this point, we need to study how to add this
 * new attribute to the class/interface "cell". This is the core technical
 * problem regarding this issue.
 *
 * <h2>4. Design</h2>
 * <p>
 * <img src="lang04.1_design.png" alt="image">
 * <p>
 *
 * <h3>4.1. Functional Tests</h3>
 * TODO: in next phase
 * <p>
 *
 * <h3>4.2. UC Realization</h3>
 * To realize this user story we will need to create a UI for the FunctionWizard. 
 * We will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. 
 * 
 * <h3>4.3. Classes</h3>
 * Here we can se the class diagram developed for this use case: 
 * <p>
 * <img src="lang04.1_classDiagram.png" alt="image">
 * <p>
 * Where in lightgray we have the already existing classes and in white we have
 * the newly created classes. C means class and I means interface.
 * 
 * <h2>5. Implementation</h2>
 *
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 *
 * <h2>6. Integration/Demonstration</h2>
 *
 * -In this section document your contribution and efforts to the integration of
 * your work with the work of the other elements of the team and also your work
 * regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 *
 * <h2>7. Final Remarks</h2>
 *
 * -In this section present your views regarding alternatives, extra work and
 * future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if
 * the cell has a comment. This "feature" is not documented in this page.
 *
 *
 * <h2>8. Work Log</h2>
 *
 * <p>
 * <b>Daily Log (Monday 29/05/2017)</b>
 * <p>
 *	TEAM BLUE
 *		1. Definição das versões dos programas a usar com as restantes equipas, por motivos de compatibilidade;
 *		2. Leitura do manual e discussão sobre ele;
 *		3. Identificação dos diferentes tokens;			
 *		4. Instalação dos plugins necesários para a abertura do projeto;
 *		5. Análise de JavaDocs do projeto,
 *		6. Distribuição de casos de uso pelos diferentes elementos da equipa.
 * <p>
 * <b>Daily Log (Tuesday 30/05/2017)</b>
 * <p>	
 *	TEAM BLUE		
 *		1. Definição do Scrum Master (Pedro Ferreira);
 *		2. Análise dos casos de uso "Lang01.1", "Lang02.1", "Lang03.1", "Lang04.1";
 *		3. Análise do código fornecido referente à parte de Lang;
 *		4. Criação do package para documentação do use case "Lang04.1"
 *		5. Atribuição das tarefas no JIRA e criação de sub-tasks [Analysis, Design, Implementation, Testing].
 * <p>
 * <b>Daily Log (Wednesday 31/05/2017)</b>
 * <p>	
 *	TEAM BLUE	
 *		1. Documentação do use case Lang04.1
 *		2. Construção de SSD e análise do use case
 *
 * <b>Daily Log (Thursday 01/06/2017)</b>
 * <p>	
 *	TEAM BLUE	
 *		1. Conclusão da análise e início da implementação do caso de uso
 *		2. Criação da GUI para o function Wizard
 *              3. Implementação dos botões
 * 
 * <b>Daily Log (Friday 02/06/2017)</b>
 * <p>	
 *	TEAM BLUE	
 *		1. Continuação da implementação do caso de uso
 *		2. Implementação das listas de funções disponíveis
 *              3. Apresentação da syntax da função selecionada
 * 
 * <b>Daily Log (Saturday 03/06/2017)</b>
 * <p>	
 *	TEAM BLUE	
 *		1. Finalização da implementação
 *		2. Início e finalização do design
 * 
 * 
 * @author Tiago Silvestre
 */
package lapr4.blue.s1.lang.n1140948.functionwizard;
