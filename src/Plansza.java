import java.util.Iterator;
import java.util.NoSuchElementException;

public class Plansza implements Iterable<Boolean> {
    private boolean tab[][];
    private int n;
    private int freeSpaces;

    public Plansza(String entry)
    {
        String wrds[] = entry.split("_");
        this.n = Integer.parseInt(wrds[0]);
        tab = new boolean[n+2][n+2];
        fillEdges();
        //for(int i=0; i<n+2; i++)
          //  for(int j=0; j<n+2; j++)
            //    tab[i][j] = true;
        for(int i=1; i<wrds.length; i++)
        {
            readSingleSquare(wrds[i]);
            //readSingleSquare2(wrds[i]);
        }
        freeSpaces = countFreeSpaces();
    }

    public int countFreeSpaces() {
        int placestoMove = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (!tab[i][j]) {
                    if (!tab[i + 1][j]) {
                        placestoMove++;
                    }
                    if (!tab[i][j+1])
                        placestoMove++;
                }
        }
        return placestoMove;
    }

    private void readSingleSquare(String s)
    {
        String[] square = s.split("x");
        tab[Integer.parseInt(square[1])+1][Integer.parseInt(square[0])+1] = true;
    }

    private void readSingleSquare2(String s)
    {
        String[] square = s.split("x");
        tab[Integer.parseInt(square[1])+1][Integer.parseInt(square[0])+1] = false;
    }

    private void fillEdges()
    {
        for(int i=0; i<n+2; i++) {
            tab[i][0] = true;
            tab[0][i] = true;
            tab[n+1][i] = true;
            tab[i][n+1] = true;
        }

    }

    public void putBrick(String data) {
        String[] brick_data = data.split("_");
        readSingleSquare(brick_data[0]);
        readSingleSquare(brick_data[1]);
    }

    public void putBrick(Brick brick) {

        tab[brick.getX1()+1][brick.getY1()+1] = true;
        tab[brick.getX2()+1][brick.getY2()+1] = true;

    }

    public void pullBrick(Brick brick) {
        tab[brick.getX1()+1][brick.getY1()+1] = false;
        tab[brick.getX2()+1][brick.getY2()+1] = false;
    }

    private String buildBrick(int x1, int y1, int x2, int y2)
    {
        StringBuilder s = new StringBuilder();
        s.append(x1).append('x').append(y1).append('_').append(x2).append('x').append(y2);
        return s.toString();
    }

    public boolean checkIfGap(int x, int y)
    {
        if(!tab[x][y] && tab[x+1][y] && tab[x-1][y] && tab[x][y+1] && tab[x][y-1])
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++) {
                if(tab[i][j])
                    result.append("X").append(" ");
                else
                    result.append("_").append(" ");

            }
            result.append('\n');
        }

        return result.toString();
    }

    @Override
    public Iterator<Boolean> iterator() {
        return new GridIterator();
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public void setFreeSpaces(int freeSpaces) {
        this.freeSpaces = freeSpaces;
    }

    public void hideGaps() {
        for(int i=1; i<n+1; i++)
            for(int j=1; j<n+1; j++)
                if(checkIfGap(i,j))
                    tab[i][j]=true;
    }


    class GridIterator implements Iterator<Boolean> {
        int row = 1;
        int column = 1;

        @Override
        public boolean hasNext() {
            if(row==Plansza.this.n && column==Plansza.this.n+1)
                return false;
            else
                return true;
        }

        @Override
        public Boolean next() {
            if(!hasNext())
                throw new NoSuchElementException();
            if(column==Plansza.this.n+1)
            {
                row++;
                column=1;
            }
            return Plansza.this.tab[row][column++];
        }
    }

    public boolean[][] getTab() {
        return tab;
    }

    public void setTab(boolean[][] tab) {
        this.tab = tab;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}
