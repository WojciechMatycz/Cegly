import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {


        Brick answer;
        Random r = new Random();
        Scanner sr = new Scanner(System.in);
        int flag = 0;
        String command = sr.nextLine();
        long time = System.nanoTime();
        Tree t = new Tree(command);
        if(t.getFreeSpaces()<16)
        {
            flag = t.simulate(t.getRoot(),time);
            if(flag ==1)
                t.setWinningStates();
        }
        int limit;
        int preLimit;
        int prePreLimit;
        if(t.getMap().getN()<42)//37
        {
            limit = 20;

        }
        else if(t.getMap().getN()<62)//46//52
        {
            limit = 19;
        }
        else if(t.getMap().getN()<100)//64//68
        {
            limit = 18;
        }
        else
            limit = 17;

        preLimit = limit+5;
        prePreLimit = limit+13;
        System.out.println("OK");

        while (!(command = sr.nextLine()).equals("STOP")) {
            time = System.currentTimeMillis();
            if ((command.equals("START"))) {
                if (t.getFreeSpaces() > 16) {
                    t.goToLastFree();
                } else {
                    if (flag == 0 && t.getFreeSpaces() < 17) {
                        flag = t.simulate(t.getRoot(),time);
                        if(flag==1)
                            t.setWinningStates();
                    }
                    if(flag==1)
                        answer = t.searchForLoosingStates();
                    else
                        answer = null;

                    t.goToNextState(answer, flag, time);
                }
                System.out.println(t.getRoot().getBrickPutted());

            } else {
                if (flag == 1) // jesli zasymulowane znajdz i przejdz
                    t.makeMove2(command);
                else {
                    t.putBrick(new Brick(command));
                    t.setRoot(new Node(new Brick(command), t.getFreeSpaces()));
                }
                if(t.getFreeSpaces()>125)
                {
                    t.goToLastFree();
                }
                else if (t.getFreeSpaces() > prePreLimit-1) {
                    t.hideGaps();
                    t.simulateMoves(t.getRoot());
                    t.goToHighest(time);
                }
                else if (t.getFreeSpaces() < prePreLimit && t.getFreeSpaces() > preLimit) {
                    t.simulateMoves(t.getRoot());
                    t.goToHighest(time);
                } else if (t.getFreeSpaces() > limit-1) {
                    t.fillOptions(t.getRoot());
                    t.goToBestStateToSimulate(limit, time);
                }
                else {
                    if (flag == 0 && t.getFreeSpaces() < limit) {
                        flag = t.simulate(t.getRoot(), time);
                        if(flag==1)
                            t.setWinningStates();
                    }
                    if(flag==1)
                        answer = t.searchForLoosingStates();
                    else
                        answer = null;
                    t.goToNextState(answer, flag, time);
                }
                System.out.println(t.getRoot().getBrickPutted());
            }
        }


    }
}

