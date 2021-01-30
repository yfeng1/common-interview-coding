package com.parking;

import com.parking.slot.Slot;

public interface FeePolicy {

    double fee(Slot slot);

}
