package com.jad;

public class Corge {
    private Foo foo;

    /**
     * Constructeur établissant la relation bidirectionnelle.
     * Initialise à null puis appelle foo.setCorge(this).
     */
    public Corge(Foo foo) {
        this.foo = null; // Évite les boucles immédiates
        if (foo != null) {
            foo.setCorge(this); // Établit la bidirectionnalité
        }
    }

    public Foo getFoo() {
        return foo;
    }

    /**
     * Setter avec gestion bidirectionnelle.
     * Nettoie les anciennes références et établit les nouvelles.
     */
    public void setFoo(Foo newFoo) {
        if (this.foo == newFoo) {
            return; // Protection contre appels redondants
        }

        // Nettoie l'ancienne relation
        if (this.foo != null) {
            Foo oldFoo = this.foo;
            this.foo = null; // Évite les boucles
            oldFoo.setCorge(null);
        }

        // Établit la nouvelle relation
        this.foo = newFoo;
        if (newFoo != null && newFoo.getCorge() != this) {
            newFoo.setCorge(this);
        }
    }
}