/**
 * Technical documentation regarding the user story IPC01.1: Cells Sharing - Start Sharing
 * <p>
 *
 * <b>Requirement</b><p>
 * Statement:
 * <p>
 * • IPC01.1) Start Sharing ? !
 * It should be possible to establish a connection with other instance of Cleansheets in the local network. It
 * should be possible to send the contents of a range of cells to another instance of Cleansheets. The other
 * instance should display the received contents in the same cell address as the original cells.
 * It should be possible to configure the port to be used for network connections. It should be possible to
 * find other instances of Cleansheets available in the local network. These instances should be listed in a new
 * window (sidebar window). The user should be able to select one of the discovered instances to connect
 * to when establishing the connection to send the contents of the range of cells. At the moment it is only
 * required to send the value of the cells.
 * 
 * <p>
 * Notes:
 * <p>
 * This use case requires the network service to be up and running.
 * <p>
 * The user can activate and deactivate the service.
* <p>
 *
 *
 * <b>Analysis</b><p>
 * <p>The analysis of this use case makes it clear that a network communications service must also be built.
 * Although the sharing of cells needs it, due to the specifics of the network service I decided
 * to split it into two use cases. This use case deals only with cell sharing.
 * The network service is handled in the case of 'Comm'.</p>
 * 
 * <p>O utilizador deve ser capaz de:</p>
 *<p>activar e desactivar  a partilha</p>
<p>Ver os peers que têm o serviço activo</p>
<p>Selecionar as células que quer partilhar.</p>
<p>Selecionar o peer a quem quer enviar as células.</p>
 * 
 *
 *<p> <b>Tests</b></p>
 * <p>To teste this service is necessary at least 2 peers. </p>
 * 

<p> The user, with CleanSheets running, should be able to:  </p>
<p> 1 View the SharedCells panel  </p>
<p>2 Hide the SharedCells panel  </p>
<p>3 Enable the SharedCells service.  </p>
<p>4 When SharedCells is enabled, the user's computer must be visible to other peers.  </p>
<p>5 With SharedCells off other peers should not be able to see this computer.  </p>
<p>6 choose the cells you want to share.  </p>
<p>7 choose the peer with whom you want to share. </p>
<p>8 choose the spreadsheet </p>
<p>9 when triggering the Shared Cells button, the chosen cells should appear
* in the other peeer in the same spreadsheet and in the same position. </p>
<p>10 be informed of the success of the operation. </p>
 * <p>
 *
 * <p>
 *
 * <b>Design</b><p>
 *
 * <p>
 *
 * <p><b>What is done.</b></p>
 * <p>This use case is done.</p>
 * 
 *<p> What needs improments.</p>
 * <p>Documentation</p>
 * <p>Slpit this use case in two user case. </p>
 * 
 * 
 * @author Fernando Borges
 */
package lapr4.green.s1.ipc.n1151211.StartSharing;

