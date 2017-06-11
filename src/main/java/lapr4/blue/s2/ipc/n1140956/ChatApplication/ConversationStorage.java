/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;

import java.util.ArrayList;
import lapr4.green.s1.ipc.n1140618.ChatApplication.Message;

/**
 *
 * @author Marcos
 */
public class ConversationStorage {
    
    private ArrayList<Message> lst_Conversations = new ArrayList<>();

    public ConversationStorage() {
        lst_Conversations = new ArrayList<>();
    }
   
    public ArrayList<Message> getLst_Conversations() {
        return lst_Conversations;
    }

    public void addMessage(Message message){
        this.lst_Conversations.add(message);
    }
    
    public ArrayList<Message> getConversationUsers(ChatUser chatUser1, ChatUser chatUser2){
        ArrayList<Message> tmp = new ArrayList<>();
        
        for(Message m : this.lst_Conversations){
            if((m.getIdOrig().equals(chatUser1) && m.getIdDest().equals(chatUser2))||
                    (m.getIdOrig().equals(chatUser2) && m.getIdDest().equals(chatUser1))){
                tmp.add(m);
            }
        }
        return tmp;
    }
    
    public ArrayList<Message> getConversationUsersTest(ChatUser chatUser){
        ArrayList<Message> tmp = new ArrayList<>();
        
        for(Message m : this.lst_Conversations){
            if((m.getIdDest().equals(chatUser.getMachineName()+chatUser.getIp()))||
                    (m.getIdOrig().equals(chatUser.getMachineName()+chatUser.getIp()))){
                tmp.add(m);
            }
        }
        return tmp;
    }
    
}
