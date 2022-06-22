//Custom Colours
import java.awt.Color;

public class Colour {

    //colours used for each piece
    //pieces with more or less chunks/squares imitate its closest shape based off of the original tetris game
    private static final Color iPiece = new Color(81, 204, 200);
    private static final Color jPiece = new Color(3, 65, 174);
    private static final Color lPiece = new Color(255, 151, 28);
    private static final Color oPiece = new Color(255, 213, 0);
    private static final Color sPiece = new Color(114, 203, 59);
    private static final Color zPiece = new Color(255, 50, 19);
    private static final Color tPiece = new Color(113, 92, 204);

    //customized culours
    public static final Color beige = new Color(237, 224, 178);
    public static final Color grey = new Color(212, 202, 198);
    public static final Color black = new Color(58, 57, 53);
    public static final Color white = new Color(222, 222, 222);

    public static Color defaultColour = beige;
    public static Color defaultLineColour = grey;

    //colour set that will be passed on which include the corresponding colour for each piece used in the current set
    public static Color[] PieceColors;

    public static final Color[] CompleteColourSet = {

        iPiece,
        jPiece,
        lPiece,
        lPiece,
        jPiece,
        zPiece,
        sPiece,
        oPiece,
        oPiece,
        tPiece,
        tPiece,
        iPiece,
        tPiece,
        tPiece,
        lPiece,
        jPiece,
        sPiece,
        zPiece,
        iPiece,
        jPiece,
        lPiece,
        oPiece,
        sPiece,
        tPiece,
        zPiece,
        iPiece,
        lPiece,
        iPiece,
        oPiece
    };

    public static Color getDefaultColour() {

        return defaultColour;

    }

    public static void setDefaultColour(int r, int g, int b) {

        defaultColour = new Color(r, g, b);
        return;

    }

    //fun piece of code which determines whether a given colour is considered "dark", "neutral", or "bright"
    public static void setLineColour(Color defaultColour) {

        int r = defaultColour.getRed();
        int g = defaultColour.getGreen();
        int b = defaultColour.getBlue();

        double hspValue = Math.sqrt(0.299 * (r * r) + 0.587 * (g * g) + 0.114 * (b * b));

        if (hspValue < 85) {
            defaultLineColour = white;
        } else if (hspValue < 170) {
            defaultLineColour = grey;
        } else {
            defaultLineColour = black;
        }
        return;
    }

    //takes the correct colours from the full colour pool and adds it to the pool for the pieces that WILL be used
    public static void setPieceColourSet(int pieceSetInclusion) {

        switch (pieceSetInclusion) {
            case 1:
                PieceColors = new Color[1];
                for (int i = 0; i < 1; i++) {
                    PieceColors[i] = CompleteColourSet[CompleteColourSet.length - (1 + i)];
                }

                break;
            case 2:
                PieceColors = new Color[1];
                for (int i = 0; i < 1; i++) {
                    PieceColors[i] = CompleteColourSet[CompleteColourSet.length - (2 + i)];
                }
                break;
            case 3:
                PieceColors = new Color[2];
                for (int i = 0; i < 2; i++) {
                    PieceColors[i] = CompleteColourSet[CompleteColourSet.length - (3 + i)];
                }
                break;
            case 4:
                PieceColors = new Color[7];
                for (int i = 0; i < 7; i++) {
                    PieceColors[i] = CompleteColourSet[CompleteColourSet.length - (5 + i)];
                }
                break;
            case 5:
                PieceColors = new Color[18];
                for (int i = 0; i < 18; i++) {
                    PieceColors[i] = CompleteColourSet[CompleteColourSet.length - (12 + i)];
                }
                break;

            case 0:
                PieceColors = CompleteColourSet;
                break;
        }
    }
}