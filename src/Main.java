//import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * user interface for voting system
 * @author Nika Soltani Tehrani
 * @version 1.0.0
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static VotingSystem votingSystem = new VotingSystem();

    public static void main(String[] args) {
        int input = 1;

        while(input != 0){

            System.out.println("1. create voting");
            System.out.println("2. print list of all votings");
            System.out.println("3. print an specific voting");
            System.out.println("4. create a vote");
            System.out.println("5. create a random vote");
            System.out.println("6. print result of voting");
            System.out.println("7. add choices to a voting");
            System.out.println("0. exit");
            input = scanner.nextInt();
            scanner.nextLine();

            if(input == 1){
                createVoting();
            }
            else if(input == 2){
                printAllVotings();
            }
            else if(input == 3){
                printVoting();
            }
            else if(input == 4){
                createVote();
            }
            else if(input == 5){
                createRandVote();
            }
            else if(input == 6){
                printResult();
            }
            else if(input == 7){
                addChoiceToVoting();
            }

        }

    }

    /**
     * This method creates a new voting
     */
    private static void createVoting(){
        String question;
        int type;

        System.out.println("enter the question:");
        question = scanner.nextLine();

        System.out.println("enter the type (0 for one choice only, 1 for multiple choices):");
        type = scanner.nextInt();
        scanner.nextLine();
        votingSystem.createVoting(question,type);
    }

    /**
     * This method adds choice to a specific voting
     */
    private static void addChoiceToVoting(){

        int votingIndex;
        System.out.println("enter voting index:");
        votingIndex = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the available choices separating them by white space (enter DONE when done):");
        int flag = 1;
        String choice;

        while(flag != 0){
            choice = scanner.nextLine();
            if(choice.equals("DONE")){
                flag = 0;
            }
            else{
                votingSystem.getVotingList().get(votingIndex).createPoll(choice);
            }
        }
    }

    /**
     * This method prints all active votings
     */
    private static void printAllVotings(){
        for (int i = 0; i < votingSystem.getVotingList().size() ; i++) {
            votingSystem.printVotings(i);
        }
    }

    /**
     * This method prints info of a specific voting
     */
    private static void printVoting(){
        int index;

        System.out.println("enter the voting index:");
        index = scanner.nextInt();
        scanner.nextLine();

        votingSystem.printVotings(index);
    }

    /**
     * This method creates a new vote
     */
    private static void createVote(){
        System.out.println("enter the voting index:");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the voter first name:");
        String firstName = scanner.nextLine();

        System.out.println("enter the voter last name:");
        String lastName = scanner.nextLine();

        Person voter = new Person(firstName, lastName);

        //adding the choices
        System.out.println("enter the choices separating them by white space (enter DONE when done):");
        int flag = 1;
        String choice;
        ArrayList<String> choices = new ArrayList<>();

        while(flag != 0){
            choice = scanner.nextLine();
            if(choice.equals("DONE")){
                flag = 0;
            }
            else{
                choices.add(choice);
            }
        }

        votingSystem.vote(index, voter, choices);
    }

    /**
     * This method creates a new vote
     */
    private static void createRandVote(){
        System.out.println("enter the voting index:");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter the voter first name:");
        String firstName = scanner.nextLine();

        System.out.println("enter the voter last name:");
        String lastName = scanner.nextLine();

        Person voter = new Person(firstName, lastName);
        votingSystem.randVote(index, voter);
    }
    /**
     * This method prints the result of the voting
     */
    private static void printResult(){
        System.out.println("enter the voting index:");
        int index = scanner.nextInt();
        scanner.nextLine();

        votingSystem.getResult(index);
    }

}