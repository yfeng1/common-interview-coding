/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import org.junit.Test;


public class InputReaderTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    public void testReader() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/a_example.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        System.out.println("Expected: ");
        FilePrinter.print(fileName);
        System.out.println("Actual: ");
        for (Photo photo : game.photos) {
            System.out.println(photo);
        }
    }

    @Test
    public void testReader2() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/b_lovely_landscapes.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        System.out.println("Expected: ");
        FilePrinter.print(fileName);
        System.out.println("Actual: ");
        for (Photo photo : game.photos) {
            System.out.println(photo);
        }
    }

    @Test
    public void testReader3() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/c_memorable_moments.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        System.out.println("Expected: ");
        FilePrinter.print(fileName);
        System.out.println("Actual: ");
        for (Photo photo : game.photos) {
            System.out.println(photo);
        }
    }

    @Test
    public void testReader4() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/d_pet_pictures.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        System.out.println("Expected: ");
        FilePrinter.print(fileName);
        System.out.println("Actual: ");
        for (Photo photo : game.photos) {
            System.out.println(photo);
        }
    }

    @Test
    public void testReader5() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/input/e_shiny_selfies.txt";
        Game game = InputReader.readFile(fileName, new Game(1000, 200000, 100000.0, 1.02f));
        System.out.println("Expected: ");
        FilePrinter.print(fileName);
        System.out.println("Actual: ");
        for (Photo photo : game.photos) {
            System.out.println(photo);
        }
    }
}
