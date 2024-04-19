package b.c.a.f;

import java.util.ArrayList;
import java.util.List;
/* compiled from: TableEntity.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f1174a;

    /* renamed from: b  reason: collision with root package name */
    private List<c> f1175b = new ArrayList();

    public f(String str) {
        this.f1174a = str;
    }

    public f a(c cVar) {
        this.f1175b.add(cVar);
        return this;
    }

    public String b() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sb.append(this.f1174a);
        sb.append('(');
        for (c cVar : this.f1175b) {
            if (cVar.f1168c != null) {
                sb.append("PRIMARY KEY (");
                for (String str : cVar.f1168c) {
                    sb.append(str);
                    sb.append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(")");
            } else {
                sb.append(cVar.f1166a);
                sb.append(" ");
                sb.append(cVar.f1167b);
                if (cVar.e) {
                    sb.append(" NOT NULL");
                }
                if (cVar.f1169d) {
                    sb.append(" PRIMARY KEY");
                }
                if (cVar.f) {
                    sb.append(" AUTOINCREMENT");
                }
                sb.append(",");
            }
        }
        if (sb.toString().endsWith(",")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(')');
        return sb.toString();
    }

    public int c() {
        return this.f1175b.size();
    }

    public int d(String str) {
        int c2 = c();
        for (int i = 0; i < c2; i++) {
            if (this.f1175b.get(i).f1166a.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
