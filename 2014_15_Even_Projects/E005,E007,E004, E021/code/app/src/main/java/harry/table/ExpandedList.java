package harry.table;

import android.app.ListActivity;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.provider.Contacts;
import android.widget.SimpleCursorAdapter;
import android.widget.ListAdapter;
import harry.table.MyDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import harry.table.*;

/**
 * Created by Harpratap on 17-03-2015.
 */
public class ExpandedList extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.list_example);


        Cursor cursor = getContentResolver().query(Contacts.People.CONTENT_URI, new String[] {Contacts.People._ID, Contacts.People.NAME, Contacts.People.NAME}, null, null, null);
        startManagingCursor(cursor);

        // the desired columns to be bound

        String[] columns = new String[] { Contacts.People.NAME, Contacts.People.NAME };
        // the XML defined views which the data will be bound to
        int[] to = new int[] { R.id.subjectname_entry, R.id.facultyname_entry };

        // create the adapter using the cursor pointing to the desired data as well as the layout information
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.list_example_entry, cursor, columns, to);

        // set this adapter as your ListActivity's adapter

        this.setListAdapter(mAdapter);
    }

}
