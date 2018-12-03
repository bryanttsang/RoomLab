package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class TeleportingRoom extends Room
{
    public TeleportingRoom(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You entered the teleporting room! Would you like to teleport? (Choose Y/N)");
        Scanner in = new Scanner(System.in);
        String yn = in.nextLine();
        if (!yn.toLowerCase().trim().equals("y") || yn.toLowerCase().trim().equals("r"))
        {
            while (!yn.toLowerCase().trim().equals("y") || yn.toLowerCase().trim().equals("r"))
            {
                System.out.println("Please choose C/R");
                in = new Scanner(System.in);
                yn = in.nextLine();
            }
        }
        if (yn.toLowerCase().trim().equals("y"))
        {
            System.out.println("Where would you like to go? Enter C for a coordinate or R for random.");
            in = new Scanner(System.in);
            String go = in.nextLine();
            if (go.toLowerCase().trim().equals("r"))
            {
                x.setxLoc(Runner.xy());
                x.setyLoc(Runner.xy());
            }
            if (go.toLowerCase().trim().equals("c"))
            {
                System.out.println("Enter the X coordinate.");
                in = new Scanner(System.in);
                int xLoc = in.nextInt();
                System.out.println("Enter the Y coordinate.");
                in = new Scanner(System.in);
                int yLoc = in.nextInt();
                x.setxLoc(xLoc);
                x.setyLoc(yLoc);
            }
        }
    }
}