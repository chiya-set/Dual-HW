import java.util.Scanner;

public class Hotel {
    
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);

        if (args.length != 2) { 
            return;
        }

        int[] floors = new int[2];
        for (int i = 0; i < 2; i++) { 
            if (Integer.parseInt(args[i]) < 1){
                System.out.println("Invalid number of floors or rooms.");
                return;
            }
            floors[i] = Integer.parseInt(args[i]);
        }

        int[][] room_costs = new int[floors[0]][floors[1]];

        boolean negative = false;
        for (int i = 0; i < room_costs.length; i++){
            System.out.print("Costs for floor " + (i + 1) + ": ");
            String price = scan.nextLine();

            String[] costs = price.split(" ");
            
            for (String cost : costs){
                int num = Integer.parseInt(cost);
                if (num < 1){
                    negative = true;
                    break;
                }else{
                    negative = false;
                }
            }

            if (negative == true) { 
                do { 
                    System.out.println("Room costs must be positive.");
                    System.out.print("Costs for floor " + i + ": ");
                    price = scan.nextLine();

                    costs = price.split(" ");
                    int count = 0;
                    for (String cost : costs) { 
                        int num = Integer.parseInt(cost);
                        if (num < 1) { 
                            negative = true;
                        } else {
                            count++;
                        }
                    }
                    if (count == costs.length){
                        negative = false;
                    }
                    
                }
                while (negative == true);
            }

            for (int j = 0; j < room_costs[i].length; j++){
                int num = Integer.parseInt(costs[j]);
                room_costs[i][j] = num;
            }
        }

        int[][] durations = new int[floors[0]][floors[1]];
        String[][] guests = new String[floors[0]][floors[1]];

        String input = "";
        while (!input.equals("quit")){
            System.out.print("> ");
            input = scan.nextLine();

            if (input.substring(0, 2).equals("in")){
                String[] in = input.split(" ");
                String guest = in[1];
                int duration = Integer.parseInt(in[2]);
                int floor = Integer.parseInt(in[3]);
                int room = Integer.parseInt(in[4]);

                System.out.println(in(guest, duration, floor, room, guests, durations));

            }

        }

    }

    public static String in (String name, int duration, int floor, int room, String[][] guests, int[][] time_spent) {

        for (int i = 0; i < guests.length; i++){
            for (int j = 0; j < guests[i].length; j++){
                if (name.equals(guests[i][j])){
                    return name + " already checked in.";
                }
            }
        }
        if ((floor > guests.length) || (room > guests[0].length) ||(floor < 1) || (room < 1)){
            return "Invalid floor or room.";
        }
        if (duration < 1){
            return "Guests must stay at least one day.";
        }

        if (guests[floor - 1][room - 1] != null){
            return "Room is already occupied.";
        }
        guests[floor - 1][room - 1] = name;

        String word = (duration == 1) ? "day" : "days";

        time_spent[floor - 1][room - 1] = duration;

        return "Checking in " + name + " to floor " + floor + ", room " + room + ", for " + duration + " " + word + ".";
        
    }
}
