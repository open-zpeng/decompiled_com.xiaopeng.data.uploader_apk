package b.a.a;

import b.a.a.b.a.e;
import b.a.a.d;
import java.io.IOException;
/* compiled from: TypeAdapter.java */
/* loaded from: classes.dex */
public abstract class t<T> {
    public abstract void a(d.h hVar, T t) throws IOException;

    public final v b(T t) {
        try {
            e eVar = new e();
            a(eVar, t);
            return eVar.B();
        } catch (IOException e) {
            throw new l(e);
        }
    }

    public abstract T c(d.f fVar) throws IOException;
}
