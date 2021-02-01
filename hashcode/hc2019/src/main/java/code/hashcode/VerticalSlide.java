/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.util.HashSet;
import java.util.Set;


public class VerticalSlide implements Slide {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    public Photo photo1;
    public Photo photo2;
    public Set<String> tags = new HashSet<String>();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public VerticalSlide() {
    }

    public VerticalSlide(Photo photo1, Photo photo2) {
        this.photo1 = photo1;
        this.photo2 = photo2;
        tags.addAll(photo1.getTags());
        tags.addAll(photo2.getTags());
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public Set<String> getTags() {
        return tags;
    }

    @Override
    public String printPhotoId() {
        return photo1.id + " " + photo2.id;
    }

    @Override
    public boolean isVertical() {
        return true;
    }
}
