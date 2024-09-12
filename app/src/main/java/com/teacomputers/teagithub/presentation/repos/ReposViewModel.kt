package com.teacomputers.teagithub.presentation.repos

import androidx.lifecycle.SavedStateHandle
import com.teacomputers.teagithub.domain.usecase.GetReposUseCase
import com.teacomputers.teagithub.presentation.base.BaseViewModel

class ReposViewModel(
    private val getReposUseCase: GetReposUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<ReposUiState, ReposUiEffect>(ReposUiState()), ReposInteractionListener {


}