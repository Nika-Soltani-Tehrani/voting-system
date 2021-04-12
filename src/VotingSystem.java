/**
 * This class implement the voting system
 */

import java.util.ArrayList;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    //constructor
    VotingSystem()
    {
        votingList = new ArrayList<>();
    }

    /**
     * This method creates a new voting
     * @param question is the question of the voting
     * @param type is the type of the voting like multiple or singable cote
     */
    public void createVoting(String question,int type)
    {
        Voting newVoting = new Voting(type, question);
        votingList.add(newVoting);
        System.out.println("voting created successfully");
    }

    /**
     * @return the list of all active votings
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }

    /**
     * @param index is the index of the voting which we need its info.
     */
    public void printVotings(int index)//getVoting
    {
        if(index < votingList.size() && index >= 0)
        {
            System.out.println("The question of the voting was " + votingList.get(index).getQuestion());
            if (votingList.get(index).getPolls().size() != 0){
                System.out.println("The choices were ");
                int i = 0;
                for (String choice : votingList.get(index).getPolls()) {
                    System.out.println(i++ + " : " + choice);
                }
            }
            else
                System.out.println("There is still no choices for this voting");
        }
        else
        {
            System.out.println("there is no voting with this index");
        }
    }

    /**
     * This method creates a new vote
     * @param index is the index of related voting
     * @param voter is the person who is going to vote
     * @param choices is the list of all choices of the voter.
     */
    public void vote(int index,Person voter,ArrayList<String> choices)
    {
        if (index <= votingList.size())
            votingList.get(index).vote(voter,choices);
        else
            System.out.println("there is no voting with this index");
    }

    /**
     * This method creates a new vote
     * @param index is the index of related voting
     * @param voter is the person who is going to vote
     */
    public void randVote(int index,Person voter)
    {
        if (index <= votingList.size())
            votingList.get(index).randVote(voter);
        else
            System.out.println("there is no voting with this index");
    }
    /**
     * @param index is the index of the voting which we need its result.
     */
    public void getResult(int index)
    {
        for (String poll : votingList.get(index).getPolls())
        {
            System.out.println(votingList.get(index).gettingPolls().size());
        }
        if(index < votingList.size() && index >= 0){
            votingList.get(index).printVotes();
        }
        else{
            System.out.println("there is no voting with this index");
        }
    }
}
