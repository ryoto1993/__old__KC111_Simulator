import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class LayoutController {
    private static LayoutPane pane;
    private static KC111Canvas canvas;
    public static ArrayList<Light> lights = new ArrayList<>();

    public static void setLight() throws IOException {
        try {
            File csv = new File("data/light.csv"); // CSVデータファイル
            BufferedReader br = new BufferedReader(new FileReader(csv));

            // 最終行まで読み込む
            String line = "";
            while ((line = br.readLine()) != null) {

                // 1行をデータの要素に分割
                StringTokenizer st = new StringTokenizer(line, ",");

                while (st.hasMoreTokens()) {
                    // 1行の各要素をタブ区切りで表示
                    lights.add(new Light(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void setLayoutPane(LayoutPane p) {
        pane = p;
    }

    public static void setCanvas(KC111Canvas c) {
        canvas = c;
    }

    public static void setLightLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_layout, 10);
        } else {
            pane.remove(pane.light_layout);
        }
        pane.repaint();
    }

    public static void setLightPatternVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_pattern, 100);
        } else {
            pane.remove(pane.light_pattern);
        }
        pane.repaint();
    }

    public static void setSensorLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.sensor_layout, 20);
        } else {
            pane.remove(pane.sensor_layout);
        }
        pane.repaint();
    }
}
