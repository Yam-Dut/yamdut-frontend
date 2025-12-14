package org.yamdut.ui.map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;

public class MapView extends Application {

    @Override
    public void start(Stage stage) {

        WebView web = new WebView();
        WebEngine engine = web.getEngine();

        URL url = getClass().getResource("/web/map.html");
        if (url != null) {
            engine.load(url.toExternalForm());
        } else {
            // Fallback content in case the resource is missing
            engine.loadContent("""
                <!DOCTYPE html>
                <html><head><meta charset='utf-8'><title>Yamdut Map</title>
                <style>html,body{height:100%;margin:0}#app{height:100%;display:grid;place-items:center;font-family:system-ui,Arial,sans-serif;color:#374151}</style>
                </head><body>
                <div id='app'>
                  <div>Missing resource: <code>/web/map.html</code></div>
                  <div style='color:#2563eb;margin-top:8px'>Loading fallback content.</div>
                </div>
                </body></html>
            """);
        }

        Scene scene = new Scene(web, 1200, 800);

        stage.setTitle("Yamdut Ride Tracking");
        stage.setScene(scene);
        stage.show();
    }
}
