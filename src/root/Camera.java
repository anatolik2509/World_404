package root;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import regions.City;
import world.*;


public class Camera implements Runnable{

    private int x;
    private int y;
    private int width;
    private int heigth;
    private Canvas canvas;
    private boolean isDown = false;
    private boolean isUp=false;
    private boolean isRight=false;
    private boolean isLeft=false;
    private boolean isExit=false;

    private Map map = Main.world.getMap();



    public void setExit(boolean exit) {
        isExit = exit;
    }

    public boolean isDown() {
        return isDown;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return isRight;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        getImage();

        while(Main.mainThread.isAlive()) {
            try {
                updateImage();
                if(isUp)up();
                if(isDown)down();
                if(isRight)right();
                if(isLeft)left();

                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Camera(Canvas canvas, int width, int heigth){

        x=0;
        y=0;
        this.width=width;
        this.heigth=heigth;
        this.canvas=canvas;
    }


    public void getImage(){
        for(int i=0;i<Map.WIDTH;i++){
            for (int j=0;j<Map.HEIGHT;j++){
                if(Map.inBounds(i,0,Map.WIDTH)&&Map.inBounds(j,0,Map.HEIGHT)) {

                    if (map.squares[i][j].getType() == Square.WATER) canvas.getGraphicsContext2D().setFill(Color.BLUE);
                    else if (map.squares[i][j].getType() == Square.GROUND) canvas.getGraphicsContext2D().setFill(Color.GREEN);
                    else if (map.squares[i][j].getType() == Square.HILL) canvas.getGraphicsContext2D().setFill(Color.BROWN);
                    else if (map.squares[i][j].getType() == Square.RIVER) canvas.getGraphicsContext2D().setFill(Color.CYAN);
                    if(map.squares[i][j].getResource()==Resource.WOOD) canvas.getGraphicsContext2D().setFill(Color.DARKGREEN);
                    else if(map.squares[i][j].getResource()==Resource.STONE) canvas.getGraphicsContext2D().setFill(Color.GRAY);
                    else if(map.squares[i][j].getResource()==Resource.IRON) canvas.getGraphicsContext2D().setFill(Color.DARKGRAY);
                    else if(map.squares[i][j].getResource()==Resource.DIAMOND) canvas.getGraphicsContext2D().setFill(Color.CYAN);
                    else if(map.squares[i][j].getResource()==Resource.EXOTIC_FRUITS) canvas.getGraphicsContext2D().setFill(Color.RED);
                    else if(map.squares[i][j].getResource()==Resource.GOLD) canvas.getGraphicsContext2D().setFill(Color.YELLOW);
                    else if(map.squares[i][j].getResource()==Resource.SILVER) canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    else if(map.squares[i][j].getResource()==Resource.PORCELAIN) canvas.getGraphicsContext2D().setFill(Color.PURPLE);
                    else if(map.squares[i][j].getResource()==Resource.TEA) canvas.getGraphicsContext2D().setFill(Color.GREENYELLOW);
                    else if(map.squares[i][j].getResource()==Resource.GRAPE) canvas.getGraphicsContext2D().setFill(Color.WHITE);
                    else if(map.squares[i][j].getResource()==Resource.FUR) canvas.getGraphicsContext2D().setFill(Color.ORANGE);

                    canvas.getGraphicsContext2D().fillRect(i,j,1,1);
                }
            }
        }

        for(int i=0;i<Map.WIDTH;i++){
            for (int j=0;j<Map.HEIGHT;j++){
                if(Map.inBounds(i,0,Map.WIDTH) && Map.inBounds(j,0,Map.HEIGHT)) {
                    if(map.squares[i][j].getRegion().getClass() == City.class) {
                        canvas.getGraphicsContext2D().setFill(Color.BLACK);
                        canvas.getGraphicsContext2D().fillRect(i - 2,j - 2,5,5);
                    }
                }
            }
        }

    }

    public void updateImage(){
        canvas.setLayoutX(-x);
        canvas.setLayoutY(-y);
    }

    public void up(){
        y-=10;
        if(y<0)y=0;
    }
    public void down(){
        y+=10;
        if(y+heigth>Map.HEIGHT)y=Map.HEIGHT-heigth;
    }
    public void right(){
        x+=10;
        if(x+width>Map.WIDTH)x=Map.WIDTH-width;
    }
    public void left(){
        x-=10;
        if(x<0)x=0;
    }
}
