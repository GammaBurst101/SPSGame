public class HandTestDrive {
    public static void main (String args[]) {
        Hand hand = new Hand();
        
        for (int i=0; i<100; i++) {
            hand.shake();
            System.out.println (hand.show());
        }
    }
}