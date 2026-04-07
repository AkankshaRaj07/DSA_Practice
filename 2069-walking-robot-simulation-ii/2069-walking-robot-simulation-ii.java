class Robot {
    int x, y;
    int [][] grid;
    String dir;
    int width=0, height =0;
    public Robot(int width, int height) {
        grid = new int [width][height];
        this.width = width;
        this.height = height;
        x=y=0;
        dir= "East";
    }
    
    public void step(int num) {   
        int perimeter = 2 * (width + height) - 4;
        num = num % perimeter;
        if (num == 0) num = perimeter;
    
        while(num>0){

            if (dir.equals("East") && x + 1 >= width) {
                dir = "North";
                continue;
            } 
            else if (dir.equals("North") && y + 1 >= height) {
                dir = "West";
                continue;
            } 
            else if (dir.equals("West") && x - 1 < 0) {
                dir = "South";
                continue;
            } 
            else if (dir.equals("South") && y - 1 < 0) {
                dir = "East";
                continue;
            }
            if(dir.equals("East")) x++;
            else if (dir.equals("North")) y++;
            else if (dir.equals("West")) x--;
            else y--;
            num--;
        }

    }
    
    public int[] getPos() {
        return new int [] {x,y};
    }
    
    public String getDir() {
        return dir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */