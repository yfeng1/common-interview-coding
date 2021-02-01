/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import org.junit.Test;


public class GameTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    public void testInit() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/a_example.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.run();
        String fileName1 = "./src/test/resources/code/hashcode/out/a0.out";
        OutputWriter.writeFile(fileName1, game);
        FilePrinter.print(fileName1);
    }

    @Test
    public void testInit2() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/b_lovely_landscapes.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.run();
        String fileName1 = "./src/test/resources/code/hashcode/out/b0.out";
        OutputWriter.writeFile(fileName1, game);
        FilePrinter.print(fileName1);
    }

    @Test
    public void testInit3() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/c_memorable_moments.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.run();
        String fileName1 = "./src/test/resources/code/hashcode/out/c0.out";
        OutputWriter.writeFile(fileName1, game);
        FilePrinter.print(fileName1);
    }

    @Test
    public void testInit4() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/d_pet_pictures.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.run();
        String fileName1 = "./src/test/resources/code/hashcode/out/d0.out";
        OutputWriter.writeFile(fileName1, game);
        FilePrinter.print(fileName1);
    }

    @Test
    public void testInit5() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/e_shiny_selfies.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        game.run();
        String fileName1 = "./src/test/resources/code/hashcode/out/e0.out";
        OutputWriter.writeFile(fileName1, game);
        FilePrinter.print(fileName1);
    }

}
