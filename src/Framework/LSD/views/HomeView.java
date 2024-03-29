package Framework.LSD.views;

import Framework.LSD.app.View;
import Framework.LSD.views.Controller.HomeViewController;
import javafx.scene.layout.HBox;

import static Framework.Framework.app;

import java.io.IOException;

/**
 * Class HomeView is created on 19/08/2019 02:48.
 * Defined the temple of the home view, initial basic functionality for the home view to extends
 *
 * @author Ray
 * @version 19/08/2019
 **/

public abstract class HomeView extends View {

    private HBox homePane;

    private HomeViewController homeViewController;

    @Override
    public void onLaunch() {
        //load HomeView's fxml file
        getFxmlLoader().setLocation(getFxmlLoader()
                .getClassLoader()
                .getResource("Framework/LSD/views/FXML/HomeView.fxml"));
        try {
            homePane = getFxmlLoader().load();
            homeViewController = getFxmlLoader().getController();
            getPane().getChildren().add(homePane);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception in " + getClass().getName());
        }

        getPane().prefWidthProperty().bind(app.widthProperty());
        getPane().prefHeightProperty().bind(app.heightProperty());

        homePane.prefWidthProperty().bind(app.widthProperty());
        homePane.prefHeightProperty().bind(app.heightProperty());

        getController().getDescriptionImage().fitWidthProperty()
                .bind(getController().getHomeInfoPane().widthProperty().divide(2));
        getController().getDescription().prefWidthProperty()
                .bind(getController().getHomeInfoScrollPane().widthProperty().subtract(15));

        getController().getHomeExitBtn().setOnAction(e -> app.exit());

        launch();

    }

    public abstract void launch();


    public HomeViewController getController() {
        return homeViewController;
    }

    public void gotoView(String viewName) {
        app.gotoView(viewName);
    }


}
