/**
 * Technical documentation regarding the user story 064: share sheet. 
 * <p>
 * 
 * <b>Requirement</b><p>
 * Permitir estabelecer uma conexão com uma outra instância do cleansheets e enviar um range de celulas para a outra instância. O conteúdo recebido deve ser apresentado no mesmo “local”. Para isso, em cada instância do cleansheets deve ser possível definir uma porta para ligações.
 * <p>
 * The user should be able to define a specific TCP port for cleansheets to use.
 * <p>
 * The same TCP connection should be shared by all the communication functionalities of the cleansheets application. 
 * <p>
 * There should be a specific port to respond to UDP datagrams broadcasted by clients to discover instances of cleansheets in the local network.
 * <p>
 * 
 *  
 * <b>S064a: Analysis</b><p>
 * <img src="us064_analysis.png" alt="image"> 
 * <p>
 * <b>Notes:</b><p>
 * class CommWorker: This class is a thread that has the responsibility of communicating with the client.<p>
 * One possibility is for this class to handle in the same socket all the communications with the same client.<p>
 * For this to work we could implement a pattern like "producer-consumer" where CommWorker would be producer and we could have several consumers for each type of subclass of DTO (Data Transfer Object).<p>
 * According to the type of DTO CommWorker would "pass" control to the specific consumer that would "handle" the received DTO.<p>
 * Maybe a similar approach could be used in the client side? For instance, to deal with a server notification indicating that a cell has been updated in the server and needs to be updated as well in the client.<p>
 * CommServer should be singleton. <p>
 * There should also be a CommClient (singleton). This CommClient should be used to establish a connection with a server and handle synchronous and asynchronous communication. Asynchronous communication should be handled in a manner similar to the server side (with a thread?).<p>  
 * 
 * <b>S064t: Tests</b><p>
 * This should include not only unit tests (e.g., class-oriented tests) but also use case tests (e.g., like in the TDD approach). <p>
 *
 * <b>Test1:</b> BaseEchoCommunicationTest<p>
 * There should be a simple echo service that should return the echo of each message received.<p>
 * See Package csheets.ext.ipc.comm:<p>
 * BaseEchoCommunicationTest, EchoClientHandler, EchoDTO, EchoServerHandler<p>
 * 
 * <b>Test2:</b> ShareCellTest<p>
 * Test the initial connection regarding the sharing of the contents of a single cell.<p>
 * See Package csheets.ext.ipc.comm.sharecells:<p>
 * ShareCellsTest<p>
 * 
 * 
 * 
 * <b>S064d: Design</b><p>
 * First draft regarding the design.<p>
 * Will start by illustrating a scenario regarding the use of the CommWorker class.<p>
 * <b>Important Note:</b> Maybe all this functionality should be integrated with the extensions. For instance, extensions could "register" communication servers and asynchronous client handlers. The data (i.e. DTO) would be dispatched according to its type<p> 
 * 
 * <img src="us064_design1.png" alt="image"> 
 * <p>
 * 
 *
 * 
 * <img src="us064_design2.png" alt="image"> 
 * <p>
 *  
 * <b>S064c: Code</b><p>
 * The following classes and interfaces implement this use case.<p>
 * Package lapr4.black.s1.ipc.n2345678.comm:<p>
 * {@link lapr4.black.s1.ipc.n2345678.comm.CommClientWorker}
 * {@link lapr4.black.s1.ipc.n2345678.comm.CommExtension}
 * {@link lapr4.black.s1.ipc.n2345678.comm.CommHandler}
 * {@link lapr4.black.s1.ipc.n2345678.comm.CommServer}
 * {@link lapr4.black.s1.ipc.n2345678.comm.CommServerWorker}
 * <p>
 * Package lapr4.black.s1.ipc.n2345678.comm.sharecells:<p>
 * {@link lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO}
 * {@link lapr4.black.s1.ipc.n2345678.comm.sharecells.HandleReceiveCells}
 * {@link lapr4.black.s1.ipc.n2345678.comm.sharecells.RequestSharedCellsDTO}
 * {@link lapr4.black.s1.ipc.n2345678.comm.sharecells.ResponseSharedCellsDTO}
 * <p>
 * Package lapr4.black.s1.ipc.n2345678.comm.ui:<p>
 * {@link lapr4.black.s1.ipc.n2345678.comm.ui.ClientTestAction}
 * {@link lapr4.black.s1.ipc.n2345678.comm.ui.CommMenu}
 * {@link lapr4.black.s1.ipc.n2345678.comm.ui.UICommExtension}
 * <p>
 * 
 * 
 * @author alexandrebraganca
 */
package lapr4.black.s1.ipc.n2345678.comm;

