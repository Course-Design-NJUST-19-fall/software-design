package entity;

enum Type {STUDENT,TEACHER,MONITOR};
public class User {
    protected String id;
    protected String password;
    protected String nicoName;
    protected String phoneNumber;
    protected boolean listenMessage;
    protected Type type;
    public User(String userName, String password, String nicoName, String phoneNumber, Type type, boolean listenMessage){
        this.id =userName;
        this.password =password;
        this.nicoName =nicoName;
        this.listenMessage =listenMessage;
        this.phoneNumber =phoneNumber;
        this.type =type;
    }
    public User(){

    }
    public String getId(){
        return this.id;
    }
    public String getPassword(){
        return this.password;
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
    public Type getType(){
        return this.type;
    }
    public void setId(String id){
        this.id = id;
    }
    public void setPassword(String password){
        this.password = password;
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
    public void setType(Type type){
        this.type =type;
    }

}
