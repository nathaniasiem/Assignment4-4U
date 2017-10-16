/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author simon7323
 */
public class Human {

    //define instance variables
    //hide them away
    private String name;
    private int age;
    private char gender;
    
    //create a constructor 
    //used to build human(template-)
    // "this." refers to the instance variables that is forever running in the program
    //without "this." would refer to the local variable of the method
    public Human(String name,int age,char gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public char getGender(){
        return gender;
    }
    
    public void celebrateBday(){
        //increase human age
        age++;
        //wish them a happy birthday
        System.out.println("Happy Birthday "+this.name+ '!');
    }
  
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a variable of a human with the characteristics
        Human bob=new Human("Bob",20,'M');
        System.out.println(bob.getAge());
        System.out.println(bob.getName());
        System.out.println(bob.getGender());
        
        //create another variable of a human with different characteristics
        Human alice =new Human("Alice",51,'F');
        System.out.println(alice.getName());
        alice.celebrateBday();
        System.out.println(alice.getAge());
    }
}
