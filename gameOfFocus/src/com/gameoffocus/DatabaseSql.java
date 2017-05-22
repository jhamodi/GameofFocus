package com.fallingstone2;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseSql {
	public static final String KEY_ROWID = "_id";
	public static final String KEY_SCORE = "persons_score";
	
	private static final String DATABASE_NAME = "Gamedb";
	private  static final String DATABASE_TABLE = "scoreTable";
	private static final int DATABASE_VERSION = 1;
	
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub	
			db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + 
					KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				
					KEY_SCORE + " INTEGER);"
					);
			
		
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
						db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
						onCreate(db);
		}						

	}
	public DatabaseSql (Context c){
		ourContext = c;
	}
	
	public DatabaseSql open ()throws SQLException{
		ourHelper= new DbHelper(ourContext);
		ourDatabase =ourHelper.getWritableDatabase();
		return this;
	}
	
	public void close (){
		ourHelper.close();
	}
	
	public String getData() {
		// TODO Auto-generated method stub
		String  [] columns = new String []{ KEY_ROWID, KEY_SCORE};
		Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
		//Cursor c = ourDatabase.rawQuery(DATABASE_TABLE, columns);
		String result="";
		String first= "";
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iScore = c.getColumnIndex(KEY_SCORE);
		
		
		
	    if (c != null ) {
	    	
            if  (c.moveToFirst() ) {
                  do {
                	  result = c.getString(iScore) + "\n";
                  }while (c.moveToNext()) ;
            }
		
	    }
//		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
////			result = result + c.getString(iRow)+ " " + c.getString(iScore) + "\n";
//		result = c.getString(iScore) + "\n";		
//			
//		}		
	    
	    
		return result;
		
		}

	public long createEntry(int score) {
		// TODO Auto-generated method stub
		
		ContentValues cv = new ContentValues();
		cv.put(KEY_SCORE, score);
		
		
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
//	public void deleteAll(SQLiteDatabase db)
//	{
//	 
//		db.delete(DATABASE_TABLE, null, null);
//	    db.close();
//	}
	
	}
