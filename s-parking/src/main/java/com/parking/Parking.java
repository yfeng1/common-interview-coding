package com.parking;

import com.parking.slot.Slot;

import java.util.List;

public class Parking {

    private final FeePolicy policy;
    private final List<Slot> slots;

    public Parking(FeePolicy policy, int nbStandardSlot, int nbSlot30Kw, int nbSlot50Kw) {
        this.policy = policy;

    }
}
