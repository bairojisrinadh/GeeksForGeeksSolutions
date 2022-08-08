package org.domain.objects;

import java.util.Arrays;

public class GFGIntArrayInputTemplate extends GFGInputTemplate {
    private int inputLength = -1;
    private int requiredOutputIfAny = -1;
    private int[] arr;

    public GFGIntArrayInputTemplate() {
    }

    public int getInputLength() {
        return inputLength;
    }

    public void setInputLength(int inputLength) {
        this.inputLength = inputLength;
    }

    public int getRequiredOutputIfAny() {
        return requiredOutputIfAny;
    }

    public void setRequiredOutputIfAny(int requiredOutputIfAny) {
        this.requiredOutputIfAny = requiredOutputIfAny;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "GFGIntArrayInputTemplate{" +
                "inputLength=" + inputLength +
                ", requiredOutputIfAny=" + requiredOutputIfAny +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
