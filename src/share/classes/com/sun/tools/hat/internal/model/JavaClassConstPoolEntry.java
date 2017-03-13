package com.sun.tools.hat.internal.model;


/**
 *
 * @author      Neville Grech
 */

public class JavaClassConstPoolEntry {

    private final int index;
    private final String signature;
    private JavaThing value;

    public JavaClassConstPoolEntry(int index, String signature, JavaThing value) {
        this.index = index;
        this.signature = signature;
        this.value = value;
    }

    public void resolve(JavaClass clazz, Snapshot snapshot) {
        value = value.dereference(snapshot, null);

    }

    /**
     * @return true if the type of this field is something that has an ID.
     *          int fields, for example, don't.
     */
    public boolean hasId() {
        char ch = signature.charAt(0);
        return (ch == '[' || ch == 'L');
    }

    public int getIndex() {
        return index;
    }

    public String getSignature() {
        return signature;
    }

    public JavaThing getValue() {
        return value;
    }

}
