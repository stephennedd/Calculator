package nl.saxion.cos;

public enum DataType {
    INT("i", "I" ),
    FLOAT("f", "F");

    private final String mnemonic;
    private final String descriptor;

    DataType(String mnemonic, String descriptor) {
        this.mnemonic = mnemonic;
        this.descriptor = descriptor;
    }

    public String getMnemonic() {
        return mnemonic;
    }

    public String getDescriptor() {
        return descriptor;
    }

}
