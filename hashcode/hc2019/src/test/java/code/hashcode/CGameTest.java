package code.hashcode;

import org.junit.Test;

public class CGameTest {

    @Test
    public void test() throws Exception {
        int version = 61;
        String fileName = "./src/test/resources/code/hashcode/input/c_memorable_moments.txt";
        String fileName1;
        String fileName2;
        while(true) {
            fileName1 = "./src/test/resources/code/hashcode/out/c" + (version - 1) + ".out";
            fileName2 = "./src/test/resources/code/hashcode/out/c" + version + ".out";
            Game game = InputReader.readFile(fileName, new Game(1000, 100000, 100000.0, 1.02f));
            game.runWithFileSwitchRange(fileName1);
            OutputWriter.writeFile(fileName2, game);
            version++;
        }
    }
}
