    //     .-.  .-.
    //          |  \/  |
    //         /,   ,_  `'-.
    //       .-|\   /`\     '.
    //     .'  0/   | 0\  \_  `".
    //  .-'  _,/    '--'.'|#''---'
    //   `--'  |       /   \#
    //         |      /     \#
    //         \     ;|\    .\#
    //         |' ' //  \   ::\#
    //         \   /`    \   ':\#
    //          `"`       \..   \#
    //                     \::.  \#
    //                      \::   \#
    //                       \'  .:\#
    //                        \  :::\#
    //                         \  '::\#
    //                          \     \#
    //                           \
import java.awt.Point;

public class Pieces {
    

    private static int numPieces;

    private static Point[][][] pieceSet;
    

    private static final Point[][][] CompletePieceSet = {
        
        // Names are referenced in Pentris Piece Naming.png (' indicates reveresed (reflected about line x = 2))

        //Each Piece has 4 rotations, each with points that represents its shape
        //Drawn with 0,0 top right


        // I Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(4, 1) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(2, 4) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(4, 1) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(2, 4) },
        },
        
        //F Piece
        {
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1), new Point(3, 0) },
            { new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(2, 0), new Point(3, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(3, 1) },
            { new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 0), new Point(2, 2) },
        },
        
        //F' Piece
        {
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 0), new Point(3, 1) },
            { new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 2), new Point(2, 0) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1), new Point(3, 2) },
            { new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(3, 0), new Point(2, 2) },
        },

        // L Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(3, 0) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(3, 3) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(0, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(1, 0) },
        },

        // L' Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(3, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(1, 3) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(0, 0) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(3, 0) },
        },

        // N Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0), new Point(3, 0) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(3, 2), new Point(3, 3) },
            { new Point(3, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2), new Point(0, 2) },
            { new Point(1, 1), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(1, 0) },
        },

        // N' Piece
        {
            { new Point(3, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0), new Point(1, 0) },
            { new Point(3, 0), new Point(3, 1), new Point(2, 1), new Point(2, 2), new Point(2, 3) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2), new Point(3, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(1, 3) },
        },

        // P Piece
        {
            { new Point(3, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0), new Point(1, 0) },
            { new Point(3, 0), new Point(3, 1), new Point(2, 1), new Point(2, 2), new Point(2, 3) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2), new Point(3, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(1, 3) },
        },

        // P' Piece
        {
            { new Point(3, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0), new Point(3, 0) },
            { new Point(2, 3), new Point(2, 1), new Point(2, 2), new Point(3, 2), new Point(3, 3) },
            { new Point(3, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2), new Point(2, 2) },
            { new Point(1, 1), new Point(2, 1), new Point(2, 2), new Point(2, 0), new Point(1, 0) },
        },


        //  T Piece
        {
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 2), new Point(3, 2) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(3, 1) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 0), new Point(3, 0) },
            { new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(3, 2), new Point(3, 0) }
        },

         //  U Piece
         {
            { new Point(1, 0), new Point(3, 0), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
            { new Point(2, 0), new Point(3, 0), new Point(2, 1), new Point(2, 2), new Point(3, 2) },
            { new Point(1, 0), new Point(2, 0), new Point(3, 0), new Point(1, 1), new Point(3, 1) },
            { new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(1, 2), new Point(2, 2) }
        },
        
        //  V Piece
        {
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2), new Point(3, 2) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0), new Point(3, 0) },
            { new Point(1, 0), new Point(3, 1), new Point(3, 2), new Point(2, 0), new Point(3, 0) },
            { new Point(1, 2), new Point(3, 1), new Point(3, 2), new Point(2, 2), new Point(3, 0) }
        },
        
        //  W Piece
        {
            { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(2, 2), new Point(3, 2) },
            { new Point(2, 1), new Point(1, 1), new Point(1, 2), new Point(2, 0), new Point(3, 0) },
            { new Point(1, 0), new Point(3, 1), new Point(3, 2), new Point(2, 0), new Point(2, 1) },
            { new Point(1, 2), new Point(3, 1), new Point(2, 1), new Point(2, 2), new Point(3, 0) }
        },
        
        //  Jesus Piece
        {
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1), new Point(3, 1) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1), new Point(3, 1) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1), new Point(3, 1) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(1, 1), new Point(3, 1) }
        },
        
        // Y Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(2, 0) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(3, 2) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(1, 1) },
        },

        // Y' Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 0) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(3, 1) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(2, 2) },
            { new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(2, 3), new Point(1, 2) },
        },
        
        // S Piece
        {
            { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(3, 2) },
            { new Point(2, 0), new Point(3, 0), new Point(2, 1), new Point(1, 2), new Point(2, 2) },
            { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(3, 2) },
            { new Point(2, 0), new Point(3, 0), new Point(2, 1), new Point(1, 2), new Point(2, 2) },
        },

        // S' Piece
        {
            { new Point(3, 0), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 2) },
            { new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(3, 2), new Point(2, 2) },
            { new Point(3, 0), new Point(1, 1), new Point(2, 1), new Point(3, 1), new Point(1, 2) },
            { new Point(1, 0), new Point(2, 0), new Point(2, 1), new Point(3, 2), new Point(2, 2) },
        },

        // I Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
        },
        
        // J Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
        },
        
        // L Piece
        {
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
            { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
        },
        
        // O Piece
        {
            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
            { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
        },
        
        // S Piece
        {
            { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
            { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
            { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
            { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
        },
        
        // T Piece
        {
            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
            { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
            { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
        },
        
        // Z Piece
        {
            { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
            { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
            { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
        },

        // I Piece
        {
            { new Point(3, 1), new Point(1, 1), new Point(2, 1)},
            { new Point(2, 0), new Point(2, 1), new Point(2, 2)},
            { new Point(3, 1), new Point(1, 1), new Point(2, 1)},
            { new Point(2, 0), new Point(2, 1), new Point(2, 2)}
        },
        
        // L Piece
        {
            { new Point(3, 1), new Point(2, 0), new Point(2, 1)},
            { new Point(3, 1), new Point(2, 2), new Point(2, 1)},
            { new Point(1, 1), new Point(2, 2), new Point(2, 1)},
            { new Point(1, 1), new Point(2, 0), new Point(2, 1)}
        },

        {
            { new Point(2, 0), new Point(3, 0)},
            { new Point(2, 1), new Point(2, 2)},
            { new Point(2, 1), new Point(1, 1)},
            { new Point(2, 1), new Point(2, 0)}
        },

        {
            { new Point(2, 1)},
            { new Point(2, 1)},
            { new Point(2, 1)},
            { new Point(2, 1)}
        },
    };

    //only includes the shapes needed for the difficulty selected
    public static void setPieceSet(int pieceSetInclusion){

        switch (pieceSetInclusion) {
            case 1:
            pieceSet = new Point [1][4][pieceSetInclusion];
                for (int k = 0; k < 4; k++){                 
                    pieceSet[0][k][0] = CompletePieceSet[CompletePieceSet.length - 1][k][0];
                }
                numPieces = 1;
                break;
            case 2:
            pieceSet = new Point [1][4][pieceSetInclusion];
                for (int k = 0; k < 4; k++){  
                    for (int l = 0; l < pieceSetInclusion; l++){            
                    pieceSet[0][k][l] = CompletePieceSet[CompletePieceSet.length - 2][k][l];
                    }
                }
                numPieces = 1;
                break;
            case 3:
            pieceSet = new Point [2][4][pieceSetInclusion];
                for (int j = 0; j < 2; j++){
                    for (int k = 0; k < 4; k++){  
                        for (int l = 0; l < pieceSetInclusion; l++){            
                        pieceSet[j][k][l] = CompletePieceSet[CompletePieceSet.length - (3+j)][k][l];
                        }
                    }
                }
                numPieces = 2;
                break;
            case 4:
            pieceSet = new Point [7][4][pieceSetInclusion];
                for (int j = 0; j < 7; j++){
                    for (int k = 0; k < 4; k++){  
                        for (int l = 0; l < pieceSetInclusion; l++){            
                        pieceSet[j][k][l] = CompletePieceSet[CompletePieceSet.length - (5+j)][k][l];
                        }
                    }
                }
                numPieces = 7;
                break;
            case 5:
            pieceSet = new Point [18][4][pieceSetInclusion];
                for (int j = 0; j < 18; j++){
                    for (int k = 0; k < 4; k++){  
                        for (int l = 0; l < pieceSetInclusion; l++){            
                        pieceSet[j][k][l] = CompletePieceSet[CompletePieceSet.length - (12+j)][k][l];
                        }
                    }
                }
                numPieces = 18;
                break;
            case 0:
                pieceSet = CompletePieceSet;
                numPieces = 29;
                break;
            }
            //gets corresponding colours
            Colour.setPieceColourSet(pieceSetInclusion);
        
    }

    public static Point[][][] getPieceSet(){
        return pieceSet;
    }

    public static int getNumPieces(){
        return numPieces;
    }



}
