package common.algo.a.interview;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution2
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        // WRITE YOUR CODE HERE
        // Init
        List<List<MapPoint>> mapPoints = new ArrayList<>();
        for (int i = 0; i < area.size(); i++) {
            List<MapPoint> mapPRow = new ArrayList<>();
            for (int j = 0; j < area.get(i).size(); j++) {
                mapPRow.add(new MapPoint(i, j, area.get(i).get(j)));
            }
            mapPoints.add(mapPRow);
        }
        Set<MapPoint> currentPoints = new HashSet<>();
        Set<MapPoint> nextPoints = new HashSet<>();

        currentPoints.add(mapPoints.get(0).get(0));
        int currentStep = 0;
        while (!currentPoints.isEmpty()) {
            for (MapPoint currentPoint : currentPoints) {
                if (currentPoint.value == 9) {
                    return currentStep;
                } else if (currentPoint.value == 0) {
                } else if (currentPoint.value == 1) {
                    // Refresh the step;
                    if (currentPoint.step > currentStep) {
                        currentPoint.step = currentStep;
                        if ((currentPoint.row - 1 >= 0) && mapPoints.get(currentPoint.row -1).get(currentPoint.column).step > currentStep) {
                            nextPoints.add(mapPoints.get(currentPoint.row -1).get(currentPoint.column));
                        }
                        if ((currentPoint.column - 1 >= 0 ) && mapPoints.get(currentPoint.row).get(currentPoint.column - 1).step > currentStep) {
                            nextPoints.add(mapPoints.get(currentPoint.row).get(currentPoint.column - 1));
                        }
                        if ((currentPoint.row + 1 < numRows) && mapPoints.get(currentPoint.row +1).get(currentPoint.column).step > currentStep) {
                            nextPoints.add(mapPoints.get(currentPoint.row + 1).get(currentPoint.column));
                        }
                        if ((currentPoint.column + 1 < numColumns ) && mapPoints.get(currentPoint.row).get(currentPoint.column + 1).step > currentStep) {
                            nextPoints.add(mapPoints.get(currentPoint.row).get(currentPoint.column + 1));
                        }
                    }
                }
            }
            currentStep ++;
            currentPoints.clear();
            currentPoints.addAll(nextPoints);
            nextPoints.clear();
        }
        return -1;

    }

    private final class MapPoint {
        private final int row;
        private final int column;
        private final int value;
        private int step;
        private static final int MAX_STEP = 2001;

        public MapPoint(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
            this.step = MAX_STEP;
        }
    }
    // METHOD SIGNATURE ENDS
}

