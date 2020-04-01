package world;

import regions.City;
import regions.EmptyRegion;

import java.util.Random;

public class Map {
    public static final int HEIGHT = 1000;
    public static final int WIDTH = 2000;

    public static final int UP_LEFT = 0;
    public static final int UP = 1;
    public static final int UP_RIGHT = 2;
    public static final int RIGHT = 3;
    public static final int DOWN_RIGHT = 4;
    public static final int DOWN = 5;
    public static final int DOWN_LEFT = 6;
    public static final int LEFT = 7;

    private World place;

    public World getPlace() {
        return place;
    }

    public Map(int seed, World place){
        squares = new Square[WIDTH][HEIGHT];
        this.place = place;
        generate(seed);
    }

    public Square[][] squares;

    private Random random;

    public void generate(int seed){
        random=new Random(seed);
        for(int x=0;x<WIDTH;x++){
            for(int y=0;y<HEIGHT;y++){
                squares[x][y]=new Square(Square.WATER, x, y, place);
                squares[x][y].setRegion(new EmptyRegion(squares[x][y]));
            }
        }
        for(int i=0;i<10;i++){
            generateTerrain(5000,random.nextInt(WIDTH),random.nextInt(HEIGHT));
        }
        for(int i=0;i<20;i++){
            generateTerrain(1000,random.nextInt(WIDTH),random.nextInt(HEIGHT));
        }
        correction();
        addResources();
        generateCity();
    }

    private void generateTerrain(double n,int x,int y){
        if(x<0||x>=WIDTH||y<0||y>=HEIGHT||n<=0)return;
        if(squares[x][y].getType()!=Square.WATER)return;
        if(n>1000||squares[x][y].getType()==Square.HILL)squares[x][y].setType(Square.HILL);
        else squares[x][y].setType(Square.GROUND);
        squares[x][y].setHeight(n);
        for(int i=0;i<6;i++) {
            int mx = random.nextInt(3) - 1;
            int my = random.nextInt(3) - 1;
            if(!(mx==0&&my==0))generateTerrain(n-Math.max(Math.sqrt(mx*mx+my*my),1),x+mx,y+my);
        }


    }

    private boolean checkType(int x,int y,int type){
        if(x<0||x>=Map.WIDTH||y<0||y>=Map.HEIGHT)return false;
        if(squares[x][y].getType()==type)return true;
        return false;
    }

    private void correction(){
        for(int i=0;i<2;i++) {
            for (int x = 0; x < WIDTH; x++)
                for (int y = 0; y < HEIGHT; y++) {
                    int g = 0;
                    int h = 0;
                    if (checkType(x + 1, y, Square.GROUND)) g++;
                    if (checkType(x, y + 1, Square.GROUND)) g++;
                    if (checkType(x - 1, y, Square.GROUND)) g++;
                    if (checkType(x, y - 1, Square.GROUND)) g++;
                    if (checkType(x + 1, y, Square.HILL)) h++;
                    if (checkType(x, y + 1, Square.HILL)) h++;
                    if (checkType(x - 1, y, Square.HILL)) h++;
                    if (checkType(x, y - 1, Square.HILL)) h++;

                    if (g*g > random.nextInt(10)) squares[x][y].setType(Square.GROUND);
                    if (h*h > random.nextInt(10)) squares[x][y].setType(Square.HILL);
                }
        }
    }

