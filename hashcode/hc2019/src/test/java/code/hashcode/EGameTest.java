package code.hashcode;

import org.junit.Test;

public class EGameTest {

    @Test
    public void test() throws Exception {
        int version = 85;
        String fileName = "./src/test/resources/code/hashcode/input/e_shiny_selfies.txt";
        String fileName1;
        String fileName2;
        while (true) {
            Game game = InputReader.readFile(fileName, new Game(1000, 80000, 10000.0, 1.02f));
            fileName1 = "./src/test/resources/code/hashcode/out/e" + (version - 1) + ".out";
            fileName2 = "./src/test/resources/code/hashcode/out/e" + version + ".out";
            game.runWithFileSwitchRange(fileName1);
            OutputWriter.writeFile(fileName2, game);
            version++;
        }
    }
}
