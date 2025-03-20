package com.dsergei.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dsergei.core.database.dao.RunDao
import com.dsergei.core.database.dao.RunPendingSyncDao
import com.dsergei.core.database.entity.DeletedRunSyncEntity
import com.dsergei.core.database.entity.RunEntity
import com.dsergei.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class,
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {
    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}