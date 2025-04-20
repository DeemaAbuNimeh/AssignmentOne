package com.example.assignmentone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataBase {
    private static final ArrayList<Makeup> makeupList = new ArrayList<>();
            public DataBase() {
                makeupList.add(new Makeup("Benefit", "Face", "Cookie Highlighter", 30.00, R.drawable.benefithighlighter));
                makeupList.add(new Makeup("Dior", "Face", "Backstage Glow Face Palette", 45.00, R.drawable.diorpallete));
                makeupList.add(new Makeup("Haus Labs", "Face", "Triclone Skin Tech Concealer", 32.00, R.drawable.hauslabesconcealer));
                makeupList.add(new Makeup("Hourglass", "Face", "Vanish Airbrush Concealer", 36.00, R.drawable.hourglassconcelear));
                makeupList.add(new Makeup("Huda Beauty", "Face", "FauxFilter Color Corrector", 30.00, R.drawable.hudacolorcorrect));
                makeupList.add(new Makeup("Rare Beauty", "Face", "Positive Light Silky Touch Highlighter", 25.00, R.drawable.positivelightsilkytouchhighlighter));
                makeupList.add(new Makeup("Stila", "Face", "Correct and Perfect All-In-One Color Correcting Palette", 45.00, R.drawable.colorcorrect));
                makeupList.add(new Makeup("Maybelline", "Face", "Instant Age Rewind Eraser Multi-Use Concealer", 11.00, R.drawable.conclear));
                makeupList.add(new Makeup("Makeup by Mario", "Bronzer", "Soft Sculpt Bronzer", 30.00, R.drawable.bronz));
                makeupList.add(new Makeup("Giorgio Armani", "Bronzer", "Luminous Silk Glow Bronzing Powder", 58.00, R.drawable.bronzer));
                makeupList.add(new Makeup("Charlotte Tilbury", "Bronzer", "Hollywood Contour Wand", 42.00, R.drawable.charlottebronzer));
                makeupList.add(new Makeup("Benefit", "Bronzer", "Hoola Matte Bronzer", 35.00, R.drawable.bronzeandblushpal));
                makeupList.add(new Makeup("Patrick Ta", "Blush", "Major Headlines Double-Take Crème & Powder Blush", 36.00, R.drawable.blush));
                makeupList.add(new Makeup("Tarte", "Blush", "Willa & Starla Amazonian Clay Cheek Duo", 32.00, R.drawable.bronzer));
                makeupList.add(new Makeup("Benefit", "Eyes", "BADgal BANG! Volumizing Mascara", 28.00, R.drawable.badgalmascara));
                makeupList.add(new Makeup("Benefit", "Eyes", "24-HR Brow Setter", 26.00, R.drawable.eyebrowmascara));
                makeupList.add(new Makeup("Charlotte Tilbury", "Eyes", "Brow Cheat Eyebrow Pencil", 25.00, R.drawable.eyebrowpencil));
                makeupList.add(new Makeup("Sephora", "Eyes", "Vegan False Eyelashes", 10.00, R.drawable.eyelashes));
                makeupList.add(new Makeup("ILIA", "Eyes", "Limitless Lash Mascara", 28.00, R.drawable.ilia));
                makeupList.add(new Makeup("Tower28", "Lips", "Matte Revolution Lipstick & Lip Cheat", 34.00, R.drawable.tower28lipbalm));
            }
    public List<Makeup> getMakeup() {
        List<Makeup> result = new ArrayList<>();

        for(Makeup b: makeupList){

                result.add(b);
        }
        return result;

    }



        }
