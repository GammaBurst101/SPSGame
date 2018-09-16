public class Hand {
    private String move="";
    
    Hand() {
        shake();
    }
    
    public void shake() {
        int random = (int)((Math.random()*3) +1);
        /*
         * Problem: Sometimes the same number is generated more than twice in a row! This definitely makes it boring
         * 
         * Plan: Generate another number between 0-1 called 'sameOrNot'
         * This will decide whether the new move COULD be similiar to the previous one or not
         * If 0 - normal (could be same)
         * If 1 - throw any move which is not the same as the previous one (may need to generate another random)
         * 
         * Therefore, I need something to keep track of the previous moves
         * As I'm generating randoms a lot, probably I can use Random class to make it more efficient
           */
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