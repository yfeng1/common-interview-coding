/**
 *  Copyright Murex S.A.S., 2003-2019. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package code.hashcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Photo {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    public long id;
    public Set<String> tags = new HashSet<>();
    public boolean isVertical;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public Photo() {
    }

    public Photo(long id) {
        this.id = id;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public long getId() {
        return id;
    }

    public Set<String> getTags() {
        return this.tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

    public boolean isVertical() {
        return this.isVertical;
    }

    @Override
    public String toString() {
        return "Photo{" +
            "id=" + id +
            ", tags=" + tags.stream().collect(Collectors.joining(" | ")) +
            ", isVertical=" + isVertical + '}';
    }
}
