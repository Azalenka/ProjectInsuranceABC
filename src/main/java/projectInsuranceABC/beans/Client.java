package projectInsuranceABC.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Client implements Person {
    private int id;
    private String login;
    private String psswd;
    private  String firstname;
    private String secondname;
    private String surname;

    private Account account;

    public Client(String login, String psswd,String firstname,String secondname,String surname){
        this.login= login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
    }
   public Client (int id, String login, String psswd,String firstname,String secondname,String surname){
       this.id= id;
        this.login= login;
       this.psswd = psswd;
       this.firstname = firstname;
       this.secondname = secondname;
       this.surname = surname;
   }
    public Client (int id, String firstname,String secondname,String surname){
        this.id= id;
       this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;}
    public Client(int id, String firstName, String secondName, String surname,Account account ) {

        this.id= id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
     this.account= account; }
   public Client (){}



    public Client(String surname, String login, String psswd, String firstname, String secondname, Account account) {
        this.login= login;
        this.psswd = psswd;
        this.firstname = firstname;
        this.secondname = secondname;
        this.surname = surname;
         this.account = account;
    }


    public String getFullName(){
        return String.join(" ", surname, firstname, secondname);
    }


    }

