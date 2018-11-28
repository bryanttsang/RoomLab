package Rooms;

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
        if (yn.toLowerCase().trim().equals("y"))
        {
            System.out.println("Where would you like to go? Enter a coordinate (x, y) or R for random.");
            Scanner in = new Scanner(System.in);
            String go = in.nextLine();
            if (go.toLowerCase().trim().equals("r"))
            {
                x.setxLoc((int)(Math.random()*building.length));
                x.setyLoc(this.yLoc);
            }
        }
    }
}