package entity;

public class Student extends User {
       private int submitNumber;
       private int acceptNumber;
       public Student(String userName, String passWord, String nicoName, String phoneNumber, Type type, boolean listenMessage,
                      int submitNumber, int acceptNumber){
           super(userName, passWord, nicoName, phoneNumber, type, listenMessage);
           this.submitNumber =submitNumber;
           this.acceptNumber =acceptNumber;
       }
       public Student(){
           super();
       }
       public int getSubmitNumber(){
           return this.submitNumber;
       }
       public int getAcceptNumber(){
           return this.acceptNumber;
       }
       public void setSubmitNumber(int submitNumber){
           this.submitNumber =submitNumber;
       }
       public void setAcceptNumber(int acceptNumber){
           this.acceptNumber =acceptNumber;
       }
}
