package com.beginsecure.guardmanager;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloController {
    @FXML
    private Label newTask;
    @FXML
    private Label search;
    @FXML
    private Label profile;

    @FXML
    private Label welcomeGM;

    @FXML
    private VBox notesContainer;

    @FXML
    private void createNewTask() {
        TextArea noteEditor = new TextArea();
        noteEditor.setPromptText("Введите заметку...");
        noteEditor.setWrapText(true);
        noteEditor.setPrefWidth(100);  // ширина
        noteEditor.setPrefHeight(30);  // высота
        noteEditor.setMaxSize(250, 30);
        noteEditor.setMinSize(250, 30);

        // Когда теряет фокус → превращаем в Label
        noteEditor.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                String text = noteEditor.getText().trim();
                if (!text.isEmpty()) {
                    Label noteLabel = new Label(text);
                    noteLabel.setWrapText(true);
                    noteLabel.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 5; -fx-border-color: #ccc;");

                    // При клике открываем страницу заметки
                    noteLabel.setOnMouseClicked(event -> openNoteDetail(text));

                    // заменяем TextArea на Label
                    int index = notesContainer.getChildren().indexOf(noteEditor);
                    notesContainer.getChildren().set(index, noteLabel);
                }
            }
        });

        notesContainer.getChildren().add(noteEditor);
        noteEditor.requestFocus(); // сразу активируем редактирование
    }
    @FXML
    private void openNoteDetail(String text) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("note-detail.fxml"));
            Parent root = loader.load();

            NoteDetailController controller = loader.getController();
            controller.setNoteText(text);

            Stage stage = new Stage();
            stage.setTitle("Редактирование заметки");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



   @FXML
    protected void showTextOfButtonProfile() {
       hideButtonClick();
       profile.setVisible(true);
    }
    @FXML
    protected void showTextOfButtonSearch() {
        hideButtonClick();
        search.setVisible(true);
    }
//    @FXML
//    protected void showTextOfButtonNewTask() {
//        hideButtonClick();
//        newTask.setVisible(true);
//    }

    // делает кнопки невидимыми при нажатии
    @FXML
    protected void hideButtonClick() {
        newTask.setVisible(false);
        search.setVisible(false);
        profile.setVisible(false);
        welcomeGM.setVisible(false);
    }
}
