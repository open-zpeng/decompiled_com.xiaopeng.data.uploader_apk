package b.a.a.b.a;

import b.a.a.d;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes.dex */
public final class i extends t<Time> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f779a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final DateFormat f780b = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* loaded from: classes.dex */
    static class a implements u {
        a() {
        }

        @Override // b.a.a.u
        public <T> t<T> a(b.a.a.h hVar, b.a.a.e.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new i();
            }
            return null;
        }
    }

    @Override // b.a.a.t
    /* renamed from: d */
    public synchronized Time c(d.f fVar) throws IOException {
        if (fVar.t() == d.g.NULL) {
            fVar.w();
            return null;
        }
        try {
            return new Time(this.f780b.parse(fVar.v()).getTime());
        } catch (ParseException e) {
            throw new r(e);
        }
    }

    @Override // b.a.a.t
    /* renamed from: e */
    public synchronized void a(d.h hVar, Time time) throws IOException {
        hVar.j(time == null ? null : this.f780b.format((Date) time));
    }
}
