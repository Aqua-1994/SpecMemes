package com.aqua1994;

public enum Sound {

    //D pick
    SMASHING("Smashing.wav"),
    //D axe
    CHOP("chop.wav"),
    FISHIES("fishies.wav"),
    //D battle axe
    RAARGH("Raargh.wav"),
    //Excalibur
    CAMELOT("camelot.wav"),
    ;

    private final String resourceName;

    Sound(String resNam) {
        resourceName = resNam;
    }

    String getResourceName() {
        return resourceName;
    }
}
