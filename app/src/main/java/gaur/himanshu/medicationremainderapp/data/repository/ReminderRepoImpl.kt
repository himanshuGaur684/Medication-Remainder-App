package gaur.himanshu.medicationremainderapp.data.repository

import gaur.himanshu.medicationremainderapp.data.local.ReminderDao
import gaur.himanshu.medicationremainderapp.domain.model.Reminder
import gaur.himanshu.medicationremainderapp.domain.repository.ReminderRepository
import kotlinx.coroutines.flow.Flow

class ReminderRepoImpl(private val reminderDao: ReminderDao) : ReminderRepository {
    override suspend fun insert(reminder: Reminder) {
       reminderDao.insert(reminder)
    }

    override suspend fun update(reminder: Reminder) {
        reminderDao.update(reminder)
    }

    override suspend fun delete(reminder: Reminder) {
        reminderDao.update(reminder)

    }

    override fun getAllReminders(): Flow<List<Reminder>> = reminderDao.getAllReminder()
}