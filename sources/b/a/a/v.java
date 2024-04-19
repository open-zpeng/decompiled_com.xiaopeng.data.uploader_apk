package b.a.a;

import b.a.a.d;
import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class v {
    public boolean a() {
        return this instanceof n;
    }

    public boolean b() {
        return this instanceof j;
    }

    public boolean c() {
        return this instanceof m;
    }

    public boolean d() {
        return this instanceof p;
    }

    public n e() {
        if (a()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public j f() {
        if (b()) {
            return (j) this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public p g() {
        if (d()) {
            return (p) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            d.h hVar = new d.h(stringWriter);
            hVar.l(true);
            b.a.a.b.k.b(this, hVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
