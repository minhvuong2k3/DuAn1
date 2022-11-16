package com.raven.swing.table;

import com.raven.model.ModelStudent;
import com.raven.model.NhanVien;

public interface EventAction {

    public void delete(ModelStudent student);

    public void update(ModelStudent student);
}
