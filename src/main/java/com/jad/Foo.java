package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    // Attributs
    private Bar bar;                        // Association simple (1)
    private List<Baz> bazs;                 // Agrégation (*)
    private Qux qux;                        // Composition (1)
    private Corge corge;                    // Association bidirectionnelle (0..1)
    private List<Grault> graults;           // Composition (*)

    // Constructeur
    public Foo(Bar bar) {
        this.bar = bar;
        this.qux = new Qux();               // COMPOSITION : créé ici
        this.bazs = new ArrayList<>();
        this.graults = new ArrayList<>();
    }

    // Getters
    public Bar getBar() {
        return bar;
    }

    public List<Baz> getBazs() {
        return bazs;
    }

    public Qux getQux() {
        return qux;
    }

    public Corge getCorge() {
        return corge;
    }

    public List<Grault> getGraults() {
        return graults;
    }

    // Setters basiques (sauf setCorge traité plus tard)
    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public void setBazs(List<Baz> bazs) {
        this.bazs = bazs;
    }

    public void setQux(Qux qux) {
        this.qux = qux;
    }

    public void setGraults(List<Grault> graults) {
        this.graults = graults;
    }
    public void addBaz(Baz baz) {
        this.bazs.add(baz);
    }

    public void addGrault() {
        Grault grault = new Grault(this);
        this.graults.add(grault);
    }
    public void setCorge(Corge newCorge) {
        if (this.corge == newCorge) {
            return; // Protection contre appels redondants
        }

        // Nettoie l'ancienne relation
        if (this.corge != null) {
            Corge oldCorge = this.corge;
            this.corge = null; // Évite les boucles
            oldCorge.setFoo(null);
        }

        // Établit la nouvelle relation
        this.corge = newCorge;
        if (newCorge != null && newCorge.getFoo() != this) {
            newCorge.setFoo(this);
        }
    }
}