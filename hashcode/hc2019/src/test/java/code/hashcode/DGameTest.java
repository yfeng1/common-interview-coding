package code.hashcode;

import org.junit.Test;

public class DGameTest {

    @Test
    public void test() throws Exception {
        int version = 69;
        String fileName = "./src/test/resources/code/hashcode/input/d_pet_pictures.txt";
        String fileName1;
        String fileName2;
        while(true) {
            Game game = InputReader.readFile(fileName, new Game(1000, 500000, 10000.0, 1.02f));
            fileName1 = "./src/test/resources/code/hashcode/out/d" + (version - 1) + ".out";
            fileName2 = "./src/test/resources/code/hashcode/out/d" + version + ".out";
            game.runWithFileSwitchRange(fileName1);
            OutputWriter.writeFile(fileName2, game);
            version++;
        }
    }
}
