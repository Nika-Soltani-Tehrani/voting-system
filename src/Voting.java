/**
 * This class is created to implement a new kind of voting
 */

import ir.huri.jcal.JalaliCalendar;
import java.util.*;

public class Voting {


    private int type;//Only one vote = 0/ Multiple votes = 1
    private String question;
    private ArrayList<Person> voters;
    private ArrayList<Vote> votes = new ArrayList<>();
    private HashMap<String, HashSet<Vote>> polls;


    //constructor
    Voting(int type, String question) {
        this.type = type;
        this.question = question;
        polls = new HashMap<>();
        voters = new ArrayList<>();
    }

    /**
     * @return the method returns the whole polls consider choices and their votes
     */
    public HashMap gettingPolls()
    {
        return polls;
    }

    /**
     * the method returns the question of the voting
     * @return question is the question of voting
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method defines a new choice with its set of votes that at first, the set is empty
     * @param newChoice is the choice that is going to be added to the voting
     */
    public void createPoll(String newChoice)
    {
        HashSet<Vote> choiceVotes = new HashSet<>();
        polls.put(newChoice, choiceVotes);
        System.out.println("choice added successfully to this voting");
    }

    /**
     * This method creates a new vote
     * @param person is the voter
     * @param choices are what the peron is going to vote to them.
     */
    public void vote(Person person, ArrayList<String> choices)
    {

        //first in here we add the person to voters list.
        voters.add(person);

        //here,we get the date in jalali calender.
        JalaliCalendar date = new JalaliCalendar();

        //so now we can define the new vote.
        Vote newVote = new Vote(person,date.toString());


        if (votes.size() != 0){
            for (Vote vote : votes) {
                if (vote.hashCode() == person.toString().hashCode()) {
                    System.out.println("this person has voted before. It is not possible to vote again");
                    //System.out.println("*******"+vote.hashCode());
                    return;
                }
            }
        }
        //adding vote choices to choices
        HashSet<Vote> oldVotes;
        if(type == 0){
            if(choices.size() > 1){
                System.out.println("you can not have multiple choices for this voting");
                return;
            }
            else if(choices.size() == 1){
                if(this.polls.containsKey(choices.get(0))){
                    oldVotes = this.polls.get(choices.get(0));
                    oldVotes.add(newVote);
                    this.polls.put(choices.get(0), oldVotes);
                }
                else{
                    System.out.println("this voting does not have entered choice or choices");
                    return;
                }
            }
        }
        else if(type == 1){
            if(choices.size() > this.polls.size()){
                System.out.println("you have entered more choices than available choices");
                return;
            }
            else {
                for(String choice : choices){
                    if(this.polls.containsKey(choice)){
                        oldVotes = this.polls.get(choice);
                        oldVotes.add(newVote);
                        this.polls.put(choice, oldVotes);
                    }
                    else{
                        System.out.println("this voting does not have entered choice or choices");
                        return;
                    }
                }
            }
        }


        //adding vote to votes
        votes.add(newVote);

        System.out.println("voted successfully at " + newVote.getDate());
    }


    /**
     * This method creates a new vote with random choice
     * @param person is the voter
     */
    public void randVote(Person person)
    {

        //first in here we add the person to voters list.
        voters.add(person);

        //here,we get the date in jalali calender.
        JalaliCalendar date = new JalaliCalendar();

        //so now we can define the new vote.
        Vote newVote = new Vote(person,date.toString());


        if (votes.size() != 0){
            for (Vote vote : votes) {
                if (vote.hashCode() == person.toString().hashCode()) {
                    System.out.println("this person has voted before. It is not possible to vote again");
                    System.out.println("*******"+vote.hashCode());
                    return;
                }
            }
        }
        //adding vote choices to choices
        HashSet<Vote> oldVotes;
        if(type == 0)
        {
            Iterator it = polls.entrySet().iterator();
            Random random = new Random();
            int num = random.nextInt(polls.keySet().size());


            ArrayList<String> choices = new ArrayList<>();
            while(it.hasNext()){
                Map.Entry item = (Map.Entry) it.next();
                choices.add((String) item.getKey());
            }
            String choice = choices.get(num);
            oldVotes = this.polls.get(choice);
            oldVotes.add(newVote);
            this.polls.put(choice, oldVotes);

        }

        //adding vote to votes
        votes.add(newVote);

        System.out.println("voted successfully at " + newVote.getDate());
    }
    /**
     * This methods prints the name of all voters
     */
    public void getVoters()
    {
        for (Person voter: voters) {
            System.out.println(voter.toString());
        }
    }

    /**
     * This method is used to print all the votes in the polls hash map.
     */
    public void printVotes()
    {
        Iterator it = polls.entrySet().iterator();
        String winner = "no choice";
        ArrayList<String> winners = new ArrayList<>();
        int votesCounter = 0;

        while(it.hasNext()){
            Map.Entry item = (Map.Entry) it.next();
            HashSet<Vote> values = (HashSet<Vote>) item.getValue();
            if(values.size() > votesCounter){
                votesCounter = values.size();
                winner = (String) item.getKey();
            }
        }

        Iterator it2 = polls.entrySet().iterator();
        while(it2.hasNext()){
            Map.Entry item = (Map.Entry) it2.next();
            HashSet<Vote> values = (HashSet<Vote>) item.getValue();
            if(values.size() == votesCounter){
                winner = (String) item.getKey();
                winners.add(winner);
            }
        }

        System.out.println("winners of this voting are:");

        for(String item : winners){
            System.out.println(item);
        }
    }

    /**
     * This method returns the polls of the current voting.
     */
    public ArrayList<String> getPolls()
    {
        return new ArrayList<>(polls.keySet());
    }

}