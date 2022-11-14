package com.raven.swing.table;

import com.raven.model.ModelStudent;
import com.raven.model.NhanVien;

public class ModelAction {

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(NhanVien nhanVien, EventAction event) {
        this.nhanVien = nhanVien;
        this.event = event;
    }

    public ModelAction() {
    }

    private NhanVien nhanVien;
    private EventAction event;
}
