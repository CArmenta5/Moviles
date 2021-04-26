package mx.itesm.activity_14;

import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_NAME = "USER_NAME";
    public static final String COLUMN_HOBBY = "USER_HOBBY";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {

        super(context, "user.db", null,1);
    }
    //Class who handles all the operation


    //this is called the fisrt time database is accessed. There should use code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
        //The onCreate method is automatically called when the app requests or inputs new data. We need to create anew table inside this method
        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_HOBBY + " TEXT)";

        db.execSQL(createTableStatement);
    }

    //this is called if there database version umber changes. it prevents previous user apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(UserModel userModel){
        SQLiteDatabase db= this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, userModel.getName());
        cv.put(COLUMN_HOBBY, userModel.getHobby());

        long  insert = db.insert(USER_TABLE,null , cv);

        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }
    public boolean deleteOne (String name, String hobby){
        // find customerModel in the database. If it found, delete it and return ture;
        //if it is not found, return false
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString ="DELETE FROM "+ USER_TABLE +" WHERE "+COLUMN_NAME+" = ? " ;
        Cursor cursor = db.rawQuery(queryString, new String[]{name});
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }
    public long searchOne (String name){
        // find customerModel in the database. If it found, delete it and return ture;
        //if it is not found, return false
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString ="SELECT "+COLUMN_ID+ " FROM "+ USER_TABLE +" WHERE "+COLUMN_NAME+" = ?" ;
        Cursor cursor = db.rawQuery(queryString, new String[]{name});
        if(cursor.moveToFirst()){
            return         cursor.getLong(cursor.getColumnIndex(COLUMN_ID));

        }else{
            return 0;
        }
    }

    public List<UserModel> getAll(){
        List<UserModel> returnList=new ArrayList<>();

        //getdata from the database
        String queryString = "SELECT * FROM "+ USER_TABLE;
        //WritableDatbase will lock the data, readibly select

        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            //loop thorugh the cursor (result set) and create new customer object. Put them into the result list
            do{
                int userID=cursor.getInt(0);
                String userName = cursor.getString(1);
                String userHobby = cursor.getString(2);
                UserModel newUserModel = new UserModel(userID, userName, userHobby);
                returnList.add(newUserModel);
            }while(cursor.moveToNext());

        }else {
            //failure.do not add anything to the list.
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;
    }





}