    private static Square[][] cloneMap(Square[][] map){
        Square[][] newMap = map.clone();
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++) {
                try {
                    newMap[x][y] = map[x][y].clone();
                }
                catch (CloneNotSupportedException e){
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    private void generateForest(int x,int y,double n){
        if(n<=0)return;
        if(!(inBounds(y,0,HEIGHT)&&inBounds(x,0,WIDTH)))return;
        if(squares[x][y].getType()!=Square.GROUND)return;
        if(squares[x][y].getResource()==Resource.WOOD)return;
        squares[x][y].setResource(Resource.WOOD);

        if(random.nextInt(10)<5)   generateForest(x+1,y+1,n-1.41);
        if(random.nextInt(10)<5)generateForest(x-1,y+1,n-1.41);
        if(random.nextInt(10)<5)generateForest(x+1,y-1,n-1.41);
        if(random.nextInt(10)<5)generateForest(x-1,y-1,n-1.41);
        if(random.nextInt(10)<5)generateForest(x+1,y,n-1);
        if(random.nextInt(10)<5)generateForest(x-1,y,n-1);
        if(random.nextInt(10)<5)generateForest(x,y-1,n-1);
        if(random.nextInt(10)<5)generateForest(x,y+1,n-1);


    }

    private void generateStones(int x,int y, double n){
        if(n<=0)return;
        if(!(inBounds(y,0,HEIGHT)&&inBounds(x,0,WIDTH)))return;
        if(squares[x][y].getType()!=Square.GROUND)return;
        if(squares[x][y].getResource()==Resource.STONE)return;
        squares[x][y].setResource(Resource.STONE);

        if(random.nextInt(10)<5)generateStones(x+1,y+1,n-1.41);
        if(random.nextInt(10)<5)generateStones(x-1,y+1,n-1.41);
        if(random.nextInt(10)<5)generateStones(x+1,y-1,n-1.41);
        if(random.nextInt(10)<5)generateStones(x-1,y-1,n-1.41);
        if(random.nextInt(10)<5)generateStones(x+1,y,n-1);
        if(random.nextInt(10)<5)generateStones(x-1,y,n-1);
        if(random.nextInt(10)<5)generateStones(x,y-1,n-1);
        if(random.nextInt(10)<5)generateStones(x,y+1,n-1);

    }

    private   void generateIron(int x,int y, double n){
        if(n<=0)return;
        if(!(inBounds(y,0,HEIGHT)&&inBounds(x,0,WIDTH)))return;
        if(squares[x][y].getType()!=Square.GROUND)return;
        if(squares[x][y].getResource()==Resource.IRON)return;
        squares[x][y].setResource(Resource.IRON);

        if(random.nextInt(10)<5)generateIron(x+1,y+1,n-1.41);
        if(random.nextInt(10)<5)generateIron(x-1,y+1,n-1.41);
        if(random.nextInt(10)<5)generateIron(x+1,y-1,n-1.41);
        if(random.nextInt(10)<5)generateIron(x-1,y-1,n-1.41);
        if(random.nextInt(10)<5)generateIron(x+1,y,n-1);
        if(random.nextInt(10)<5)generateIron(x-1,y,n-1);
        if(random.nextInt(10)<5)generateIron(x,y-1,n-1);
        if(random.nextInt(10)<5)generateIron(x,y+1,n-1);

    }

    private void generateResource(int x,int y,double n,Resource r){
        if(n<=0)return;
        if(!(inBounds(y,0,HEIGHT)&&inBounds(x,0,WIDTH)))return;
        if(squares[x][y].getType()!=Square.GROUND)return;
        if(squares[x][y].getResource()==r)return;
        squares[x][y].setResource(r);

        if(random.nextInt(10)<8)generateResource(x+1,y+1,n-1.41,r);
        if(random.nextInt(10)<8)generateResource(x-1,y+1,n-1.41,r);
        if(random.nextInt(10)<8)generateResource(x+1,y-1,n-1.41,r);
        if(random.nextInt(10)<8)generateResource(x-1,y-1,n-1.41,r);
        if(random.nextInt(10)<8)generateResource(x+1,y,n-1,r);
        if(random.nextInt(10)<8)generateResource(x-1,y,n-1,r);
        if(random.nextInt(10)<8)generateResource(x,y-1,n-1,r);
        if(random.nextInt(10)<8)generateResource(x,y+1,n-1,r);

    }

    private void addResources(){
        for(int i=0;i<1000;i++){
            int x,y;
            do{
                x=random.nextInt(WIDTH);
                y=random.nextInt(HEIGHT);
            }while (!checkType(x,y,Square.GROUND));
            generateForest(x,y,20);
            if(i%2==0) {
                do {
                    x = random.nextInt(WIDTH);
                    y = random.nextInt(HEIGHT);
                } while (!checkType(x, y, Square.GROUND));
                generateStones(x, y, 10);
            }
            if(i%4==0) {
                do {
                    x = random.nextInt(WIDTH);
                    y = random.nextInt(HEIGHT);
                } while (!checkType(x, y, Square.GROUND));
                generateIron(x, y, 5);
            }

        }
        for(int i=0;i<1000;i++){
            int x,y;


            x=random.nextInt(WIDTH);
            y=random.nextInt(HEIGHT);

            if(checkType(x,y,Square.GROUND)&&(!resInRange(x,y,200)))generateResource(x,y,3,Resource.values()[random.nextInt(Resource.values().length-3)+3]);

        }
    }

    private boolean resInRange(int x,int y,double n) {
        for(int i=0;i<WIDTH;i++)for(int j=0;j<HEIGHT;j++){
            if(squares[i][j].getResource()!=null&&squares[i][j].getResource().getType() != Resource.BASIC){
                if(((i-x)*(i-x)+(j-y)*(j-y))<(n*n))return true;
            }
        }
        return false;
    }

    private void generateCity(){
        int x;
        int y;
        do{
            x = random.nextInt(WIDTH);
            y = random.nextInt(HEIGHT);
        }while (squares[x][y].getType() == Square.WATER || squares[x][y].getType() == Square.HILL);
        squares[x][y].setRegion(new City(squares[x][y]));
    }



    public static boolean inBounds(int n,int min,int max){
        return (n >= min) && (n < max);
    }
}
