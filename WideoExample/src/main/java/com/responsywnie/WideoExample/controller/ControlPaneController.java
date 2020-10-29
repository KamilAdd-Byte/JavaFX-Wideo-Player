package com.responsywnie.WideoExample.controller;

import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

public class ControlPaneController {

	public String filePath;
	public MediaPlayer mediaPlayer;

	@FXML
	private MediaView mediaView;

	@FXML
	private Slider regularMovie;//seekSlider

	@FXML
	private HBox buttonAction;

	@FXML
	private Button playButton;

	@FXML
	private Button stopButton;

	@FXML
	private Button pauseButton;

	@FXML
	private Button openLibraryButton;

	@FXML
	private Button forrward;

	@FXML
	private Button prevard;

	@FXML
	private Slider volume;

	@FXML
	private Label volumeLabel;

	@FXML
	void handleButtonAction(ActionEvent event) {

		if (event.getSource() == openLibraryButton){
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Zaznacz plik (*.mp4)",
					"*.mp4");
			fileChooser.getExtensionFilters().add(filter);
			File file = fileChooser.showOpenDialog();
			setFilePath(file.toURI().toString());
			if (filePath != null) {
				Media media = new Media(filePath);
				mediaPlayer = new MediaPlayer(media);
				mediaView.setMediaPlayer(mediaPlayer);
                mediaPlayer.currentTimeProperty().addListener((observableValue, duration, t1) -> {
				});
//				DoubleProperty widht = mediaView.fitWidthProperty();
//				DoubleProperty hight = mediaView.fitHeightProperty();
//
//				widht.bind(Bindings.selectDouble(mediaView.sceneProperty(), "wight"));
//				hight.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

				mediaPlayer.play();
			}
			}
		}

	public void initialize(){

	}

	public Slider getRegularMovie() {
		return regularMovie;
	}

	public HBox getButtonAction() {
		return buttonAction;
	}

	public Button getPlayButton() {
		return playButton;
	}

	public Button getStopButton() {
		return stopButton;
	}

	public Button getPauseButton() {
		return pauseButton;
	}

	public Button getOpenLibraryButton() {
		return openLibraryButton;
	}

	public Button getForrward() {
		return forrward;
	}

	public Button getPrevard() {
		return prevard;
	}


	public Slider getVolume() {
		return volume;
	}

	public Label getVolumeLabel() {
		return volumeLabel;
	}

	@FXML
	void pauseMovie(ActionEvent event) {
		mediaPlayer.pause();
	}

	@FXML
	void playMovie(ActionEvent event) {
		mediaPlayer.play();
		mediaPlayer.setRate(1);
	}

	@FXML
	void previousMovie(ActionEvent event) {
       mediaPlayer.seek(mediaPlayer.getCurrentTime().divide(Duration.seconds(15)));
	}

	@FXML
	void regularTimeMovie(MouseEvent event) {
		regularMovie.setValue(mediaPlayer.getVolume() * 100);//wczytanie do slidera, aktualny czas
		regularMovie.valueProperty().addListener((observableValue, number, t1)
				-> mediaPlayer.setVolume(regularMovie.getValue()/100));
       mediaPlayer.currentTimeProperty().addListener((observableValue, duration, newValue) ->
			   regularMovie.setValue(newValue.toSeconds()));//przesuwa sie wskaźnik

		//akcja myszka dotyczy mediaPlayer
		regularMovie.setOnMouseDragged(mouseEvent -> {
		  mediaPlayer.seek(Duration.seconds(regularMovie.getValue()));//
		});
		mediaPlayer.play();
	}

	@FXML
	void stopMovie(ActionEvent event) {
		mediaPlayer.stop();
	}

	@FXML
	void volumeMovie(MouseEvent event) {
		volume.clipProperty();
		this.volume.getValue();
        this.volume.startFullDrag();
		this.volume.setValue(1.9 * 100);
		this.volume.valueProperty().addListener((Observable observable) -> {
			mediaPlayer.setVolume(this.volume.getValue()/100);
		});

	}

	@FXML
	void forrwardMovie(ActionEvent event) {
		mediaPlayer.seek(mediaPlayer.getCurrentTime().divide(Duration.seconds(15)));
	}


	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

	public MediaView getMediaView() {
		return mediaView;
	}

	public void setMediaView(MediaView mediaView) {
		this.mediaView = mediaView;
	}

}



