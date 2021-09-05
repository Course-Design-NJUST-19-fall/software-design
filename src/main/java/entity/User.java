package entity;

enum type{STUDENT,TEACHER,MONITOR};
public class User {
    protected String userName;
    protected String passWord;
    protected String nicoName;
    protected String phoneNumber;
    protected boolean listenMessage;
    protected type type;
    public User(String userName,String passWord,String nicoName,String phoneNumber,type type, boolean listenMessage){
        this.userName =userName;
        this.passWord =passWord;
        this.nicoName =nicoName;
        this.listenMessage =listenMessage;
        this.phoneNumber =phoneNumber;
        this.type =type;
    }
    public User(){

    }
    public String getUserName(){
        return this.userName;
    }
    public String getPassWord(){
        return this.passWord;
    }
    public String getNicoName(){
        return this.nicoName;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public boolean getListenMessage(){
        return this.listenMessage;
    }
    public type getType(){
        return this.type;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassWord(String passWord){
        this.passWord =passWord;
    }
    public void setNicoName(String nicoName){
        this.nicoName =nicoName;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber =phoneNumber;
    }
    public void setListenMessage(boolean listenMessage){
        this.listenMessage =listenMessage;
    }
    public void setType(type type){
        this.type =type;
    }

}
