public class Hand {
    private String move="";
    
    Hand() {
        shake();
    }
    
    public void shake() {
        int random = (int)((Math.random()*3) +1);
        switch (random) {
            case 1: move = "stone";
            break;
            
            case 2: move = "paper";
            break;
            
            case 3: move = "scissor";
            break;
        }
    }
    
    public String show() {
        return move;
    }
}