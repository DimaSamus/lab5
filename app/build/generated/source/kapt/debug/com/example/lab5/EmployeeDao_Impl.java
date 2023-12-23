package com.example.lab5;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EmployeeDao_Impl implements EmployeeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Employee> __insertionAdapterOfEmployee;

  private final EntityDeletionOrUpdateAdapter<Employee> __deletionAdapterOfEmployee;

  public EmployeeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmployee = new EntityInsertionAdapter<Employee>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `employee` (`id`,`name`,`salary`,`position`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final Employee entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindLong(3, entity.getSalary());
        if (entity.getPosition() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPosition());
        }
      }
    };
    this.__deletionAdapterOfEmployee = new EntityDeletionOrUpdateAdapter<Employee>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `employee` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final Employee entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insertEmployee(final Employee employee,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEmployee.insert(employee);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteEmployee(final Employee employee,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEmployee.handle(employee);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Employee>> getAllEmployee() {
    final String _sql = "SELECT * FROM employee";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"employee"}, new Callable<List<Employee>>() {
      @Override
      @NonNull
      public List<Employee> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final List<Employee> _result = new ArrayList<Employee>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Employee _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final int _tmpSalary;
            _tmpSalary = _cursor.getInt(_cursorIndexOfSalary);
            final String _tmpPosition;
            if (_cursor.isNull(_cursorIndexOfPosition)) {
              _tmpPosition = null;
            } else {
              _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
            }
            _item = new Employee(_tmpId,_tmpName,_tmpSalary,_tmpPosition);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
