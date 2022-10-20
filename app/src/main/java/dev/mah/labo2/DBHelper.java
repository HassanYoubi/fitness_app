package dev.mah.labo2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "bdmusculation";
    private static final int DB_VERSION = 1;
    private static final String TABLE_CATEGORIE = "categorie";
    private static final String IDCATEG_COL = "id";
    private static final String TITRECATEG_COL = "titre";
    private static final String THUMBNAIL_COL = "thumbnail";
    private static final String TABLE_EXERCICE = "exercice";
    private static final String IDEXERC_COL = "id";
    private static final String TITREXERC_COL = "titre";
    private static final String IMAGEXERC_COL = "img";
    private static final String TIMEXERC_COL = "time";
    private static final String REPEATEXERC_COL = "repeat";
    private static final String CATEXERC_COL = "categorie";
    private static final String DESCEXERC_COL = "description";
    private static final String VIDEXERC_COL = "video";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_CATEGORIE + " ("
                + IDCATEG_COL + " INTEGER PRIMARY KEY, "
                + TITRECATEG_COL + " TEXT,"
                + THUMBNAIL_COL + " TEXT)";
        db.execSQL(query);
        insertCategories(db);
        query = "CREATE TABLE " + TABLE_EXERCICE + " ("
                + IDEXERC_COL + " INTEGER PRIMARY KEY, "
                + TITREXERC_COL + " TEXT,"
                + IMAGEXERC_COL + " TEXT,"
                + TIMEXERC_COL + " TEXT,"
                + REPEATEXERC_COL + " TEXT,"
                + CATEXERC_COL + " TEXT,"
                + DESCEXERC_COL + " TEXT,"
                + VIDEXERC_COL + " TEXT)";
        db.execSQL(query);
        insertExercices(db);
    }

    public void insertCategories(SQLiteDatabase db) {
        //Categorie1
        ContentValues values1 = new ContentValues();
        values1.put(IDCATEG_COL, "1");
        values1.put(TITRECATEG_COL, "abdominaux");
        values1.put(THUMBNAIL_COL, "abdominaux");
        db.insert(TABLE_CATEGORIE, null, values1);
        //Categorie2
        ContentValues values2 = new ContentValues();
        values2.put(IDCATEG_COL, "2");
        values2.put(TITRECATEG_COL, "avant_bras");
        values2.put(THUMBNAIL_COL, "avant_bras");
        db.insert(TABLE_CATEGORIE, null, values2);
        //Categorie3
        ContentValues values3 = new ContentValues();
        values3.put(IDCATEG_COL, "3");
        values3.put(TITRECATEG_COL, "biceps");
        values3.put(THUMBNAIL_COL, "biceps");
        db.insert(TABLE_CATEGORIE, null, values3);
        //Categorie4
        ContentValues values4 = new ContentValues();
        values4.put(IDCATEG_COL, "4");
        values4.put(TITRECATEG_COL, "cuisses");
        values4.put(THUMBNAIL_COL, "cuisses");
        db.insert(TABLE_CATEGORIE, null, values4);
        //Categorie5
        ContentValues values5 = new ContentValues();
        values5.put(IDCATEG_COL, "5");
        values5.put(TITRECATEG_COL, "dos");
        values5.put(THUMBNAIL_COL, "dos");
        db.insert(TABLE_CATEGORIE, null, values5);
        //Categorie6
        ContentValues values6 = new ContentValues();
        values6.put(IDCATEG_COL, "6");
        values6.put(TITRECATEG_COL, "epaules");
        values6.put(THUMBNAIL_COL, "epaules");
        db.insert(TABLE_CATEGORIE, null, values6);
        //Categorie7
        ContentValues values7 = new ContentValues();
        values7.put(IDCATEG_COL, "7");
        values7.put(TITRECATEG_COL, "mollets");
        values7.put(THUMBNAIL_COL, "mollets");
        db.insert(TABLE_CATEGORIE, null, values7);
        //Categorie8
        ContentValues values8 = new ContentValues();
        values8.put(IDCATEG_COL, "8");
        values8.put(TITRECATEG_COL, "parties");
        values8.put(THUMBNAIL_COL, "parties");
        db.insert(TABLE_CATEGORIE, null, values8);
        //Categorie9
        ContentValues values9 = new ContentValues();
        values9.put(IDCATEG_COL, "9");
        values9.put(TITRECATEG_COL, "triceps");
        values9.put(THUMBNAIL_COL, "triceps");
        db.insert(TABLE_CATEGORIE, null, values9);
    }

    public void insertExercices(SQLiteDatabase db) {
        //Exercice1
        ContentValues values1 = new ContentValues();
        values1.put(TITREXERC_COL, "crunch_au_sol");
        values1.put(IMAGEXERC_COL, "crunch_au_sol");
        values1.put(TIMEXERC_COL, "10");
        values1.put(REPEATEXERC_COL, "5");
        values1.put(CATEXERC_COL, "1");
        values1.put(DESCEXERC_COL, "Le crunch est un exercice simple et efficace pour muscler les abdominaux. Il affine et raffermit la taille si vous travaillez avec le poids du corps, et développe les abdominaux si vous utilisez un lest de plus en plus lourd. Il ne nécessite pas de matériel et peut être réalisé n’importe où.");
        values1.put(VIDEXERC_COL, "zUk1BiL6Ajc");
        db.insert(TABLE_EXERCICE, null, values1);
        //Exercice2
        ContentValues values2 = new ContentValues();
        values2.put(TITREXERC_COL, "crunch_poulie");
        values2.put(IMAGEXERC_COL, "crunch_poulie");
        values2.put(TIMEXERC_COL, "12");
        values2.put(REPEATEXERC_COL, "8");
        values2.put(CATEXERC_COL, "1");
        values2.put(DESCEXERC_COL, "Le crunch à la corde effectué sur la poulie haute est un exercice très efficace pour travailler la sangle abdominale. Il consiste à enrouler le buste vers l\\'avant en tirant sur la poulie, ce qui reproduit le mouvement du crunch classique, mais à la verticale.");
        values2.put(VIDEXERC_COL, "UZBfM_p3138");
        db.insert(TABLE_EXERCICE, null, values2);
        //Exercice3
        ContentValues values3 = new ContentValues();
        values3.put(TITREXERC_COL, "flexions_machine");
        values3.put(IMAGEXERC_COL, "flexions_machine");
        values3.put(TIMEXERC_COL, "11");
        values3.put(REPEATEXERC_COL, "15");
        values3.put(CATEXERC_COL, "1");
        values3.put(DESCEXERC_COL, "Les muscles ciblés par les flexions du buste à la machine sont principalement le grand droit, sollicité dans son amplitude complète, mais aussi l'ensemble des abdominaux supérieurs et inférieurs. De façon plus secondaire, cet exercice sollicite également les muscles dentelés et les obliques.");
        values3.put(VIDEXERC_COL, "UYfuax8KwcE");
        db.insert(TABLE_EXERCICE, null, values3);
        //Exercice4
        ContentValues values4 = new ContentValues();
        values4.put(TITREXERC_COL, "releve_genoux");
        values4.put(IMAGEXERC_COL, "releve_genoux");
        values4.put(TIMEXERC_COL, "10");
        values4.put(REPEATEXERC_COL, "9");
        values4.put(CATEXERC_COL, "1");
        values4.put(DESCEXERC_COL, "Il sollicite le grand droit des abdominaux en statique, le droit antérieur et le psoas iliaque. Le grand droit fait partie de la sangle abdominale avec les obliques et le transverse. L’action du grand droit est la flexion du tronc");
        values4.put(VIDEXERC_COL, "tr2hQTnvz3Q");
        db.insert(TABLE_EXERCICE, null, values4);
        //Exercice1
        ContentValues values9 = new ContentValues();
        values9.put(TITREXERC_COL, "curl_zottman");
        values9.put(IMAGEXERC_COL, "curl_zottman");
        values9.put(TIMEXERC_COL, "10");
        values9.put(REPEATEXERC_COL, "5");
        values9.put(CATEXERC_COL, "2");
        values9.put(DESCEXERC_COL, "Il sollicite le grand droit des abdominaux en statique, le droit antérieur et le psoas iliaque. Le grand droit fait partie de la sangle abdominale avec les obliques et le transverse. L’action du grand droit est la flexion du tronc.");
        values9.put(VIDEXERC_COL, "bhkNU2R-78E");
        db.insert(TABLE_EXERCICE, null, values9);
        //Exercice2
        ContentValues values8 = new ContentValues();
        values8.put(TITREXERC_COL, "ext_barre");
        values8.put(IMAGEXERC_COL, "ext_barre");
        values8.put(TIMEXERC_COL, "12");
        values8.put(REPEATEXERC_COL, "8");
        values8.put(CATEXERC_COL, "2");
        values8.put(DESCEXERC_COL, "Il sollicite le grand droit des abdominaux en statique, le droit antérieur et le psoas iliaque. Le grand droit fait partie de la sangle abdominale avec les obliques et le transverse. L’action du grand droit est la flexion du tronc.");
        values8.put(VIDEXERC_COL, "BkXyX71quVI");
        db.insert(TABLE_EXERCICE, null, values8);
        //Exercice3
        ContentValues values7 = new ContentValues();
        values7.put(TITREXERC_COL, "ext_haltere");
        values7.put(IMAGEXERC_COL, "ext_haltere");
        values7.put(TIMEXERC_COL, "11");
        values7.put(REPEATEXERC_COL, "15");
        values7.put(CATEXERC_COL, "2");
        values7.put(DESCEXERC_COL, "Il sollicite le grand droit des abdominaux en statique, le droit antérieur et le psoas iliaque. Le grand droit fait partie de la sangle abdominale avec les obliques et le transverse. L’action du grand droit est la flexion du tronc.");
        values7.put(VIDEXERC_COL, "OFfJKCBQ2mA");
        db.insert(TABLE_EXERCICE, null, values7);
        //Exercice4
        ContentValues values6 = new ContentValues();
        values6.put(TITREXERC_COL, "flexion_barre");
        values6.put(IMAGEXERC_COL, "flexion_barre");
        values6.put(TIMEXERC_COL, "10");
        values6.put(REPEATEXERC_COL, "9");
        values6.put(CATEXERC_COL, "2");
        values6.put(DESCEXERC_COL, "Il sollicite le grand droit des abdominaux en statique, le droit antérieur et le psoas iliaque. Le grand droit fait partie de la sangle abdominale avec les obliques et le transverse. L’action du grand droit est la flexion du tronc.");
        values6.put(VIDEXERC_COL, "dK76O_TtHEo");
        db.insert(TABLE_EXERCICE, null, values6);
        //Exercice5
        ContentValues values5 = new ContentValues();
        values5.put(TITREXERC_COL, "flexion_haltere");
        values5.put(IMAGEXERC_COL, "flexion_haltere");
        values5.put(TIMEXERC_COL, "10");
        values5.put(REPEATEXERC_COL, "9");
        values5.put(CATEXERC_COL, "2");
        values5.put(DESCEXERC_COL, "Il sollicite le grand droit des abdominaux en statique, le droit antérieur et le psoas iliaque. Le grand droit fait partie de la sangle abdominale avec les obliques et le transverse. L’action du grand droit est la flexion du tronc.");
        values5.put(VIDEXERC_COL, "6eqgQl9tyFw");
        db.insert(TABLE_EXERCICE, null, values5);
    }

    public void addNewExercice(String title, String image, String time, String repeat, String categ, String description, String video) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITREXERC_COL, title);
        values.put(IMAGEXERC_COL, image);
        values.put(TIMEXERC_COL, time);
        values.put(REPEATEXERC_COL, repeat);
        values.put(CATEXERC_COL, categ);
        values.put(DESCEXERC_COL, description);
        values.put(VIDEXERC_COL, video);
        db.insert(TABLE_EXERCICE, null, values);
        db.close();
    }

    public ArrayList<Categorie> listCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCategories = db.rawQuery("SELECT * FROM " + TABLE_CATEGORIE, null);
        ArrayList<Categorie> categorieArrayList = new ArrayList<>();
        if (cursorCategories.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                categorieArrayList.add(new Categorie(cursorCategories.getString(0),
                        cursorCategories.getString(1),
                        cursorCategories.getString(2)));
            } while (cursorCategories.moveToNext());
        }
        cursorCategories.close();
        return categorieArrayList;
    }

    public ArrayList<Exercice> listExercices() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorExercices = db.rawQuery("SELECT * FROM " + TABLE_EXERCICE, null);
        ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
        if (cursorExercices.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                exerciceArrayList.add(new Exercice(cursorExercices.getString(0),
                        cursorExercices.getString(1),
                        cursorExercices.getString(2),
                        cursorExercices.getString(3),
                        cursorExercices.getString(4),
                        cursorExercices.getString(5),
                        cursorExercices.getString(6),
                        cursorExercices.getString(7)));
            } while (cursorExercices.moveToNext());
        }
        cursorExercices.close();
        return exerciceArrayList;
    }

    public ArrayList<Exercice> listExercicesParCategorie(String categorie) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorExercices = db.rawQuery("SELECT * FROM " + TABLE_EXERCICE + " WHERE " + CATEXERC_COL + " = " + categorie, null);
        ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
        if (cursorExercices.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                exerciceArrayList.add(new Exercice(cursorExercices.getString(0),
                        cursorExercices.getString(1),
                        cursorExercices.getString(2),
                        cursorExercices.getString(3),
                        cursorExercices.getString(4),
                        cursorExercices.getString(5),
                        cursorExercices.getString(6),
                        cursorExercices.getString(7)));
            } while (cursorExercices.moveToNext());
        }
        cursorExercices.close();
        return exerciceArrayList;
    }

    public Exercice rechercherUnExercices(String exercice) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorExercices = null;
        Exercice exerciceRech = null;

        cursorExercices = db.rawQuery("SELECT * FROM " + TABLE_EXERCICE + " WHERE " + IDEXERC_COL + " = " + exercice, null);

        if(cursorExercices.moveToFirst()) {
            String id = cursorExercices.getString(0);
            String title = cursorExercices.getString(1);
            String img = cursorExercices.getString(2);
            String time = cursorExercices.getString(3);
            String repeat = cursorExercices.getString(4);
            String categorie = cursorExercices.getString(5);
            String description = cursorExercices.getString(6);
            String video = cursorExercices.getString(7);

            exerciceRech = new Exercice(id, title, img, time, repeat, categorie, description, video);
        }
        return exerciceRech;
    }

    public void updateExercice(String idExercice, String title, String image, String time, String repeat, String categ, String description, String video) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITREXERC_COL, title);
        values.put(IMAGEXERC_COL, image);
        values.put(TIMEXERC_COL, time);
        values.put(REPEATEXERC_COL, repeat);
        values.put(CATEXERC_COL, categ);
        values.put(DESCEXERC_COL, description);
        values.put(VIDEXERC_COL, video);
        db.update(TABLE_EXERCICE, values, "id=?", new String[]{idExercice});
        db.close();
    }

    public void deleteExercice(String idExercice) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EXERCICE, "id=?", new String[]{idExercice});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCICE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIE);
        onCreate(db);
    }
}