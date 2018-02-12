import java.util.ArrayList;

public class Tree {
    private Node root;
    private Grid map;
    public Tree(String s)
    {
        map = new Grid(s);
        root = new Node(null, map.getFreeSpaces());
    }

    public void putBrick(Brick brick)
    {
        if(brick==null)
            return;
        /*ArrayList<Brick> bricksToRemoveFromList = searchForNeighbourBricks(brick);
        //System.out.println("BricksToRemove: " + bricksToRemoveFromList);
        brickList.remove(brick);
        brickList.removeAll(bricksToRemoveFromList);*/
        int minus = countHowMuchLessFreeSpace(brick);
        map.putBrick(brick);
        map.setFreeSpaces(getFreeSpaces()-minus);

    }

    private ArrayList<Brick> searchForNeighbourBricks(Brick brick) {

        int y1 = brick.getY1()+1;
        int x1 = brick.getX1()+1;
        int y2 = brick.getY2()+1;
        int x2 = brick.getX2()+1;


        ArrayList<Brick> neighbours = new ArrayList<>();

        if(y1==y2)
        {
            if(!map.getTab()[x1][y1+1])
                neighbours.add(new Brick(y1-1, x1-1, y1, x1-1));
            if(!map.getTab()[x2][y2+1])
                neighbours.add(new Brick(y2-1,x2-1,y2,x2-1));
            if(!map.getTab()[x2][y2-1])
                neighbours.add(new Brick(y2-1,x2-1,y2-2,x2-1));
            if(!map.getTab()[x1][y1-1])
                neighbours.add(new Brick(y1-1,x1-1,y1-2,x1-1));


            if(x1<x2)
            {
                if(!map.getTab()[x1 - 1][y1])
                    neighbours.add(new Brick(y1-1,x1-1,y1-1,x1-2));
                if(!map.getTab()[x2+1][y2])
                    neighbours.add(new Brick(y2-1,x2-1,y2-1,x2));
            }
            else
            {
                if(!map.getTab()[x2-1][y2])
                    neighbours.add(new Brick(y2-1,x2-1,y2-1,x2-2));
                if(!map.getTab()[x1+1][y1])
                    neighbours.add(new Brick(y1-1,x1-1,y1-1,x1));
            }
        }
        else
        {
            if(!map.getTab()[x1-1][y1])
                neighbours.add(new Brick(y1-1,x1-1,y1-1,x1-2));
            if(!map.getTab()[x2-1][y2])
                neighbours.add(new Brick(y2-1,x2-1,y2-1,x2-2));
            if(!map.getTab()[x2+1][y2])
                neighbours.add(new Brick(y2-1,x2-1,y2-1,x2));
            if(!map.getTab()[x1+1][y1])
                neighbours.add(new Brick(y1-1,x1-1,y1-1,x1));

            if(y1<y2)
            {
                if(!map.getTab()[x1][y1-1])
                    neighbours.add(new Brick(y1-1,x1-1,y1-2,x1-1));
                if(!map.getTab()[x2][y2+1])
                    neighbours.add(new Brick(y2-1,x2-1,y2,x2-1));
            }
            else
            {
                if(!map.getTab()[x2][y2-1])
                    neighbours.add(new Brick(y2-1,x2-1,y2-2,x2-1));
                if(!map.getTab()[x1][y1+1])
                    neighbours.add(new Brick(y1-1,x1-1,y1,x1-1));
            }
        }
        return neighbours;
    }

