package gaur.himanshu.medicationremainderapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gaur.himanshu.medicationremainderapp.domain.model.Reminder
import gaur.himanshu.medicationremainderapp.domain.use_cases.DeleteUseCase
import gaur.himanshu.medicationremainderapp.domain.use_cases.GetAllReminderUseCase
import gaur.himanshu.medicationremainderapp.domain.use_cases.InsertUseCase
import gaur.himanshu.medicationremainderapp.domain.use_cases.UpdateUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val insertUseCase: InsertUseCase,
    private val deleteUseCase: DeleteUseCase,
    private val updateUseCase: UpdateUseCase,
    private val getAllReminderUseCase: GetAllReminderUseCase
) : ViewModel() {

    val uiState = getAllReminderUseCase.invoke().map { UiState(it) }
        .stateIn(viewModelScope, started = SharingStarted.Eagerly, UiState())

    fun insert(reminder: Reminder) = viewModelScope.launch {
        insertUseCase.invoke(reminder)
    }

    fun update(reminder: Reminder) = viewModelScope.launch {
        updateUseCase.invoke(reminder)
    }

    fun delete(reminder: Reminder) = viewModelScope.launch {
        deleteUseCase.invoke(reminder)
    }
}

data class UiState(
    val data: List<Reminder> = emptyList()
)
