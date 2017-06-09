/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.ipc.n1140618.ChatApplication.controller;

import java.util.ArrayList;
import java.util.Observer;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUser;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ChatUsersStorage;
import lapr4.blue.s2.ipc.n1140956.ChatApplication.ConversationStorage;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;
import lapr4.green.s1.ipc.n1140618.ChatApplication.ui.ReceiveMessage;
import lapr4.green.s1.ipc.n1140618.ChatApplication.ui.SendMessage;
import lapr4.green.s1.ipc.n1151211.comm.BroadcastServer;
import lapr4.green.s1.ipc.n1151211.comm.CommClientWorker2;
import lapr4.green.s1.ipc.n1151211.comm.CommHandler2;
import lapr4.green.s1.ipc.n1151211.comm.CommServer2;
import lapr4.green.s1.ipc.n1151211.comm.ListenerServer;
import lapr4.green.s1.ipc.n1151211.comm.PeerService;
import lapr4.green.s1.ipc.n1151211.comm.SendDto;

/**
 *
 * @author Tiago
 */
public class ChatApplicationController implements CommHandler2 {

    private String peerId = "Teste";

    private CommServer2 commServer;

    private ListenerServer listenerServer;

    private BroadcastServer broadcastServer;

    private boolean status = true;

    private Message mess;

    private ChatUsersStorage lst_Users;

    private ConversationStorage lst_Conversations;

//    private Properties appProps;
//    private final UserRepository userRepo;
//    private final PersistenceContext persistenceContext;
//    private final ExtensionSettings extensionSettings;
    /**
     * Creates a new Controller
     */
    public ChatApplicationController(/*Properties props*/) {

//        this.appProps = props;
//        this.extensionSettings = new ExtensionSettings(this.appProps);
//        this.persistenceContext = new PersistenceContext(this.extensionSettings);
//        this.userRepo = this.persistenceContext.repositories().user();
        if (CommServer2.getServer() == null) {
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (ListenerServer.getServer() == null) {
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (BroadcastServer.getServer() == null) {
            JOptionPane.showMessageDialog(null, "Server not initialized!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        this.commServer = CommServer2.getServer();
        this.listenerServer = ListenerServer.getServer();
        this.broadcastServer = BroadcastServer.getServer();
        this.lst_Users = new ChatUsersStorage();
        commServer.addHandler(Message.class, this);
        broadcastServer.broadcastThisService(new PeerService("Chat", true));

        this.lst_Conversations = new ConversationStorage();

    }

    /**
     * verify if the user is connected to the server
     *
     * @return
     */
    public boolean isOnline() {
        return status;
    }

    public void offline() {
        this.status = false;
    }

    /**
     * Get the user that are connected
     *
     * @return
     */
    public Iterable<String> getOnlineUsers(Observer ui) {

        listenerServer.addObserver(ui);
        return this.listenerServer.getServicePeers(peerId);
    }

    /**
     * Especify the user to who the message will be sent, creating a frame for
     * enter text
     *
     * @param oUser
     */
    public void sendMessage(String oUser) {
        this.mess = new Message();
        mess.setIdDest(oUser);
        mess.setIdOrig(peerId);

        String tmp[] = oUser.split("@");
        String machineName = tmp[0] + "@";
        String id = tmp[1];

        ChatUser chatUser2 = new ChatUser(machineName, id);

//        if (this.lst_Conversations.getConversationUsers(myIp, chatUser2) == null) {
//            SendMessage sm
//                    = new SendMessage(this, new ArrayList<>());
//        } else {
//            SendMessage sm
//                    = new SendMessage(this, this.lst_Conversations.getConversationUsers(cu, chatUser2));
//        }
        
            SendMessage sm
                    = new SendMessage(this, chatUser2, this.lst_Conversations.getConversationUsersTest(chatUser2));
        

    }

    /**
     * Method that will send the message to another user
     *
     * @param text
     */
    public void messageSend(String text) {
        mess.setContent(text);
        
        CommClientWorker2 toPeer = listenerServer.getCommClientWorker2(mess.getIdDest());
        if (toPeer == null) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION TO PEER!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (toPeer.sendDto(mess) == false) {
            JOptionPane.showMessageDialog(null, "NO COMUNICATION!", "Alert!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.lst_Conversations.addMessage(mess);
        }

    }

    public String getUser() {
        return this.peerId;
    }

    public Message getMessage() {
        return this.mess;
    }

    public ListenerServer getListener() {
        return this.listenerServer;
    }

    /**
     * method to receive the message from others. In this case, the destiny of the message is my ip.
     * @param dto the message
     * @param commWorker 
     */
    @Override
    public void handleDTO(Object dto, SendDto commWorker) {
        this.mess = (Message) dto;
        this.peerId = mess.getIdDest();
        String sourceIP = commWorker.peerAddress();
        
        this.mess.setIdOrig(sourceIP);
        this.lst_Conversations.addMessage(mess);
        ReceiveMessage rm = new ReceiveMessage(this, sourceIP);

    }

    @Override
    public Message getLastReceivedDTO() {
        return this.mess;
    }

    public void addChatUser(ChatUser cu) {
        this.lst_Users.addUser(cu);
    }

//    public ChatUser addUser(ChatUser cu) throws DataConcurrencyException, DataIntegrityViolationException {
//        return this.userRepo.save(cu);
//    }
    public ChatUsersStorage getChatUsersList() {
        return this.lst_Users;
    }
    
    public ArrayList<Message> refreshConversation(ChatUser user){
        return this.lst_Conversations.getConversationUsersTest(user);
    }

//    public Iterable<ChatUser> allContacts() {
//        return this.userRepo.findAll();
//    }
}
