import java.io.*;
import java.util.*;
class Natural
{
    static int player_health = 100;
    static int dialogueSpeed = 40;
    static long sleepTime = 250;
    static int enemy_health = 100;
    static int[] damage ={0, 10, 15, 24, 52, 69, 22, 31, 41, 39, 22, 1, 9, 3, 25};
    static Scanner sc = new Scanner(System.in);
    static Random rn = new Random();
    public static void slowPrint(String text, int speed) throws InterruptedException, IOException{
        // import java.io.* for method to work
        Writer w = new PrintWriter(System.out);
        for(int t = 0; t < text.length(); t++){
          System.out.print(text.charAt(t));
          w.flush();
          Thread.sleep(speed);
        }
        System.out.println();
    }
    static void displayIntro()throws InterruptedException, IOException{
        slowPrint("####################################", 10);
        slowPrint("WELCOME TO DILLUSIONERS NATURE FIGHT", 10);
        slowPrint("####################################", 10);
        System.out.println("\n\n\n\n");
        slowPrint("[Enemy] Die! You stupid monkey.", dialogueSpeed);
        Thread.sleep(sleepTime);
        slowPrint("[Player] What, who are you?", dialogueSpeed);
        Thread.sleep(sleepTime);
        slowPrint("[Enemy] Your nature mint is quiet mythical, you see. It would be a waste if that power wasn't granted to me.", dialogueSpeed);
        Thread.sleep(sleepTime); 
        slowPrint("[Player] It seems there is no choice left...", dialogueSpeed);
        Thread.sleep(sleepTime);      
        slowPrint("\nThe Match has started!\n", 60);
    }
    static void attackDisplay(String monkey)throws InterruptedException, IOException{
        slowPrint(monkey+"'s attack options:- ", 30);
        System.out.println("1. Nature\'s Judgement");
        System.out.println("2. Leaf Slash");
        System.out.println("3. Regeneration");
        System.out.println("4. Roar of Time");
        System.out.print(">> ");
        

    }
    static void damageEntity(int dmg, boolean isPlayer, boolean regen){
        if(!regen){
          if(!isPlayer) player_health -= dmg;
          else enemy_health -= dmg;
        }
        else{
          if(isPlayer) player_health += dmg;
          else enemy_health += dmg;
        }
        
    }
    
    public static void main(String[] args) throws InterruptedException, IOException{
        displayIntro();
        int turn = 1, dmg, choice;
        String[] enemy_moves = {"Solar Beam", "Fire Fist", "Flare Blitz", "Healer\'s Judgement"};
        while(player_health > 0 && enemy_health > 0)
        {
            if(turn == 1)
            {
                attackDisplay("Player");
                choice = sc.nextInt();
                if(choice > 4 || choice < 0){
                    slowPrint("Invalid attack provided. Try again.\n", dialogueSpeed);
                    continue;
                
                }
                dmg = damage[rn.nextInt(15)];
                damageEntity(dmg, true, (choice == 3));
                if(choice != 3)
                slowPrint("Your move dealt " + dmg + " damage.\nEmeny\'s health is at " + enemy_health + " hp", dialogueSpeed);
                else
                slowPrint("Your move healed " + dmg + " damage.\nYour health is at " + player_health + " hp", dialogueSpeed);
                turn++;
                
            }
            else{
              dmg = damage[rn.nextInt(11)];
              choice = rn.nextInt(4);           
              String move = enemy_moves[choice];
              damageEntity(dmg, false, (choice == 3));
              if(choice != 3)
              slowPrint("\n\nEnemy used " + move + " which dealt " + dmg + " damage.\nYour health is at " + player_health + " hp.\n", dialogueSpeed);
              else
              slowPrint("\n\nEnemy used " + move + " which healed " + dmg + " damage.\nEnemy health is at " + enemy_health + " hp.\n", dialogueSpeed);              turn--;
            }
            
            if(player_health > 100) player_health = 100;
            if(enemy_health > 100) enemy_health = 100;
        }
        
        if(player_health > enemy_health){
          slowPrint("[Player] Another day, another kill.", dialogueSpeed);
        Thread.sleep(sleepTime);
        }
        else if(enemy_health > player_health){
          slowPrint("[Enemy] Finally, the power of Gods.", dialogueSpeed);
        Thread.sleep(sleepTime);
        }
    }
}
