package gaur.himanshu.medicationremainderapp.domain.use_cases

import gaur.himanshu.medicationremainderapp.domain.model.Reminder
import gaur.himanshu.medicationremainderapp.domain.repository.ReminderRepository
import javax.inject.Inject

class InsertUseCase @Inject constructor(private val reminderRepository: ReminderRepository) {

    suspend operator fun invoke(reminder: Reminder) = reminderRepository.insert(reminder)

}