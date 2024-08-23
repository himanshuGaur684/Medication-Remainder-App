package gaur.himanshu.medicationremainderapp.domain.use_cases

import gaur.himanshu.medicationremainderapp.domain.repository.ReminderRepository
import javax.inject.Inject

class GetAllReminderUseCase @Inject constructor(private val reminderRepository: ReminderRepository) {

    operator fun invoke() = reminderRepository.getAllReminders()

}