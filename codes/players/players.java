package players;

import java.util.Scanner;

public class players {
    private String name;
    private String emailid;
    private String concno;
    private int age;
    private String address;

    public void setPlayerDetails(String name, String emailid, String concno, String address, int age) {
        this.name = name;
        this.emailid = emailid;
        this.concno = concno;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return this.name;
    }

    public void getPlayerDetails() {
        System.out.println("player name: " + this.name);
        System.out.println("player age: " + this.age);
        System.out.println("player emailid: " + this.emailid);
        System.out.println("player concno: " + this.concno);
        System.out.println("player address :" + this.address);

    }

    public void setPlayerDetailsFromUser(players p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player details");
        System.out.println("Enter the player name");
        String name = sc.nextLine();
        System.out.println("Enter the player emailid");
        String emailid = sc.nextLine();
        System.out.println("Enter the player contact number");
        String concno = sc.nextLine();
        System.out.println("Enter the player addresss");
        String address = sc.nextLine();
        System.out.println("Enter the player age");
        int age = sc.nextInt();

        // players p = new players();
        p.setPlayerDetails(name, emailid, concno, address, age);

    }

}
