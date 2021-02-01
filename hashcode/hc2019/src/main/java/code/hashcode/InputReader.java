/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class InputReader {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static Game readFile(String fileName, Game game) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int nbPhotos = scanner.nextInt();
        scanner.nextLine();

        // Jump the first line
        for (int i = 0; i < nbPhotos; i++) {
            String nextLine = scanner.nextLine();
            String[] splited = nextLine.split(" ");
            Photo photo = new Photo();
            boolean isVertical = true;
            if ("H".equals(splited[0])) {
                isVertical = false;
            }
            photo.isVertical = isVertical;
            photo.id = i;
            for (int j = 0; j < (splited.length - 2); j++) {
                photo.tags.add(splited[j + 2]);
            }
            game.addPhoto(photo);
//            if (photo.tags.size() != 1) {
//                game.addPhoto(photo);
//            }
        }
        return game;
    }

}
