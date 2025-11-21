package com.jad;

public class Grault {
    private Foo foo;

    /**
     * Constructeur avec référence obligatoire à Foo.
     * Grault ne peut exister sans son Foo parent.
     */
    public Grault(Foo foo) {
        this.foo = foo;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}