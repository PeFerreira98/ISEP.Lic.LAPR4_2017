/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Technical documentation regarding the IPC - Inter-process Communication Features
 * <p>
 *
 * <b>Requirement</b>
 * <p>Statement:</p>
 * <b>Inter-process Communication Features:</b>
 * <p>Allows existing services on the Clean Sheets instance to register their 
 * existence and status in order to be advertised to other peers.</p>
 * Allows the announcement of the services present in the Clean Sheets instance
 * and its active or inactive state.
 * <p>Listen to the advertisement for other Clean Sheets in the same local area network.</p>
 * It provides the information about the peers found in the local network
 * and their services for use by other classes.
 * <p>Allows sending objects to other peers in the network.</p>
 * It receives objects from other peers on the network and routes them to the appropriate local methods.
 * <p>Allows you to change the port number used to communicate with other peers.</p>
 * 
 * 
 *
 *
 * <h2>Analysis</h2>
 * <p>The requirements show that it is necessary to advertise local services to other
 * CleanSheets on the local network and consequently the need to listen to the
 * advertisements made by those CleantSheets.
 * This leads to the need for two UDP-based services. One to advertise and one to listen to.</p>
 * To transmit the information the best solution is TCP connections.
 * To encapsulate the information in the network uses the functionality of java 
 * that allows the serialization of objects. As a consequence of this serialization,
 * a tcp connection between two instances is sufficient to transmit the objects.
 * This is because java can recognize which object classes are passed and based
 * on that information forward the received object to an appropriate method.
 * All instances are required to be able to accept connections and make connections
 * to / from other instances. The connections to the other instances are made with the
 * information collected from the ads made by those same instances on the local network.
 * 
 * 
 * <h2>Design</h2>

* <p>This extension is based on the partially implemented code provided with the initial project.
* It was decided to redo the code instead of extending it because it was not completely implemented
* and because in the presentation the client was told to choose to use it or not.</p>
* Communications extension provides services that allow other extensions to announce their existence,
* to detect the presence of other and communicate with them, all over the local network.
* <p></p>
* <img src="CommExtension2.png" alt="image"> 
* <p></p>
* <p>These services are provided by three classes instantiated by the 'CommExtensao2' extension. These classes are:</p>
* <b>CommServer2</b> - listen on a tcp socket, on a configurable port, by calls from other instances in the local network.
* Once established the connection allows the transfer of objects between the connected instances.
* The extensions that use these services have to previously register the classes that will receive and which methods are going to process them.
* <p></p>
* <b>CommServer2</b>
* <img src="CommServer2.png" alt="image"> 
* <p></p>
* <p></p>
* <p><b>ListenerSever</b> - listen on a UDP port for ads from other instances of cleanSheets.
* Saves that information that is available for other extensions to use.
* With the saved information it connects to other instances when requested.
* Once the connection is made it is possible to send and receive Java objects.
* The classes of objects transmitted and received must be registered in Commserver2</p>
* <p></p>
* <p></p>
* <b>Listening to peers</b>
* <p></p>
* <img src="ListenerServer.png" alt="image"> 
* <p></p>
* <p></p>
* <b>Connecting to peer</b>
* <p></p>
* <img src="ListenerServerConnect.png" alt="image"> 
* 
* <b>BroadcastServer</b> - Extensions wishing to provide services over the local network must
* register for this class and indicate whether they are active or not.
* Using a pre-defined UDP port, registered services are advertised on the local network with UDP packets.
* For an extension to register you have to supply a string and a boolean.
* The string indicates the service name and boolean if the service is active or inactive.
* 
* 
 *
 *
 * @author Fernando Borges
 */

package lapr4.green.s1.ipc.n1151211.comm;
