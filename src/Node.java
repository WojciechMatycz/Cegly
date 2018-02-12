import java.util.ArrayList;

public class Node {
    //private Node parent;
    private Node[] options;
    private Brick brickPutted;
    private boolean isWinnig;
    private boolean isLoosing;


    public Node(Brick brick, int howManyChildren)
    {
        brickPutted = brick;
        if(howManyChildren>0)
        {
            options = new Node[howManyChildren];
            isLoosing = false;
            isWinnig = false;
        }
        else
        {
            options = null;
            isWinnig = false;
            isLoosing = true;
        }
    }
    public void setWinnigStates()
    {
        if(options == null)
            return;
        for(Node n: options)
            n.setWinnigStates();
        if(looseInNext())
            isWinnig = true;
        else
            isLoosing = true;

    }

    public boolean looseInNext()
    {
        for(Node n: options)
            if(n.isLoosing)
                return true;
        return false;
    }

    public String printState()
    {
        if(isWinnig())
            return "Wygrywający";
        else if(isLoosing())
            return "Przegrywający";
        else
            return "Nie wiadomo";
    }

    public Brick searchForLoosingState()
    {
        for(Node n: options)
            if(n.isLoosing)
                return n.getBrickPutted();
        return null;
    }

    public Brick getBrickPutted()
    {
        return brickPutted;
    }


    public boolean isWinnig() {
        return isWinnig;
    }

    public void setWinnig(boolean winnig) {
        isWinnig = winnig;
    }

    public Node[] getOptions() {
        return options;
    }

    public void setOptions(Node[] options) {
        this.options = options;
    }

    public boolean isLoosing() {
        return isLoosing;
    }

    public void setLoosing(boolean loosing) {
        isLoosing = loosing;
    }

    public boolean equalsBrick(Brick b)
    {
        if(b.equals(getBrickPutted()))
            return true;
        else
        {
            /*String [] bricks1 = b.split("_");
            String [] bricks2 = getBrickPutted().split("_");
            if(bricks1[0].equals(bricks2[1]) && bricks1[1].equals(bricks2[0]))
                return true;
            else*/
            return false;
        }
    }

    public boolean equalsBrick(String b)
    {
        Brick b1 = new Brick(b);
        if(getBrickPutted().equals(b1))
            return true;
        else
            return false;
    }

    public Node findNextState(int number)
    {
        return options[number];
    }

    public Node findMostLoosingStatesForOpponent()
    {
        int current = 0;
        int highest = 0;
        int index = 0;
        for(int i=0; i<options.length; i++) {
            for (int j = 0; j < options[i].options.length; j++)
                if (options[i].options[j].isWinnig)
                    current++;
            if (current > highest) {
                highest = current;
                index = i;
            }
            current = 0;
        }
        return options[index];
    }

    public Node findNextState(Brick command) {
        for(Node n: options) {
            if (n.getBrickPutted().equals(command))
                return n;
        }

        return null;
    }

    public Node searchForMove(String command) {
        for(Node n: options)
            if(n.getBrickPutted().equals(new Brick(command))) {
                return n;
            }
        return null;
    }


    public Node goToHighest(long time) {
        int highest = 0;
        Node result = options[0];
        for(Node n: options) {
            if((System.currentTimeMillis()-time)/1000.0>0.475)
                return result;
            if (n.options.length >= highest) {
                highest = n.options.length;
                result = n;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return brickPutted.toString();
    }
}
