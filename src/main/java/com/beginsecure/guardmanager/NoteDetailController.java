package com.beginsecure.guardmanager;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class NoteDetailController {
    @FXML
    private TextArea noteArea;
    @FXML
    public void setNoteText(String text) {
        noteArea.setText(text);
    }
    @FXML
    public String getNoteText() {
        return noteArea.getText();
    }
}
