package org.lanqiao.ffs.controller;

import org.lanqiao.ffs.service.ILegerService;
import org.lanqiao.ffs.service.impl.LegerServiceImpl;
import org.lanqiao.ffs.views.AbstractShapeDialog;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ShapeDiagloController extends AbstractShapeDialog {
    private ILegerService service = new LegerServiceImpl();
    public ShapeDiagloController(JDialog dialog) throws SQLException {
        super(dialog);
        initDialog();

    }
    @Override
    public List<String> getImagePaths() throws SQLException {
        return service.createPie();
    }
}
