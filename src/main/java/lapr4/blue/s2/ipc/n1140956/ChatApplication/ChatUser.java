/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140956.ChatApplication;

/**
 *
 * @author Marcos
 */
public class ChatUser {

    private String nickname;
    private String machineName;
    private byte[] image;
    private String ip;
    private boolean status;

    public ChatUser() {

    }

    public ChatUser(String nickname, String machineName, byte[] image, String ip, Boolean status) {
        this.nickname = nickname;
        this.machineName = machineName;
        this.image = image;
        this.ip = ip;
    }

    public ChatUser(String machineName, String ip) {
        this.nickname = "";
        this.machineName = machineName;
        this.ip = ip;
        this.image = new byte[0];
    }

    public void setStatus(Boolean b) {
        this.status = b;
    }

    public boolean isOnline(){
        return this.status;
    }
    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the machineName
     */
    public String getMachineName() {
        return machineName;
    }

    /**
     * @param machineName the machineName to set
     */
    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    /**
     * @return the image
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * return the machine name and ip (eg: MyPc@/192.168.1.85)
     * @return 
     */
    public String getInfo(){
        return this.machineName+this.ip;
    }
}
