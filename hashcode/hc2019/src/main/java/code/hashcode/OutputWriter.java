/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;


public class OutputWriter {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void writeFile(String fileName, Game game) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            List<Slide> slides = game.slides;
            writer.write(Integer.toString(slides.size()));
            writer.newLine();
            for (int i = 0; i < slides.size(); i++) {
                Slide slide = slides.get(i);
                writer.write(slide.printPhotoId());
                writer.newLine();
            }
        }

    }
}
