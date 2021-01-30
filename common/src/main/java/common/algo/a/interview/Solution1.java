package common.algo.a.interview;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.*;
import java.util.stream.Collectors;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution1
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        // WRITE YOUR CODE HERE
        List<AllocationDistance> distances = new ArrayList<>();
        for (int i = 0 ; i < allLocations.size(); i++ ) {
            distances.add(new AllocationDistance(allLocations.get(i)));
        }
        distances.sort(Comparator.comparingDouble(o -> o.distance));
        return distances.subList(0, numDeliveries).stream().map(AllocationDistance::getCoord).collect(Collectors.toList());
    }
    // METHOD SIGNATURE ENDS

    private final class AllocationDistance {

        private final double distance;
        private final List<Integer> coord;

        public AllocationDistance(List<Integer> coord) {
            this.coord = coord;
            this.distance = Math.sqrt(coord.get(0) * coord.get(0) + coord.get(1) * coord.get(1) );
        }

        public double getDistance() {
            return distance;
        }

        public List<Integer> getCoord() {
            return coord;
        }
    }
}

