package com.raven.swing.table;

import com.raven.model.ModelStudent;
import com.raven.model.NhanVien;

public interface EventAction {

    public void delete(NhanVien nhanVien);

    public void update(NhanVien nhanVien);
}
