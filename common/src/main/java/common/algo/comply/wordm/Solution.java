package common.algo.comply.wordm;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {

    private static final String DUPLICATE = "DUP";
    private static final String POP = "POP";
    private static final String PLUS = "+";
    private static final String MINUS = "-";

    private static final int MAXIMUM = (int)(Math.pow(2, 20) - 1);

    // Machine can store only number from 0 - 2^20-1;
    private LinkedList<Integer> machineStack = new LinkedList<>();

    public int solution(String input) {
        // write your code in Java SE 8
        String[] commands = input.split(" ");

        try {
            for (String command : commands) {
                switch (command) {
                    case DUPLICATE :
                        performDuplicate();
                        break;
                    case POP:
                        performPop();
                        break;
                    case PLUS:
                        performPlus();
                        break;
                    case MINUS:
                        performMinus();
                        break;
                    default:
                        performPush(command);
                        break;
                }
            }

            return machineStack.getLast();
        } catch (MachineException e) {
            return -1;
        }

    }

    private void performMinus() throws MachineException {
        try {
            Integer first = machineStack.removeLast();
            Integer second = machineStack.removeLast();
            int minus = first - second;
            if (minus < 0) {
                throw new MachineException();
            } else {
                machineStack.addLast(minus);
            }
        } catch (NoSuchElementException e) {
            throw new MachineException();
        }
    }

    private void performPlus() throws MachineException {
        try {
            Integer first = machineStack.removeLast();
            Integer second = machineStack.removeLast();
            int sum = first + second;
            if (sum > MAXIMUM) {
                throw new MachineException();
            } else {
                machineStack.addLast(sum);
            }
        } catch (NoSuchElementException e) {
            throw new MachineException();
        }
    }

    private void performPop() throws MachineException {
        if (machineStack.isEmpty()) {
            throw new MachineException();
        } else {
            machineStack.removeLast();
        }
    }

    private void performDuplicate() throws MachineException {
        if (machineStack.isEmpty()) {
            throw new MachineException();
        } else {
            machineStack.addLast(machineStack.getLast());
        }
    }

    private void performPush(String command) throws MachineException {
        try {
            int unsignedInt = Integer.parseUnsignedInt(command);
            if (unsignedInt > MAXIMUM) {
                throw new MachineException();
            }
            machineStack.addLast(unsignedInt);
        } catch (NumberFormatException e) {
            throw new MachineException();
        }
    }

    private static class MachineException extends Exception {
        public MachineException() {
        }
    }

}