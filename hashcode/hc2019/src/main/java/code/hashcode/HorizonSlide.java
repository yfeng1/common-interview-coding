/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.util.Set;


public class HorizonSlide implements Slide {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    public Photo photo;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public HorizonSlide() {
    }

    public HorizonSlide(Photo photo) {
        this.photo = photo;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public Set<String> getTags() {
        return photo.getTags();
    }

    @Override
    public String printPhotoId() {
        return Long.toString(photo.id);
    }

    @Override
    public boolean isVertical() {
        return false;
    }
}
