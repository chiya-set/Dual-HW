//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
/**
 * This class creates a hotel program and keeps track of room cost and guests.
 *
 * @author Priscilla Setiadi
 * @version 1.0
 */

public class Hotel {
    /**
     * Main method.
     *
     * @param args arguments from user input
     */
    public static void main(String[] args) {
        //takes cost of rooms, and fulfils commands of the user.
        Scanner scan = new Scanner(System.in);

        if (args.length != 2) {
            return;
        }

        int[] floors = new int[2];
        for (int i = 0; i < 2; i++) {
            if (Integer.parseInt(args[i]) < 1) {
                System.out.println("Invalid number of floors or rooms.");
                return;
            }
            floors[i] = Integer.parseInt(args[i]);
        }

        int[][] roomCosts = new int[floors[0]][floors[1]];

        boolean negative = false;
        for (int i = 0; i < roomCosts.length; i++) {
            System.out.print("Costs for floor " + (i + 1) + ": ");
            String price = scan.nextLine();

            String[] costs = price.split(" ");
            for (String cost : costs) {
                int num = Integer.parseInt(cost);
                if (num < 1) {
                    negative = true;
                    break;
                } else {
                    negative = false;
                }
            }

            if (negative) {
                do {
                    System.out.println("Room costs must be positive.");
                    System.out.print("Costs for floor " + (i + 1) + ": ");
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
                    if (count == costs.length) {
                        negative = false;
                    }
                }
                while (negative);
            }

            for (int j = 0; j < roomCosts[i].length; j++) {
                int num = Integer.parseInt(costs[j]);
                roomCosts[i][j] = num;
            }
        }

        int[][] durations = new int[floors[0]][floors[1]];
        String[][] guests = new String[floors[0]][floors[1]];

        String input = "";
        System.out.println();
        while (!input.equals("quit")) {
            System.out.print("> ");
            input = scan.nextLine();

            if (input.startsWith("in")) {
                String[] in = input.split(" ");
                String guest = in[1];
                int duration = Integer.parseInt(in[2]);
                int floor = Integer.parseInt(in[3]);
                int room = Integer.parseInt(in[4]);

                System.out.println(in(guest, duration, floor, room, guests, durations));

            }

            if (input.startsWith("price")) {
                String[] price = input.split(" ");
                int floor = Integer.parseInt(price[1]);
                int room = Integer.parseInt(price[2]);

                if (floor > guests.length
                        || room > guests[0].length || floor < 1
                        || room < 1) {
                    System.out.println("Invalid floor or room.");
                } else {
                    double cost = roomCosts[floor - 1][room - 1];

                    System.out.printf("The price for floor " + floor
                         + ", room " + room + " is $" + "%.2f per day.%n", cost);
                }
            }

            if (input.equals("print")) {
                for (int i = guests.length - 1; i >= 0; i--) {
                    String printed = "";
                    for (int j = 0; j < guests[i].length; j++) {
                        if (guests[i][j] == null) {
                            printed = printed + "| ";
                        } else {
                            printed = printed + "|" + guests[i][j];
                        }
                    }
                    printed = printed + "|";
                    System.out.println(printed);
                }
            }

            if (input.equals("nd")) {
                int num = 0;
                for (int i = 0; i < durations.length; i++) {
                    for (int j = 0; j < durations[i].length; j++) {
                        if (durations[i][j] != 0) {
                            num += 1;
                        }
                    }
                }
                String word = (num == 1) ? "guest" : "guests";
                double totalCost = (double) calculatePayment(guests, roomCosts);

                System.out.printf("Total payment from " + num + " " + word + ": $%.2f.%n", totalCost);
                for (int i = 0; i < durations.length; i++) {
                    for (int j = 0; j < durations[i].length; j++) {
                        if (durations[i][j] > 1 && durations[i][j] != 0) {
                            durations[i][j] = durations[i][j] - 1;
                        } else if (durations[i][j] == 1) {
                            System.out.println("Checking out " + guests[i][j]
                                + " from floor " + (i + 1) + ", room " + (j + 1) + ".");
                            guests[i][j] = null;
                            durations[i][j] = 0;
                        }
                    }
                }

            }

        }

    }

    /**
     * Returns in.
     *
     * @param name first variable
     * @param duration second variable
     * @param floor third variable
     * @param room fourth variable
     * @param guests fifth variable
     * @param timeSpent sixth variable
     *
     * @return a String
     */

    public static String in(String name, int duration, int floor, int room, String[][] guests, int[][] timeSpent) {
        for (int i = 0; i < guests.length; i++) {
            for (int j = 0; j < guests[i].length; j++) {
                if (name.equals(guests[i][j])) {
                    return name + " already checked in.";
                }
            }
        }

        if (floor > guests.length || room > guests[0].length
            || floor < 1 || room < 1) {
            return "Invalid floor or room.";
        }
        if (duration < 1) {
            return "Guests must stay at least one day.";
        }

        if (guests[floor - 1][room - 1] != null) {
            return "Room is already occupied.";
        }
        guests[floor - 1][room - 1] = name;

        String word = (duration == 1) ? "day" : "days";

        timeSpent[floor - 1][room - 1] = duration;

        return "Checking in " + name + " to floor " + floor + ", room " + room + ", for " + duration + " " + word + ".";

    }

    /**
     * calculate payment method. It calculates the payment of all guests in the hotel.
     *
     * @param guests first variable
     * @param costs second variable
     *
     * @return an int
     */
    public static int calculatePayment(String[][] guests, int[][] costs) {
        int total = 0;
        for (int i = 0; i < guests.length; i++) {
            for (int j = 0; j < guests[i].length; j++) {
                if (guests[i][j] != null) {
                    total = total + costs[i][j];
                }
            }
        }

        return total;

    }
}
