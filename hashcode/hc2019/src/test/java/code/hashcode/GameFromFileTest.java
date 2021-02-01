/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import org.junit.Ignore;
import org.junit.Test;


public class GameFromFileTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Static fields/initializers
    //~ ----------------------------------------------------------------------------------------------------------------

    private static final int version = 35;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    @Ignore
    public void testInit() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/a_example.txt";
        String fileName1 = "./src/test/resources/code/hashcode/out/a" + (version - 1) + ".out";
        String fileName2 = "./src/test/resources/code/hashcode/out/a" + version + ".out";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.runWithFile(fileName1);
        OutputWriter.writeFile(fileName2, game);
    }

    @Test
    public void testInit2() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/b_lovely_landscapes.txt";
        String fileName1 = "./src/test/resources/code/hashcode/out/b" + (version - 1) + ".out";
        String fileName2 = "./src/test/resources/code/hashcode/out/b" + version + ".out";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.runWithFile(fileName1);
        OutputWriter.writeFile(fileName2, game);
    }

    @Test
    public void testInit3() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/c_memorable_moments.txt";
        String fileName1 = "./src/test/resources/code/hashcode/out/c" + (version - 1) + ".out";
        String fileName2 = "./src/test/resources/code/hashcode/out/c" + version + ".out";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.runWithFile(fileName1);
        OutputWriter.writeFile(fileName2, game);
    }

    @Test
    public void testInit4() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/d_pet_pictures.txt";
        String fileName1 = "./src/test/resources/code/hashcode/out/d" + (version - 1) + ".out";
        String fileName2 = "./src/test/resources/code/hashcode/out/d" + version + ".out";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.runWithFile(fileName1);
        OutputWriter.writeFile(fileName2, game);
    }

    @Test
    public void testInit5() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/e_shiny_selfies.txt";
        String fileName1 = "./src/test/resources/code/hashcode/out/e" + (version - 1) + ".out";
        String fileName2 = "./src/test/resources/code/hashcode/out/e" + version + ".out";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.runWithFile(fileName1);
        OutputWriter.writeFile(fileName2, game);
    }

}