    public int countHowMuchLessFreeSpace(Brick brick)
    {
        int y1 = brick.getY1()+1;
        int x1 = brick.getX1()+1;
        int y2 = brick.getY2()+1;
        int x2 = brick.getX2()+1;

        if(map.getTab()[x1][y1])
            return 0;

        int licznik = 1;
        if(y1==y2)
        {
            if(!map.getTab()[x1][y1+1])
                licznik++;
            if(!map.getTab()[x2][y2+1])
                licznik++;
            if(!map.getTab()[x2][y2-1])
                licznik++;
            if(!map.getTab()[x1][y1-1])
                licznik++;

            if(x1<x2)
            {
                if(!map.getTab()[x1 - 1][y1])
                    licznik++;
                if(!map.getTab()[x2+1][y2])
                    licznik++;
            }
            else
            {
                if(!map.getTab()[x2-1][y2])
                    licznik++;
                if(!map.getTab()[x1+1][y1])
                    licznik++;
            }
        }
        else
        {
            if(!map.getTab()[x1-1][y1])
                licznik++;
            if(!map.getTab()[x2-1][y2])
                licznik++;
            if(!map.getTab()[x2+1][y2])
                licznik++;
            if(!map.getTab()[x1+1][y1])
                licznik++;

            if(y1<y2)
            {
                if(!map.getTab()[x1][y1-1])
                    licznik++;
                if(!map.getTab()[x2][y2+1])
                    licznik++;
            }
            else
            {
                if(!map.getTab()[x2][y2-1])
                    licznik++;
                if(!map.getTab()[x1][y1+1])
                    licznik++;
            }
        }

        return licznik;
    }

    public int countHowMuchLessFreeSpace(int y1, int x1, int y2, int x2)
    {

        int licznik = 1;
        if(y1==y2)
        {
            if(!map.getTab()[x1][y1+1])
                licznik++;
            if(!map.getTab()[x2][y2+1])
                licznik++;
            if(!map.getTab()[x2][y2-1])
                licznik++;
            if(!map.getTab()[x1][y1-1])
                licznik++;
            //System.out.println("somsiadyyyyy" + neighbours);

            if(x1<x2)
            {
                if(!map.getTab()[x1 - 1][y1])
                    licznik++;
                if(!map.getTab()[x2+1][y2])
                    licznik++;
            }
            else
            {
                if(!map.getTab()[x2-1][y2])
                    licznik++;
                if(!map.getTab()[x1+1][y1])
                    licznik++;
            }
        }
        else
        {
            if(!map.getTab()[x1-1][y1])
                licznik++;
            if(!map.getTab()[x2-1][y2])
                licznik++;
            if(!map.getTab()[x2+1][y2])
                licznik++;
            if(!map.getTab()[x1+1][y1])
                licznik++;

            if(y1<y2)
            {
                if(!map.getTab()[x1][y1-1])
                    licznik++;
                if(!map.getTab()[x2][y2+1])
                    licznik++;
            }
            else
            {
                if(!map.getTab()[x2][y2-1])
                    licznik++;
                if(!map.getTab()[x1][y1+1])
                    licznik++;
            }
        }

        return licznik;
    }

    public void pullBrick(Brick brick)
    {
        if(brick==null)
            return;
        map.pullBrick(brick);
        /*ArrayList<Brick> bricksToAdd = searchForNeighbourBricks(brick);
        brickList.add(brick);
        brickList.addAll(bricksToAdd);*/
        int plus = countHowMuchLessFreeSpace(brick);
        map.setFreeSpaces(getFreeSpaces()+plus);
    }

    public int simulate(Node n, long time) {

        putBrick(n.getBrickPutted());

        if((System.currentTimeMillis()-time)/1000.0>0.48)
            return 0;
        else {
            if (getFreeSpaces() == 0)
                return 1;


            int flag = 0;
            fillOptions(n);
            for (Node n1 : n.getOptions()) {
                flag = simulate(n1, time);
                pullBrick(n1.getBrickPutted());
            }

            return flag;
        }
    }

    public void fillOptions(Node n)
    {
        int index = 0;
        for(int i=1; i<map.getN()+1; i++) {
            for (int j = 1; j < map.getN() + 1; j++) {
                if (!map.getTab()[i][j]) {
                    if (!map.getTab()[i][j + 1]) {
                        int minus = countHowMuchLessFreeSpace(j, i, j + 1, i);
                        n.getOptions()[index++] = new Node(new Brick(j - 1, i - 1, j, i - 1), getFreeSpaces() - minus);
                    }
                    if (!map.getTab()[i + 1][j]) {
                        int minus = countHowMuchLessFreeSpace(j, i, j, i + 1);
                        n.getOptions()[index++] = new Node(new Brick(j - 1, i - 1, j - 1, i), getFreeSpaces() - minus);
                    }
                }
            }
            if(index == getFreeSpaces()) //Dla tablicy if(licznik == getFreeSpaces())
                return;
        }
    }

