module WideoExample {
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.media;
	requires java.base;


	exports com.responsywnie.WideoExample.main to javafx.graphics;
	exports com.responsywnie.WideoExample.controller to javafx.media;
	opens com.responsywnie.WideoExample.video to java.base;
	opens com.responsywnie.WideoExample.controller to javafx.fxml;
    opens com.responsywnie.WideoExample.main to javafx.media;
}
