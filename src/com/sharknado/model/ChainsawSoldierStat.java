package com.sharknado.model;

public class ChainsawSoldierStat {
   
    private final Location location;
    private final Chainsaw chainSaw;
    private final int chainSawNumber;
    private final int womenNumber;
    private final int menNumber;

    public static class Builder {

        private Location location;
        private Chainsaw chainSaw;
        private int chainSawNumber;
        private int womenNumber;
        private int menNumber;

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setChainSaw(Chainsaw chainSaw) {
            this.chainSaw = chainSaw;
            return this;
        }

        public Builder setChainSawNumber(int chainSawNumber) {
            this.chainSawNumber = chainSawNumber;
            return this;
        }

        public Builder setWomenNumber(int womenNumber) {
            this.womenNumber = womenNumber;
            return this;
        }

        public Builder setMenNumber(int menNumber) {
            this.menNumber = menNumber;
            return this;
        }
        
        public ChainsawSoldierStat build(){
            return new ChainsawSoldierStat(this.location, this.chainSaw, this.chainSawNumber, this.womenNumber, this.menNumber);
        }

    }
    
    public ChainsawSoldierStat(Location location, Chainsaw chainSaw, int chainSawNumber, int womenNumber, int menNumber) {
        this.location = location;
        this.chainSaw = chainSaw;
        this.chainSawNumber = chainSawNumber;
        this.womenNumber = womenNumber;
        this.menNumber = menNumber;
    }

    public Location getLocation() {
        return this.location;
    }

    public Chainsaw getChainSaw() {
        return this.chainSaw;
    }

    public int getWomenNumber() {
        return this.womenNumber;
    }

    public int getMenNumber() {
        return this.menNumber;
    }

    public int getChainSawNumber() {
        return this.chainSawNumber;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.location != null ? this.location.hashCode() : 0);
        hash = 23 * hash + (this.chainSaw != null ? this.chainSaw.hashCode() : 0);
        hash = 23 * hash + this.womenNumber;
        hash = 23 * hash + this.menNumber;
        hash = 23 * hash + this.chainSawNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChainsawSoldierStat other = (ChainsawSoldierStat) obj;
        return (this.womenNumber == other.womenNumber) &&
               (this.menNumber == other.menNumber) &&
               (this.location == other.location) &&
               (this.chainSaw == other.chainSaw) &&
               (this.chainSawNumber == other.chainSawNumber);
    }

    @Override
    public String toString() {
        return "ChainsawSoldierStat{location=" + location + ", chainSaw=" + chainSaw + ", chainSawNumber=" + chainSawNumber + ", womenNumber=" + womenNumber + ", menNumber=" + menNumber + '}';
    }

    
}