    public void findMostLoosingStatesForOpponent()
    {

        root = root.findMostLoosingStatesForOpponent();
        putBrick(root.getBrickPutted());
    }


    public void makeMove2(String command)
    {
        root = root.searchForMove(command);
        putBrick(root.getBrickPutted());
    }

    public void goToNextState(int nextSteps)
    {
        root = root.findNextState(nextSteps);
    }

    public void goToNextState(Brick command, int flag, long time)
    {
        if(command == null)
        {
            if(flag==0)
            {
                goToHighest(time);
            }
            else
            {
                findMostLoosingStatesForOpponent();
            }
        }
        else {
            root = root.findNextState(command);
            putBrick(root.getBrickPutted());
        }
    }

    public Brick searchForLoosingStates()
    {
        return root.searchForLoosingState();
    }


    public void simulateMoves(Node n)
    {


        fillOptions(n);
        for (Node n1 : n.getOptions()) {
            putBrick(n1.getBrickPutted());
            fillOptions(n1);
            pullBrick(n1.getBrickPutted());
        }
    }

    public String printState()
    {
        return root.printState();
    }

    public void setWinningStates()
    {
        root.setWinnigStates();
    }

    public int getFreeSpaces()
    {
        return map.getFreeSpaces();
    }

    public Node[] getOptions() {
        return root.getOptions();
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Grid getMap() {
        return map;
    }

    public void setMap(Grid map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public void setOptions(Node[] options) {
        root.setOptions(options);
    }

    public void goToLastFree(){
        root = findLastFree();
    }

    public Node findLastFree()
    {
        int n = map.getN();
        for (int i = n; i >= 1; i--) {
            for (int j = n; j >= 1; j--)
                if (!map.getTab()[i][j]) {
                    if (!map.getTab()[i][j - 1]) {
                        Brick b = new Brick(j-1,i-1,j-2,i-1);
                        putBrick(b);
                        return new Node(b, getFreeSpaces());
                    }
                    if (!map.getTab()[i - 1][j]) {
                        Brick b = new Brick(j-1, i-1, j-1, i-2);
                        putBrick(b);
                        return new Node(b, getFreeSpaces());
                    }
                }
        }
        return null;
    }

    public void goToBestStateToSimulate(int limit, long time) {
        root = findBestStateToSimulateFrom(root, limit, time);
        putBrick(root.getBrickPutted());
    }

    public Node findBestStateToSimulateFrom(Node n, int limit, long time) {
        int lowest = getFreeSpaces();
        Node best = null;
        Node result = n.getOptions()[0];
        for(Node n1: n.getOptions()){
            int current = getFreeSpaces() - n1.getOptions().length;
            if(n.getOptions().length==limit+2)
                best = n1;
            if(current >0 && current<lowest) {
                lowest = current;
                result = n1;
            }
        }
        if(best != null)
            result = best;

        double difference;
        if(getFreeSpaces()<(limit+3)) {
            for (Node n1 : n.getOptions()) {
                difference = (System.currentTimeMillis() - time) / 1000.0;
                if (difference > 0.45)
                    return result;
                if (n1.getOptions().length < (limit -3)) {
                    putBrick(n1.getBrickPutted());
                    int s = simulate(n1,time);
                    if(s==1) {
                        n1.setWinnigStates();
                        if (n1.isLoosing())
                            return n1;
                        else
                            pullBrick(n1.getBrickPutted());
                    }
                    else if((System.currentTimeMillis()-time)/1000.0>0.48){
                        pullBrick(n1.getBrickPutted());
                        return result;
                    }
                    else {
                        pullBrick(n1.getBrickPutted());
                    }
                }
            }
        }
        return result;
    }

    public void goToHighest(long time) {
        root = root.goToHighest(time);
        putBrick(root.getBrickPutted());
    }

    public void hideGaps()
    {
        map.hideGaps();
    }
}
