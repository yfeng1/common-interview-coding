/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import org.junit.Test;


public class OutputWriterTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    public void test1() throws Exception {
        String fileName = "./src/test/resources/code/hashcode/out/testOut1";

        Game game = new Game(1000, 200000, 100000.0, 1.02f);
        game.addSlide(new HorizonSlide(new Photo(1)));
        game.addSlide(new VerticalSlide(new Photo(3), new Photo(2)));

        OutputWriter.writeFile(fileName, game);
        FilePrinter.print(fileName);
    }
}
