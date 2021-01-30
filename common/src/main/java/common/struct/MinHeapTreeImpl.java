package common.struct;

public class MinHeapTreeImpl implements MinHeapTree {

    private int[] minHeapTreeArr;
    private int size;
    private int maxSize;

    public MinHeapTreeImpl(int maxSize)
    {
        this.maxSize = maxSize;
        this.size = 0;
        minHeapTreeArr = new int[this.maxSize + 1];
        minHeapTreeArr[0] = Integer.MIN_VALUE;
    }

    @Override
    public int getMin() {
        if (minHeapTreeArr.length > 0){
            return minHeapTreeArr[0];
        }
        else {
            throw new IllegalStateException("No element in the min heap tree.");
        }
    }

    @Override
    public int extractMin() {
        return 0;
    }

    @Override
    public void insert(int value) {
        
    }
}
