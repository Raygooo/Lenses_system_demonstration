package MainProgram.view;

import Framework.LSD.views.DemoView;
import Framework.LSD.world.Lens.LensMaterial;
import Framework.LSD.world.Lens.LensType;
import Framework.LSD.world.Light.LightInfo;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class ZoomingEffect is created on 19/08/2019 19:20.
 * Predefined 3 lens (1 concave lens and 2 convex lens)
 * 4 paralleled symmetrical lights to deliver zooming effect
 *
 * @author Ray
 * @version 19/08/2019
 **/

public class ZoomingEffect extends DemoView {
    @Override
    public void launch() {

        setTopMenuColor("A5BEFF");
        setDemoTitle("Zooming Effect");

        addAnimatedLens("ConvexLens1", new ArrayList<>(Arrays.asList(
                LensType.ConvexLens, 200D, 500D, 500D, 200D, LensMaterial.findViaLensID(1)
        )), true);

        addAnimatedLens("ConvexLens2", new ArrayList<>(Arrays.asList(
                LensType.ConvexLens, 500D, 750D, 750D, 200D, LensMaterial.findViaLensID(1)
        )), true);

        addAnimatedLens("ConcaveLens", new ArrayList<>(Arrays.asList(
                LensType.ConcaveLens, 350D, 250D, 250D, 200D, LensMaterial.findViaLensID(55), 25D
        )), true);

        addAnimatedLight("Symmetrical Light1", new ArrayList<>(Arrays.asList(
                75D, 0D, LightInfo.RED, true
        )), false);

        addAnimatedLight("Symmetrical Light2", new ArrayList<>(Arrays.asList(
                65D, 0D, LightInfo.RED, true
        )), false);

        addAnimatedLight("Symmetrical Light3", new ArrayList<>(Arrays.asList(
                55D, 0D, LightInfo.RED, true
        )), false);

        addAnimatedLight("Symmetrical Light4", new ArrayList<>(Arrays.asList(
                45D, 0D, LightInfo.RED, true
        )), false);

        VBox box = new VBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10,10,10,10));

        Label info = new Label();
        info.setWrapText(true);
        info.setMaxWidth(200);
        info.setText("Try To change the Concave Lens's position to see the zooming effect");
        info.setStyle("-fx-font-size: 20");
        box.getChildren().add(info);

        getInfoPane().getChildren().add(box);




    }


}
