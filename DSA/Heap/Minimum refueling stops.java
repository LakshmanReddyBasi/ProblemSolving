// A car travels from a starting position to a destination which is target miles east of the starting position.

// There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

// The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.

// Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

// Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

 

// Example 1:

// Input: target = 1, startFuel = 1, stations = []
// Output: 0
// Explanation: We can reach the target without refueling.
// Example 2:

// Input: target = 100, startFuel = 1, stations = [[10,100]]
// Output: -1
// Explanation: We can not reach the target (or even the first gas station).
// Example 3:

// Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
// Output: 2
// Explanation: We start with 10 liters of fuel.
// We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
// Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
// and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
// We made 2 refueling stops along the way, so we return 2.

Soln:

import java.util.*;

public class Main
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int target = Integer.parseInt(firstLine[0]);
        int startFuel = Integer.parseInt(firstLine[1]);
        int n = Integer.parseInt(firstLine[2]);
        int[][] stations = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] station = scanner.nextLine().split(" ");
            stations[i][0] = Integer.parseInt(station[0]);
            stations[i][1] = Integer.parseInt(station[1]);
        }
        int result = minRefuelStops(target, startFuel, stations);
        System.out.println(result);
	}
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        if (startFuel>=target){
            return 0;
        }
        int i=0,maxDistance=startFuel,n=stations.length,stops=0;
        while(maxDistance<target){
            while (i<n && maxDistance>=stations[i][0]){
                pq.offer(stations[i++][1]);
            }
            if(pq.isEmpty()) return -1;
            maxDistance+=pq.poll();
            stops++;
        }
        return stops;
    }
}
